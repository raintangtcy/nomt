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
 * MyCodeFactory.java
 * 
 * @author Rain Tang
 *         Dec 18, 2014 3:16:27 PM
 * @description
 */
package org.nomt.master.mina.filter.mycode;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineDecoder;
import org.apache.mina.filter.codec.textline.TextLineEncoder;

/**
 * @author Rain Tang
 *
 */
public class MyCodeFactory implements ProtocolCodecFactory
{
    private final TextLineEncoder encoder;

    private final TextLineDecoder decoder;

    /* final static char endchar = 0x1a; */
    final static char endchar = 0x0d;

    public MyCodeFactory()
    {
        this(Charset.forName("utf-8"));
    }

    public MyCodeFactory(Charset charset)
    {
        encoder = new TextLineEncoder(charset, LineDelimiter.UNIX);
        decoder = new TextLineDecoder(charset, LineDelimiter.AUTO);
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception
    {
        // TODO Auto-generated method stub
        return decoder;
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception
    {
        // TODO Auto-generated method stub
        return encoder;
    }

    public int getEncoderMaxLineLength()
    {
        return encoder.getMaxLineLength();
    }

    public void setEncoderMaxLineLength(int maxLineLength)
    {
        encoder.setMaxLineLength(maxLineLength);
    }

    public int getDecoderMaxLineLength()
    {
        return decoder.getMaxLineLength();
    }

    public void setDecoderMaxLineLength(int maxLineLength)
    {
        decoder.setMaxLineLength(maxLineLength);
    }
}
