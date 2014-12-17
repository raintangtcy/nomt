package org.nomt.master.mina.filter;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class DpiLogCodecFactory implements ProtocolCodecFactory
{
    private final DpiLogEncoder encoder;

    private final DpiLogDecoder decoder;

    public DpiLogCodecFactory()
    {
        encoder = new DpiLogEncoder();
        decoder = new DpiLogDecoder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.mina.filter.codec.ProtocolCodecFactory#getDecoder(org.apache
     * .mina.core.session.IoSession)
     */
    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception
    {
        return decoder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.mina.filter.codec.ProtocolCodecFactory#getEncoder(org.apache
     * .mina.core.session.IoSession)
     */
    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception
    {
        return encoder;
    }
}
