package org.nomt.master.mina.filter;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class DpiLogEncoder implements ProtocolEncoder
{

    @Override
    public void encode(IoSession session, Object message,
            ProtocolEncoderOutput out) throws Exception
    {
        IoBuffer buf = IoBuffer.allocate(12);
        buf.setAutoExpand(true);
        if (message instanceof DpiMessage)
        {
            DpiMessage dpiMessage = (DpiMessage) message;
            // 将消息头和消息体分别放入Iobuffer
            buf.put(dpiMessage.getChecksumAndSeqNo());
            setContentLengthByte(buf, dpiMessage.getLength());
            buf.put(dpiMessage.getBody().toString().getBytes("utf-8"));

            buf.flip();
            out.write(buf);
        }

    }

    @Override
    public void dispose(IoSession session) throws Exception
    {
        // TODO Auto-generated method stub

    }

    /**
     * @Author : echutag
     * @Description : 包装消息头
     * @return
     */
    public static void setContentLengthByte(IoBuffer buf, int contenlength)
    {
        // 计算长度的数组长度, 并倒序放入表示长度的byte数组
        final byte[] lenPart = Convert.int2bytesSigned(contenlength);
        // System.out.println("lenPart : " + Convert.bytes2HexStr(lenPart));
        int i = lenPart.length;
        for (; i > 0; i--)
        {
            buf.put(lenPart[i - 1]);
        }

        // 补满4个表长度的字节, 不够的补0
        final int j = 4 - lenPart.length;
        int k = 0;
        for (; k < j; k++)
        {
            buf.put((byte) 0x00);
        }
    }

}
