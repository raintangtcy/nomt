package org.nomt.agent.conf;

import org.apache.commons.lang.SystemUtils;
import org.nomt.base.conf.AbstractConfigUtil;

public class AgentConfig extends AbstractConfigUtil
{

    @Override
    public String getPropertiesFilePath()
    {
        String agentConfigFile;
        if (SystemUtils.IS_OS_WINDOWS)
        {
            agentConfigFile = "C:/home/nomt/config/agentConfig.properties";
        }
        else
        {
            agentConfigFile = "/home/nomt/config/agentConfig.properties";
        }

        return agentConfigFile;
    }

}
