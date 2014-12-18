package org.nomt.master.conf;

import org.apache.commons.lang.SystemUtils;
import org.nomt.base.conf.AbstractConfigUtil;

public class MasterConfig extends AbstractConfigUtil
{
    private static final MasterConfig instance = new MasterConfig();

    private MasterConfig()
    {
    }

    @Override
    public String getPropertiesFilePath()
    {
        String agentConfigFile;
        if (SystemUtils.IS_OS_WINDOWS)
        {
            agentConfigFile = "C:/home/nomt/config/nomtMaster.properties";
        }
        else
        {
            agentConfigFile = "/home/nomt/config/nomtMaster.properties";
        }

        return agentConfigFile;
    }

    /**
     * @description 返回配置中是否打开SNMP agent功能的开关
     * @return
     * @author Rain Tang
     */
    public boolean isSnmpAgentEnable()
    {
        return getBoolean("snmp.agent.enble");
    }

    /**
     * @description 返回CPU核心数
     * @return
     * @author Rain Tang
     */
    public int getCpuCoreNumber()
    {
        return getIntValue("mina.cpu.core.number");
    }

    public static MasterConfig getInstance()
    {
        return instance;
    }

    /**
     * @description mina的read buffer大小
     * @return
     * @author Rain Tang
     */
    public int getMinaReadBufferSize()
    {
        return getIntValue("mina.read.buffer.size");
    }

    /**
     * @description mina的receive buffer大小
     * @return
     * @author Rain Tang
     */
    public int getMinaReceiveBufferSize()
    {
        return getIntValue("mina.receive.buffer.size");
    }

    /**
     * @description mina服务端端口
     * @return
     * @author Rain Tang
     */
    public int getMinaServerPort()
    {
        return getIntValue("mina.client.port");
    }

    /**
     * @description mina服务器启动失败后，重启等待时间
     * @return
     * @author Rain Tang
     */
    public long getRestartInterval()
    {
        return getLongValue("mina.restart.interval");
    }

    public int getMinaThreadPoolSize()
    {
        return getIntValue("mina.thread.pool.size");
    }

}
