/**
 * @title: Constants.java
 * @description:
 */
package org.nomt.base.constants;

/**
 * @author : Rain Tang
 * @Description :
 */
public class BaseConstants
{
    /**
     * SERVER_MASTER
     *
     * @Description : 主服务器
     */
    public static final String SERVER_MASTER = "master";

    /**
     * SERVER_SLAVE
     *
     * @Description : 备服务器
     */
    public static final String SERVER_SLAVE = "slave";

    /**
     * HEART_BEAT
     *
     * @Description : 心跳包的二进制数组
     */
    public static final byte[] HEART_BEAT = { (byte) 0x84, (byte) 0x83,
            (byte) 0x82, (byte) 0x81, 0x00, 0x00, 0x00, 0x00 };

    /**
     * HEART_BEAT
     *
     * @Description : 心跳包的二进制数组
     */
    public static final byte[] CHECK_SUM = { (byte) 0x84, (byte) 0x83,
            (byte) 0x82, (byte) 0x81 };

    /**
     * HEADER_LEN
     *
     * @Description : DPI 消息头的固定长度, 12字节, 前4字节为校验码0x84838281, 中间4字节为序号,
     *              后4字节为消息体长度
     */
    public static final int HEADER_LEN = 12;

    /** yyyyMMdd 日期格式 */
    public final static String YYYYMMDD = "yyyyMMdd"; // 按日期分类 的目录将使用该格式

    /** yyyyMMddHHmmss 日期格式 */
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /** yyyyMMddHHmmss 日期格式 */
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /** yyyyMMddHHmm 日期格式 */
    public final static String YYYYMMDDHHMM = "yyyyMMddHHmm";
}
