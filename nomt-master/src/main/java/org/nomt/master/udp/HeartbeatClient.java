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
 * HeartbeatClient.java
 *
 * @author Rain Tang
 *         Dec 19, 2014 9:57:54 AM
 * @description
 */
package org.nomt.master.udp;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;
import org.nomt.base.constants.BaseConstants;
import org.nomt.base.network.NetworkEndIf;
import org.nomt.master.conf.MasterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public class HeartbeatClient extends IoHandlerAdapter implements NetworkEndIf
{

    /**
     * session
     *
     * @Description 用于发送的session
     */
    private IoSession session;

    /**
     * connector
     *
     * @Description 连接用的客户端
     */
    private IoConnector connector;

    private static Logger logger = LoggerFactory
            .getLogger(HeartbeatClient.class);

    private ConnectFuture connFuture;

    private IoFutureListener<IoFuture> futureListener;

    private InetSocketAddress targetAddress;

    private static final HeartbeatClient instance = new HeartbeatClient();

    /**
     * @author Rain Tang
     * @description 在线网元IP列表
     */
    private static List<String> aliveNodeList = new ArrayList<String>();

    private MasterConfig config = MasterConfig.getInstance();

    private HeartbeatClient()
    {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.nomt.base.network.NetworkEndIf#start()
     */
    @Override
    public boolean start()
    {
        Iterator<String> ipsIterator = getAliveNodeList().iterator();
        while (ipsIterator.hasNext())
        {
            String nextIp = ipsIterator.next();
            setTargetAddress(new InetSocketAddress(nextIp,
                    config.getHeartbeatServerPort()));
            connector = new NioDatagramConnector();

            connector.setHandler(this);
            connector.setDefaultRemoteAddress(getTargetAddress());
            connector.setConnectTimeoutMillis(10000);

            logger.debug("Send heartbeat to {}", getTargetAddress());
            connFuture = connector.connect(getTargetAddress());
            futureListener = new IoFutureListener<IoFuture>()
            {
                @Override
                public void operationComplete(IoFuture future)
                {
                    logger.trace("Heartbeat connection to {} is established.",
                            getTargetAddress());
                    session = future.getSession();

                    logger.trace("Heartbeat session:{}, isConnected:{}",
                            session, session.isConnected());
                    final IoBuffer hbBuffer = IoBuffer.allocate(8);
                    hbBuffer.put(BaseConstants.HEART_BEAT);
                    hbBuffer.flip();

                    // session.write(hbBuffer);
                    logger.debug("{}, {} is alive.", new SimpleDateFormat(
                            BaseConstants.YYYY_MM_DD_HH_MM_SS).format(System
                            .currentTimeMillis()), session.getRemoteAddress());
                    session.close(false);
                };
            };
            connFuture.addListener(futureListener);
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.nomt.base.network.NetworkEndIf#stop()
     */
    @Override
    public boolean stop()
    {
        return false;
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception
    {
        logger.info("Exception while sending heartbeat.");
        session.close(true);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception
    {
        logger.debug("Session closed. session:{}", session);
        // connFuture = connector.connect();
        // connFuture.addListener(futureListener);
        // logger.debug("reconnect connector {}",
        // connector.getDefaultRemoteAddress());
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception
    {
        // logger.debug("Hearbeat response received from {}, message={}.",
        // session
        // .getRemoteAddress().toString(), message);
        // // TODO 更新在线网元列表
        //
        // // 关闭连接，以便轮询下一个网元
        // logger.trace("Close heartbeat connection {}.", session);
        // session.close(false);
    }

    public static HeartbeatClient getInstance(List<String> aliveNodesIp)
    {
        setAliveNodeList(aliveNodesIp);
        return instance;
    }

    public InetSocketAddress getTargetAddress()
    {
        return targetAddress;
    }

    public HeartbeatClient setTargetAddress(InetSocketAddress targetAddress)
    {
        this.targetAddress = targetAddress;
        return this;
    }

    public static List<String> getAliveNodeList()
    {
        return aliveNodeList;
    }

    public static void setAliveNodeList(List<String> aliveNodeList)
    {
        HeartbeatClient.aliveNodeList = aliveNodeList;
    }

}
