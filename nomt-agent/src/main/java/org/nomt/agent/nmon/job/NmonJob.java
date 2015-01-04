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
 * NmonJob.java
 *
 * @author Rain Tang
 *         Dec 26, 2014 8:18:31 PM
 * @description
 */
package org.nomt.agent.nmon.job;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.SystemUtils;
import org.nomt.agent.conf.AgentConfig;
import org.nomt.agent.nmon.NmonDataFiles;
import org.nomt.base.shell.ShellUtil;
import org.nomt.base.thread.ThreadUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Rain Tang
 *
 */
public class NmonJob extends QuartzJobBean implements QuartzJobIf
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void perform()
    {
        logger.debug("NmonJob.perform()");
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        AgentConfig config = AgentConfig.getInstance();
        String nmonDir = config.getNmonBinaryDir();
        String nmonDataDir = config.getNmonOutputDir();
        String nmonFileName = nmonDataDir + SystemUtils.FILE_SEPARATOR
                + "nmon_data_" + sdFormat.format(System.currentTimeMillis())
                + ".nmon";
        String nmonCmd = nmonDir + SystemUtils.FILE_SEPARATOR + "nmon -c 1 -F "
                + nmonFileName;
        String executeCommand = ShellUtil.getInstance().executeCommand(nmonCmd);
        logger.debug("Execute command {}, execute result is {}", nmonCmd,
                executeCommand);

        // wait 3 seconds in case the nmon file is not finished.
        ThreadUtil.sleep(3000);

        NmonDataFiles.putNewFile(nmonFileName);
    }

    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException
    {
        perform();
    }

}
