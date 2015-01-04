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
 * NmonDataFiles.java
 *
 * @author Rain Tang
 *         Dec 27, 2014 2:19:06 PM
 * @description
 */
package org.nomt.agent.nmon;

import java.util.ArrayDeque;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public class NmonDataFiles
{
    private static final int QUEUE_SIZE = 10;

    private static Queue<String> nmonDataFilesQueue = new ArrayDeque<String>(10);

    private static Logger logger = LoggerFactory.getLogger(NmonDataFiles.class);

    synchronized public static String getNextFile()
    {
        String poll = nmonDataFilesQueue.poll();
        logger.debug("{} is retreived from nmonDataFilesQueue.", poll);
        return poll;
    }

    synchronized public static void putNewFile(String file)
    {
        if (nmonDataFilesQueue.size() == QUEUE_SIZE)
        {
            logger.debug("nmonDataFilesQueue is full, remove one.");
            nmonDataFilesQueue.remove();
        }
        nmonDataFilesQueue.offer(file);
        logger.debug("Put {} into nmonDataFilesQueue.", file);
    }
}
