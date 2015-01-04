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
 * ParserJob.java
 *
 * @author Rain Tang
 *         Dec 26, 2014 8:20:27 PM
 * @description
 */
package org.nomt.agent.nmon.job;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.nomt.agent.nmon.NmonDataFiles;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Rain Tang
 *
 */
public class ParserJob extends QuartzJobBean implements QuartzJobIf
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    /*
     * (non-Javadoc)
     *
     * @see org.nomt.agent.nmon.task.QuartzJobIf#perform()
     */
    @Override
    public void perform()
    {
        logger.info("ParserJob.perform()");
        String filename = NmonDataFiles.getNextFile();
        File nmonDataFile = new File(filename);
        logger.debug("Found nmon file {}, start to parser it.", filename);
        try
        {
            LineIterator lineIterator = FileUtils.lineIterator(nmonDataFile,
                    "utf-8");
            while (lineIterator.hasNext())
            {
                String nextLine = lineIterator.next();
                String[] lineParts = nextLine.split(",");
                if (lineParts[1].equalsIgnoreCase("T0001"))
                {
                    // CPU_ALL,T0001,1.9,3.8,0.0,94.3,,1
                    if (lineParts[0].equalsIgnoreCase("ZZZZ"))
                    {
                        // ZZZZ,T0001,21:20:01,26-DEC-2014

                    }
                }
                if (lineParts[2].equalsIgnoreCase("uptime"))
                {
                    if (lineParts.length > 3)
                    {
                        // BBBP,284,uptime," 21:20:00 up  2:08,  2 users,  load average: 0.00, 0.00, 0.00"
                        String[] load_1_2_3 = lineParts[3].substring(1,
                                lineParts[3].length() - 2).split(",")[2]
                                .split(":")[1].split(",");
                    }
                }
            }
        }
        catch (IOException e)
        {
            logger.info("IOException while parsering {}.", filename);
        }

        FileUtils.deleteQuietly(nmonDataFile);
        logger.debug("After parsering, delete file {}.", filename);
    }

    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException
    {
        perform();
    }

}
