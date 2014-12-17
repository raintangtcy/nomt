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

import org.apache.mina.transport.socket.SocketAcceptor;
import org.nomt.agent.conf.AgentConfig;
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

    private AgentConfig config = AgentConfig.getInstance();

    /*
     * (non-Javadoc)
     *
     * @see org.nomt.base.network.NetworkEndIf#start()
     */
    @Override
    public boolean start()
    {

        return false;
    }

    @Override
    public boolean stop()
    {
        return false;
    }

}
