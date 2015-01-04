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
 * HeartbeatServer.java
 *
 * @author Rain Tang
 *         Dec 19, 2014 9:52:16 AM
 * @description
 */
package org.nomt.agent.udp;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.nomt.agent.conf.AgentConfig;
import org.nomt.base.network.NetworkEndIf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public class HeartbeatServer implements NetworkEndIf
{
    private AgentConfig config = AgentConfig.getInstance();

    private Logger logger = LoggerFactory.getLogger(HeartbeatServer.class);

    private static final HeartbeatServer instance = new HeartbeatServer();

    private NioDatagramAcceptor acceptor = null;

    private HeartbeatServer()
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
        acceptor = new NioDatagramAcceptor();
        acceptor.setHandler(new HeartbeatHandler());

        final DatagramSessionConfig dcfg = acceptor.getSessionConfig();
        dcfg.setReuseAddress(true);
        dcfg.setCloseOnPortUnreachable(true);

        try
        {
            int heartbeatReceivePort = config.getHeartbeatServerPort();

            acceptor.bind(new InetSocketAddress(heartbeatReceivePort));
            logger.debug("Agent hearbeat server start listening to port "
                    + heartbeatReceivePort + ".");

        }
        catch (final IOException exception)
        {
            logger.error("Start agent heatbeat server failed.", exception);
            return false;
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
        if (acceptor != null)
        {
            acceptor.dispose(false);
            acceptor = null;
        }

        return true;
    }

    public static HeartbeatServer getInstance()
    {
        return instance;
    }

}
