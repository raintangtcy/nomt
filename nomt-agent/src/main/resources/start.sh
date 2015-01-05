#!/bin/bash
#
#
#

######################
# Initialize classpath
MODULE_NAME=nomt-agent
MODULE_PATH=`dirname $0`
cd ${MODULE_PATH}

# Here add aditional classpath to fit your runtime environment
myclasspath=.:../config
LIB=../lib
for i in `ls ${LIB}/*.jar` 
do
	myclasspath=$myclasspath:$i
done

# Here modify main_class to fit your runtime environment 
main_class=org.nomt.agent.main.NomtAgentMain
version_class=org.nomt.agent.main.Version

######################
# Main 
######################
mkdir -p ../log/
mkdir -p ../nmon/output
chmod +x ../nmon/nmon

function checkpid() {
    local i
    for i in $* ; do
        if [ -d "/proc/${i}" ]; then
            return 0
        fi
    done
    return 1
}

##########################################
#
# main
#
#JAVA_ARGS="-Dfile.encoding=GB2312"
case "$1" in
'start')
	# check if had started
	if [ -f ${MODULE_NAME}.pid ] ; then
		modulepid=`cat ${MODULE_NAME}.pid`
		if [ "x"${modulepid} != "x" ]; then
			if checkpid $modulepid 2>&1; then
				echo "${MODULE_NAME} had started! "
				exit 0
			fi
		fi
	fi

	echo execute $MODULE_NAME ...
	shift
	
	nohup java -server -Dlog.property.file="../config/nomtAgent.properties" -Dfile.encoding=UTF-8 -Xmx1024m -Xms1024m ${JAVA_ARGS} -cp ${myclasspath}  ${main_class} $*  > ../log/debug.log 2>&1  <&- &
	daemon_pid=$!
	if ps -p "${daemon_pid}" >/dev/null 2>&1
	then
  		# daemon is running.
  		echo ${daemon_pid} > ${MODULE_NAME}.pid
  		echo " done."
	else
  		echo "Daemon did not start."
	fi
	;;
'stop')
	if [ ! -f ${MODULE_NAME}.pid ] ; then
       		echo "Read ${MODULE_NAME}.pid file fail, please kill process manually!"
        	exit 0
	fi
	pid_tobe_killed=`cat ${MODULE_NAME}.pid`
	echo process to be killed ${pid_tobe_killed}

	kill -9 ${pid_tobe_killed}
	
	rm -rf ${MODULE_NAME}.pid
	;;
'version')
	java -cp ${myclasspath} ${version_class}
	;;
'status')
	if [ -f ${MODULE_NAME}.pid ] ; then
		read pid < ${MODULE_NAME}.pid
		if checkpid $pid 2>&1; then
			echo "$0 is running $pid"
			exit 0
		fi
	fi
	echo "$0 is not running"
	exit 1
	;;
*)
	echo "Usage: $0 { start | stop | version | status }"
	exit 1
	;;
esac
		
exit 0
