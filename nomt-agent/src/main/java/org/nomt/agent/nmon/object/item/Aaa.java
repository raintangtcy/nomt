/*
 * --------------------------------------------------------------------------
 * COPYRIGHT Ericsson Telecommunicatie B.V., 2014
 * All rights reserved
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Telecommunicatie B.V.. The programs may be used and/or
 * copied only with written permission from Ericsson Telecommunicatie
 * B.V. or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the program(s) have been supplied.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT ARE DISCLAIMED.
 * ERICSSON TELECOMMUNICATIE B.V. SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 * --------------------------------------------------------------------------
 */

/**
 * Aaa.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 3:37:48 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;

/**
 * @author Rain Tang
 *
 */
public class Aaa implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = -5462823597180998568L;

    /**
     * @author Rain Tang
     * @description AAA,progname,nmon
     */
    private String programName;

    /**
     * @author Rain Tang
     * @description AAA,command,./nmon -c 1 -F nmon_test.nmon
     */
    private String command;

    /**
     * @author Rain Tang
     * @description AAA,version,14i
     */
    private String nmonVersion;

    /**
     * @author Rain Tang
     * @description AAA,disks,5,
     */
    private String disks;

    /**
     * @author Rain Tang
     * @description AAA,host,stm01
     */
    private String host;

    /**
     * @author Rain Tang
     * @description AAA,user,root
     */
    private String user;

    /**
     * @author Rain Tang
     * @description AAA,OS,Linux,2.6.32-358.el6.x86_64,#1 SMP Tue Jan 29
     *              11:47:41 EST 2013,x86_64
     */
    private String osName;

    /**
     * @author Rain Tang
     * @description AAA,time,11:02.09
     */
    private String time;

    /**
     * @author Rain Tang
     * @description AAA,date,04-JAN-2015
     */
    private String date;

    /**
     * @author Rain Tang
     * @description AAA,interval,300
     */
    private String interval;

    /**
     * @author Rain Tang
     * @description AAA,cpus,24
     */
    private String cpus;

    public String getProgramName()
    {
        return programName;
    }

    public void setProgramName(String programName)
    {
        this.programName = programName;
    }

    public String getCommand()
    {
        return command;
    }

    public void setCommand(String command)
    {
        this.command = command;
    }

    public String getNmonVersion()
    {
        return nmonVersion;
    }

    public void setNmonVersion(String nmonVersion)
    {
        this.nmonVersion = nmonVersion;
    }

    public String getDisks()
    {
        return disks;
    }

    public void setDisks(String disks)
    {
        this.disks = disks;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getOsName()
    {
        return osName;
    }

    public void setOsName(String osName)
    {
        this.osName = osName;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getInterval()
    {
        return interval;
    }

    public void setInterval(String interval)
    {
        this.interval = interval;
    }

    public String getCpus()
    {
        return cpus;
    }

    public void setCpus(String cpus)
    {
        this.cpus = cpus;
    }
}
