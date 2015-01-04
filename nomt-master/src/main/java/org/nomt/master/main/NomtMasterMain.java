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
 * NomtMasterMain.java
 *
 * @author Rain Tang
 *         Dec 18, 2014 3:29:43 PM
 * @description
 */
package org.nomt.master.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.nomt.base.thread.ThreadUtil;
import org.nomt.master.conf.MasterConfig;
import org.nomt.master.udp.HeartbeatClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public class NomtMasterMain
{
    private static Logger logger = LoggerFactory
            .getLogger(NomtMasterMain.class);

    public static void main(String[] args)
    {
        MasterConfig config = MasterConfig.getInstance();
        ThreadUtil.scheduleTask(new Timer("timer1"), new TimerTask()
        {

            @Override
            public void run()
            {
                List<String> aliveNodesIp = new ArrayList<String>();
                aliveNodesIp.add("127.0.0.1");

                logger.debug(
                        "Heartbeat job start. Following NE will be checked. {}",
                        aliveNodesIp);

                HeartbeatClient heartbeatClient = HeartbeatClient
                        .getInstance(aliveNodesIp);
                heartbeatClient.start();
            }
        }, 0, config.getIntervalHeartbeat() * 1000);
    }

}
