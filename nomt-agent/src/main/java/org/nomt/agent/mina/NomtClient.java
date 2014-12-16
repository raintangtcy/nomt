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
 * NomtClient.java
 *
 * @author Rain Tang
 *         Dec 16, 2014 5:35:24 PM
 * @description
 */
package org.nomt.agent.mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.executor.UnorderedThreadPoolExecutor;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.nomt.base.conf.ConfigUtil;
import org.nomt.base.network.NetworkEndIf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public class NomtClient implements NetworkEndIf
{
    private final Logger logger = LoggerFactory.getLogger(NomtClient.class);

    private SocketAcceptor socketAcceptor;

    /*
     * (non-Javadoc)
     *
     * @see org.nomt.base.network.NetworkEndIf#start()
     */
    @Override
    public boolean start()
    {
        logger.trace("Prepare to start server.");
        stop();

        socketAcceptor = new NioSocketAcceptor(
                ConfigUtil.getServerProcessorCount());

        final DefaultIoFilterChainBuilder filterChain = socketAcceptor
                .getFilterChain();
        final SocketSessionConfig sessionConfig = socketAcceptor
                .getSessionConfig();
        sessionConfig.setReadBufferSize(Constants.READ_BUFFEREDSIZE);
        sessionConfig.setReceiveBufferSize(Constants.RECEVIE_BUFFEREDSIZE);
        filterChain.addLast("codec", new ProtocolCodecFilter(
                new DpiLogCodecFactory()));
        filterChain.addLast("Executors", new ExecutorFilter(
                new UnorderedThreadPoolExecutor(50)));
        socketAcceptor.setHandler(ServerHandler.getInstance());

        final int port = ConfigUtil.getServerPort();
        try
        {

            socketAcceptor.bind(new InetSocketAddress(port));
            logger.debug("Log server start successfully. Listen on port : {}",
                    port);
        }
        catch (final IOException ex)
        {

            try
            {
                logger.error("port bind failed ,try to bind 2 times");
                Thread.sleep(ConfigUtil.getRestartInterval());
                socketAcceptor.bind(new InetSocketAddress(port));
                logger.debug(
                        "Log server start successfully. Listen on port : {}",
                        port);
            }
            catch (IOException e)
            {
                // add alarm ,collertor start fail
                logger.error("Bind port {} failed.", port, ex);
                OmcWriter.writeWarning("alarm.dpi.collector.start.fail", null,
                        AlarmStatus.ALARM_ERROR_LEVEL);
            }
            catch (InterruptedException e)
            {
                // add alarm ,collertor start fail
                logger.error("Bind port {} failed.", port, ex);
                OmcWriter.writeWarning("alarm.dpi.collector.start.fail", null,
                        AlarmStatus.ALARM_ERROR_LEVEL);
            }

        }
        return false;
    }

    @Override
    public boolean stop()
    {

        if (socketAcceptor != null)
        {
            try
            {
                socketAcceptor.dispose();
                logger.info("DPI collector server stopped.");
            }
            catch (final Throwable err)
            {
                logger.error(err.toString());
            }
            finally
            {
                socketAcceptor = null;
            }
        }

        return false;
    }

}
