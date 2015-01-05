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
import org.nomt.agent.nmon.object.NmonFileInfo;
import org.nomt.agent.nmon.object.item.Aaa;
import org.nomt.agent.nmon.object.item.CpuAll;
import org.nomt.agent.nmon.object.item.CpuX86;
import org.nomt.agent.nmon.object.item.DiskBsize;
import org.nomt.agent.nmon.object.item.DiskBusy;
import org.nomt.agent.nmon.object.item.DiskRead;
import org.nomt.agent.nmon.object.item.DiskWrite;
import org.nomt.agent.nmon.object.item.DiskXfer;
import org.nomt.agent.nmon.object.item.JfsInode;
import org.nomt.agent.nmon.object.item.Mem;
import org.nomt.agent.nmon.object.item.Net;
import org.nomt.agent.nmon.object.item.NetPacket;
import org.nomt.agent.nmon.object.item.Proc;
import org.nomt.agent.nmon.util.NmonDataFiles;
import org.nomt.agent.nmon.util.NmonFileInfoRepo;
import org.nomt.agent.nmon.util.NmonLineParser;
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
            Aaa aaa = new Aaa();
            CpuX86 cpuX86 = new CpuX86();
            CpuAll cpuAll = new CpuAll();
            Mem mem = new Mem();
            Net net = new Net();
            NetPacket netPacket = new NetPacket();
            DiskBusy diskBusy = new DiskBusy();
            DiskBsize diskBsize = new DiskBsize();
            DiskRead diskRead = new DiskRead();
            DiskWrite diskWrite = new DiskWrite();
            DiskXfer diskXfer = new DiskXfer();
            JfsInode jfsInode = new JfsInode();
            Proc proc = new Proc();

            String nextLine;
            String[] lineParts;
            String part0, part1;
            String[] netTitleLineParts = null;
            String[] netPacketTitleLineParts = null;
            String[] jfsLineParts = null;
            String[] diskBusyLineParts = null;
            String[] diskReadLineParts = null;
            String[] diskWriteLineParts = null;
            String[] diskBsizeLineParts = null;
            String[] diskXferLineParts = null;

            while (lineIterator.hasNext())
            {
                nextLine = lineIterator.next();
                lineParts = nextLine.split(",");
                part0 = lineParts[0];
                part1 = lineParts[1];
                if ("AAA".equalsIgnoreCase(part0))
                {
                    if (lineParts.length == 3)
                    {
                        NmonLineParser.parseAaa(aaa, lineParts);
                    }
                    else if (lineParts.length == 4)
                    {
                        NmonLineParser.parseCpuX86(cpuX86, lineParts);
                    }
                }
                else if ("T0001".equalsIgnoreCase(part1))
                {
                    if ("CPU_ALL".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseCpuAll(cpuAll, lineParts);
                    }
                    else if ("MEM".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseMem(mem, lineParts);
                    }
                    else if ("NET".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseNet(net, netTitleLineParts,
                                lineParts);
                    }
                    else if ("NETPACKET".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseNetPacket(netPacket,
                                netPacketTitleLineParts, lineParts);
                    }
                    else if ("JFSFILE".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseJfsInode(jfsInode, jfsLineParts,
                                lineParts);
                    }
                    else if ("DISKBUSY".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseDiskBusy(diskBusy,
                                diskBusyLineParts, lineParts);
                    }
                    else if ("DISKREAD".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseDiskRead(diskRead,
                                diskReadLineParts, lineParts);
                    }
                    else if ("DISKWRITE".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseDiskWrite(diskWrite,
                                diskWriteLineParts, lineParts);
                    }
                    else if ("DISKXFER".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseDiskXfer(diskXfer,
                                diskXferLineParts, lineParts);
                    }
                    else if ("DISKBSIZE".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseDiskBsize(diskBsize,
                                diskBsizeLineParts, lineParts);
                    }
                    else if ("PROC".equalsIgnoreCase(part0))
                    {
                        NmonLineParser.parseProc(proc, lineParts);
                    }
                }
                else if ("NET".equalsIgnoreCase(part0))
                {
                    netTitleLineParts = lineParts;
                }
                else if ("NETPACKET".equalsIgnoreCase(part0))
                {
                    netPacketTitleLineParts = lineParts;
                }
                else if ("JFSFILE".equalsIgnoreCase(part0))
                {
                    jfsLineParts = lineParts;
                }
                else if ("DISKBUSY".equalsIgnoreCase(part0))
                {
                    diskBusyLineParts = lineParts;
                }
                else if ("DISKREAD".equalsIgnoreCase(part0))
                {
                    diskReadLineParts = lineParts;
                }
                else if ("DISKWRITE".equalsIgnoreCase(part0))
                {
                    diskWriteLineParts = lineParts;
                }
                else if ("DISKXFER".equalsIgnoreCase(part0))
                {
                    diskXferLineParts = lineParts;
                }
                else if ("DISKBSIZE".equalsIgnoreCase(part0))
                {
                    diskBsizeLineParts = lineParts;
                }

            }

            NmonFileInfo nmonFileInfo = new NmonFileInfo();
            nmonFileInfo.setAaa(aaa);
            nmonFileInfo.setX86(cpuX86);
            nmonFileInfo.setCpuAll(cpuAll);
            nmonFileInfo.setNet(net);
            nmonFileInfo.setNetPacket(netPacket);
            nmonFileInfo.setMem(mem);
            nmonFileInfo.setJfsInode(jfsInode);
            nmonFileInfo.setDiskBusy(diskBusy);
            nmonFileInfo.setDiskRead(diskRead);
            nmonFileInfo.setDiskWrite(diskWrite);
            nmonFileInfo.setDiskXfer(diskXfer);
            nmonFileInfo.setBsize(diskBsize);
            NmonFileInfoRepo.setContent(nmonFileInfo);
            logger.debug("Parse Nmon File {} successfully.", filename);
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
