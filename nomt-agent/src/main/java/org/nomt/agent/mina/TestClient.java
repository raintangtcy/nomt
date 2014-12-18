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
 * TestClient.java
 *
 * @author Rain Tang
 *         Dec 18, 2014 3:21:19 PM
 * @description
 */
package org.nomt.agent.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * @author Rain Tang
 *
 */
public class TestClient
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // 创建客户端连接器.
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast(
                "codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset
                        .forName("utf-8")))); // 设置编码过滤器
        connector.setHandler(new HandlerOne());// 设置事件处理器
        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1",
                8686));// 建立连接
        cf.awaitUninterruptibly();// 等待连接创建完成
        cf.getSession().write("知识");// 发送消息
        cf.getSession().close(true);
        cf.getSession().getCloseFuture().awaitUninterruptibly();// 等待连接断开
        connector.dispose();

    }

}
