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
 * TimeHandler.java
 *
 * @author Rain Tang
 *         Dec 18, 2014 2:01:33 PM
 * @description
 */
package org.nomt.agent.mina.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public class TimeHandler extends IoHandlerAdapter
{

    private Logger logger = LoggerFactory.getLogger(TimeHandler.class);

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception
    {
        logger.debug("exceptionCaught, {}", cause);
        super.exceptionCaught(session, cause);
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception
    {
        logger.debug("messageReceived, message={}", message);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception
    {
        logger.debug("sessionIdle, status={}", status);
        super.sessionIdle(session, status);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception
    {
        logger.debug("sessionClosed.");
        super.sessionClosed(session);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception
    {
        logger.debug("messageSent, message={}", message);
        super.messageSent(session, message);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception
    {
        logger.debug("sessionOpened.");
        super.sessionOpened(session);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception
    {
        logger.debug("sessionCreated.");
        super.sessionCreated(session);
    }

    @Override
    public void inputClosed(IoSession session) throws Exception
    {
        logger.debug("inputClosed.");
        super.inputClosed(session);
    }
}
