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
 * HandlerOne.java
 * 
 * @author Rain Tang
 *         Dec 18, 2014 3:20:23 PM
 * @description
 */
package org.nomt.agent.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class HandlerOne extends IoHandlerAdapter
{
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception
    {
        // TODO Auto-generated method stub
        // super.messageReceived(session, message);
        System.out.println("message :" + message);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception
    {
        // TODO Auto-generated method stub
        super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception
    {
        // TODO Auto-generated method stub
        super.sessionIdle(session, status);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception
    {

        System.out.println("发送的消息是：" + message.toString());
        // super.messageSent(session, message);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception
    {

        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception
    {
        super.sessionOpened(session);
    }

}
