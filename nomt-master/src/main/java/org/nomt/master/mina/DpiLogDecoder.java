package org.nomt.master.mina;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DpiLogDecoder extends CumulativeProtocolDecoder
{
    private static Logger logger = LoggerFactory.getLogger(DpiLogDecoder.class);

    private static final byte[] CHECKSUM_CONST = { (byte) 0x84, (byte) 0x83,
            (byte) 0x82, (byte) 0x81 };

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in,
            ProtocolDecoderOutput out) throws Exception
    {
        // System.out.println("=====" + in.position());
        // 标记buffer初始化位置
        in.mark();
        if (in.remaining() < 12)
        {
            in.reset();
            return false;

        }
        // 获取消息头中校验字节
        final byte[] checksum_new = new byte[4];

        in.get(checksum_new);
        // 获取消息头中序列字节
        final byte[] sequenceNo_new = new byte[4];
        in.get(sequenceNo_new);
        // 获取消息头中字节消息体的内容大小
        final byte[] contentLengthByteType = new byte[4];
        in.get(contentLengthByteType);

        int contetnLength = Convert.getInt(contentLengthByteType);

        String strChecksum = Convert.bytes2HexStr(checksum_new);
        // 校验消息合法性
        if (!Arrays.equals(checksum_new, CHECKSUM_CONST))
        {
            logger.error("tcp message invalid {}", strChecksum);
            session.close(true);
            if (AlarmStatus.decodeLogStatus != AlarmStatus.ALARM_ERROR_HAPPENED)
            {
                OmcWriter.writeWarning("alarm.msg.decode.error", "checksum:"
                        + strChecksum, AlarmStatus.ALARM_ERROR_LEVEL);
                AlarmStatus.decodeLogStatus = AlarmStatus.ALARM_ERROR_HAPPENED;
            }
        }
        else
        {
            if (AlarmStatus.decodeLogStatus == AlarmStatus.ALARM_ERROR_HAPPENED)
            {
                OmcWriter.writeWarning("alarm.msg.decode.error", "checksum:"
                        + strChecksum, AlarmStatus.ALARM_CLEAR_LEVEL);
                AlarmStatus.decodeLogStatus = AlarmStatus.ALARM_ERROR_CLEARED;
            }
        }

        int contentLenhtTemp = in.remaining();

        if (contetnLength > contentLenhtTemp)
        {
            in.reset();
            return false;
        }
        // 获取消息内容
        final byte[] contentByte = new byte[contetnLength];

        in.get(contentByte);

        // String sysEncoding = System.getProperty("sun.jnu.encoding");
        String messageContent = new String(contentByte, "UTF-8");
        // 如果消息内容是要处理的日志内容，返回handler DpiMessage对象
        if (StringUtils.startsWithIgnoreCase(messageContent, "{\"act"))
        {
            DpiMessage message = new DpiMessage();
            message.setBody(new StringBuilder(messageContent));
            out.write(message);
        }
        else
        {
            out.write("");
        }
        ;

        // 如果有粘包现象，继续执行解码
        if (in.hasRemaining())
        {
            return true;
        }
        // System.out.println(contentBeginString.length());

        return false;
    }
}
