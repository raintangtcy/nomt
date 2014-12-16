package org.nomt.agent;

import org.nomt.agent.conf.AgentConfig;

public class AppTest
{
    public static void main(String[] args)
    {
        AgentConfig config = AgentConfig.getInstance();
        System.out.println(config.getCpuCoreNumber());

    }

}
