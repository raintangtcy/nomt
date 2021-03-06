package org.nomt.agent.conf;

import org.apache.commons.lang.SystemUtils;
import org.nomt.base.conf.AbstractConfigUtil;

public class AgentConfig extends AbstractConfigUtil
{
    private static final AgentConfig instance = new AgentConfig();

    private AgentConfig()
    {
    }

    @Override
    public String getPropertiesFilePath()
    {
        String agentConfigFile;
        if (SystemUtils.IS_OS_WINDOWS)
        {
            agentConfigFile = "C:/home/nomt/config/nomtAgent.properties";
        }
        else
        {
            agentConfigFile = ClassLoader.getSystemResource(
                    "nomtAgent.properties").getPath();
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

    public static AgentConfig getInstance()
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
        return getIntValue("mina.server.port");
    }

    public int getHeartbeatServerPort()
    {
        return getIntValue("mina.heartbeat.server.port");
    }

    public String getNmonBinaryDir()
    {
        return getStrValue("path.nmon.binary");
    }

    public String getNmonOutputDir()
    {
        return getStrValue("path.nmon.output");
    }

    /**
     * @description
     * @return
     * @author Rain Tang
     */
    public int getMinaThreadPoolSize()
    {
        return getIntValue("mina.thread.pool.size");
    }

    /**
     * @description
     * @return
     * @author Rain Tang
     */
    public long getRestartInterval()
    {
        return getLongValue("mina.restart.interval");
    }

}
