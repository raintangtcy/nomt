/**
 * @title HeartbeatHandler.java
 * @description
 */
package org.nomt.agent.udp;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author echutag
 * @Description 心跳包接收处理类
 */
public class HeartbeatHandler extends IoHandlerAdapter
{

    private Logger logger = LoggerFactory.getLogger(HeartbeatHandler.class);

    private static final String HB_STR = "84 83 82 81 00 00 00 00";

    private String currentIp;

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception
    {
        logger.debug("Message received:" + message);
        /*
         * 心跳包接收之后
         */
        final IoBuffer buffer = (IoBuffer) message;
        /*
         * 检查session
         */
        if (null == session || session.getRemoteAddress() == null
                || session.getRemoteAddress().toString().length() == 0)
        {
            logger.info("Session null or remote address null.");
            return;
        }

        /*
         * 检查心跳包内容
         */
        if (isChecksumOk(buffer))
        {
            /*
             * 检查发送源IP
             */
            currentIp = getIPaddressByScoketAddress(session.getRemoteAddress()
                    .toString());
            logger.debug("Heartbeat received. Source IP is {}", currentIp);
            session.write(buffer);
        }
        else
        {
            logger.info("Wrong heartbeat packet received. ");
        }

    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception
    {
        logger.debug("Exception in HeartbeatHandler,{}", cause);
    }

    /**
     * @Author echutag
     * @Description
     * @param buffer
     * @return
     */
    private boolean isChecksumOk(final IoBuffer buffer)
    {
        return buffer.getHexDump().equalsIgnoreCase(HB_STR);
    }

    /**
     * @Author echutag
     * @Description 从remoteAddress中分解出IP
     * @param sockeString
     * @return
     */
    private String getIPaddressByScoketAddress(String sockeString)
    {

        String[] tempStrings = sockeString.split(":");

        return tempStrings[0].split("/")[1];
    }

}
