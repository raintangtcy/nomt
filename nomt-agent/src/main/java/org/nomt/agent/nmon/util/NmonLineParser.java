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
 * NmonLineParser.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 4:41:01 PM
 * @description
 */
package org.nomt.agent.nmon.util;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 * @description
 */
public class NmonLineParser
{
    private static Logger logger = LoggerFactory
            .getLogger(NmonLineParser.class);

    /**
     * @description AAA line should be split into 3 parts, the first part is
     *              "AAA", the second part is property name, and the third part
     *              is the value, like "AAA,progname,nmon"
     * @param lineParts
     * @return
     * @author Rain Tang
     */
    public static void parseAaa(Aaa aaa, String[] lineParts)
    {
        String p1 = lineParts[1];
        String p2 = lineParts[2];
        if ("progname".equalsIgnoreCase(p1))
        {
            aaa.setProgramName(p2);
            logger.trace("Parse AAA progname: {}", p2);
        }
        else if ("command".equalsIgnoreCase(p1))
        {
            aaa.setCommand(p2);
            logger.trace("Parse AAA command: {}", p2);
        }
        else if ("version".equalsIgnoreCase(p1))
        {
            aaa.setNmonVersion(p2);
            logger.trace("Parse AAA version: {}", p2);
        }
        else if ("disks".equalsIgnoreCase(p1))
        {
            aaa.setDisks(p2);
            logger.trace("Parse AAA disks: {}", p2);
        }
        else if ("host".equalsIgnoreCase(p1))
        {
            aaa.setHost(p2);
            logger.trace("Parse AAA host: {}", p2);
        }
        else if ("user".equalsIgnoreCase(p1))
        {
            aaa.setUser(p2);
            logger.trace("Parse AAA user: {}", p2);
        }
        else if ("OS".equalsIgnoreCase(p1))
        {
            aaa.setOsName(p2);
            logger.trace("Parse AAA OS: {}", p2);
        }
        else if ("time".equalsIgnoreCase(p1))
        {
            aaa.setTime(p2);
            logger.trace("Parse AAA time: {}", p2);
        }
        else if ("date".equalsIgnoreCase(p1))
        {
            aaa.setDate(p2);
            logger.trace("Parse AAA date: {}", p2);
        }
        else if ("interval".equalsIgnoreCase(p1))
        {
            aaa.setInterval(p2);
            logger.trace("Parse AAA interval: {}", p2);
        }
        else if ("cpus".equalsIgnoreCase(p1))
        {
            aaa.setCpus(p2);
            logger.trace("Parse AAA cpus: {}", p2);
        }
    }

    public static void parseCpuX86(CpuX86 cpuX86, String[] lineParts)
    {
        String p2 = lineParts[2];
        String p3 = lineParts[3];
        if ("VendorId".equalsIgnoreCase(p2))
        {
            cpuX86.setVendorId(p3);
            logger.trace("Parse CpuX86 vendorId: {}", p3);
        }
        else if ("ModelName".equalsIgnoreCase(p2))
        {
            cpuX86.setModelName(p3);
            logger.trace("Parse CpuX86 ModelName: {}", p3);
        }
        else if ("MHz".equalsIgnoreCase(p2))
        {
            cpuX86.setMhz(p3);
            logger.trace("Parse CpuX86 MHz: {}", p3);
        }
        else if ("bogomips".equalsIgnoreCase(p2))
        {
            cpuX86.setBogomips(p3);
            logger.trace("Parse CpuX86 bogomips: {}", p3);
        }
        else if ("ProcessorChips".equalsIgnoreCase(p2))
        {
            cpuX86.setProcessorChips(p3);
            logger.trace("Parse CpuX86 ProcessorChips: {}", p3);
        }
        else if ("Cores".equalsIgnoreCase(p2))
        {
            cpuX86.setCores(p3);
            logger.trace("Parse CpuX86 Cores: {}", p3);
        }
        else if ("hyperthreads".equalsIgnoreCase(p2))
        {
            cpuX86.setHyperthreads(p3);
            logger.trace("Parse CpuX86 hyperthreads: {}", p3);
        }
        else if ("VirtualCPUs".equalsIgnoreCase(p2))
        {
            cpuX86.setVirtualCpus(p3);
            logger.trace("Parse CpuX86 VirtualCPUs: {}", p3);
        }
    }

    /**
     * @description CPU_ALL,CPU Total stm01,User%,Sys%,Wait%,Idle%,Busy,CPUs
     *              CPU_ALL,T0001,0.0,0.1,0.0,99.9,,24
     * @param cpuAll
     * @param lineParts
     * @author Rain Tang
     */
    public static void parseCpuAll(CpuAll cpuAll, String[] lineParts)
    {
        cpuAll.setUser(lineParts[2]);
        cpuAll.setSys(lineParts[3]);
        cpuAll.setWait(lineParts[4]);
        cpuAll.setIdle(lineParts[5]);
        cpuAll.setBusy(lineParts[6]);
        cpuAll.setCpus(lineParts[7]);
        logger.trace("Parse CpuAll, lineParts: {}", lineParts.toString());
    }

    /**
     * @description MEM,Memory MB
     *              stm01,memtotal,hightotal,lowtotal,swaptotal,memfree
     *              ,highfree,
     *              lowfree,swapfree,memshared,cached,active,bigfree,buffers
     *              ,swapcached,inactive
     *              MEM,T0001,48226.0,-0.0,-0.0,49152.0,45052.9,-0.0,-0.0,
     *              49152.0,-0.0,1439.2,1517.3,-1.0,364.3,0.0,900.5
     * @param mem
     * @param lineParts
     * @author Rain Tang
     */
    public static void parseMem(Mem mem, String[] lineParts)
    {
        mem.setMemTotal(lineParts[2]);
        mem.setHighTotal(lineParts[3]);
        mem.setLowTotal(lineParts[4]);
        mem.setSwapTotal(lineParts[5]);
        mem.setMemFree(lineParts[6]);
        mem.setHighFree(lineParts[7]);
        mem.setLowFree(lineParts[8]);
        mem.setSwapFree(lineParts[9]);
        mem.setMemShared(lineParts[10]);
        mem.setCached(lineParts[11]);
        mem.setActive(lineParts[12]);
        mem.setBigFree(lineParts[13]);
        mem.setBuffers(lineParts[14]);
        mem.setSwapCached(lineParts[15]);
        mem.setInactive(lineParts[16]);
        logger.trace("Parse Mem, lineParts: {}", lineParts.toString());
    }

    /**
     * @description NET,Network I/O
     *              stm01,lo-read-KB/s,eth0-read-KB/s,eth1-read-KB
     *              /s,bond0-read-KB
     *              /s,lo-write-KB/s,eth0-write-KB/s,eth1-write-KB
     *              /s,bond0-write-KB/s,
     *              NET,T0001,0.0,0.7,0.6,1.3,0.0,1.6,2.7,4.3,
     * @param net
     * @param lineParts
     * @author Rain Tang
     * @param lineTitleParts
     */
    public static void parseNet(Net net, String[] lineTitleParts,
            String[] lineParts)
    {
        int i;
        for (i = 2; i <= lineTitleParts.length / 2; i++)
        {
            net.getNetworkReadMap().put(lineTitleParts[i], lineParts[i]);
        }
        for (; i < lineTitleParts.length; i++)
        {
            net.getNetworkWriteMap().put(lineTitleParts[i], lineParts[i]);
        }
        logger.trace("Parse Net, lineTitleParts: {}, lineParts: {}",
                lineTitleParts, lineParts);
    }

    /**
     * @description NETPACKET,Network Packets
     *              stm01,lo-read/s,eth0-read/s,eth1-read
     *              /s,bond0-read/s,lo-write
     *              /s,eth0-write/s,eth1-write/s,bond0-write/s,
     *              NETPACKET,T0001,0.0,7.2,6.5,13.7,0.0,2.2,2.9,5.2,
     * @param netPacket
     * @param lineParts
     * @author Rain Tang
     * @param lineTitleParts
     */
    public static void parseNetPacket(NetPacket netPacket,
            String[] lineTitleParts, String[] lineParts)
    {
        int i;
        for (i = 2; i <= lineTitleParts.length / 2; i++)
        {
            netPacket.getNetPacketInMap().put(lineTitleParts[i], lineParts[i]);
        }
        for (; i < lineTitleParts.length; i++)
        {
            netPacket.getNetPacketOutMap().put(lineTitleParts[i], lineParts[i]);
        }
        logger.trace("Parse NetPacket, lineTitleParts: {}, lineParts: {}",
                lineTitleParts, lineParts);
    }

    /**
     * @description JFSFILE,JFS Filespace %Used stm01,/,/andromeda,/boot
     *              JFSFILE,T0001,50.9,0.2,7.8
     * @param jfsInode
     * @param dirLineParts
     * @author Rain Tang
     * @param lineParts
     */
    public static void parseJfsInode(JfsInode jfsInode, String[] dirLineParts,
            String[] lineParts)
    {
        for (int i = 2; i < dirLineParts.length; i++)
        {
            jfsInode.getJfsInodeMap().put(dirLineParts[i], lineParts[i]);
        }
        logger.trace("Parse JfsInode, dirLineParts: {}, lineParts: {}",
                dirLineParts, lineParts);
    }

    /**
     * @description DISKBUSY,Disk %Busy stm01,sda,sda1,sda2,sda3,sda4
     *              DISKBUSY,T0001,0.3,0.0,0.3,0.0,0.0
     * @param diskBusy
     * @param diskBusyLineParts
     * @param lineParts
     * @author Rain Tang
     */
    public static void parseDiskBusy(DiskBusy diskBusy,
            String[] diskBusyLineParts, String[] lineParts)
    {
        for (int i = 2; i < diskBusyLineParts.length; i++)
        {
            diskBusy.getDiskBusyMap().put(diskBusyLineParts[i], lineParts[i]);
        }
        logger.trace("Parse DiskBusy, diskBusyLineParts: {}, lineParts: {}",
                diskBusyLineParts, lineParts);
    }

    /**
     * @description
     * @param diskRead
     * @param diskReadLineParts
     * @param lineParts
     * @author Rain Tang
     */
    public static void parseDiskRead(DiskRead diskRead,
            String[] diskReadLineParts, String[] lineParts)
    {
        for (int i = 2; i < diskReadLineParts.length; i++)
        {
            diskRead.getDiskReadMap().put(diskReadLineParts[i], lineParts[i]);
        }
        logger.trace("Parse DiskRead, diskReadLineParts: {}, lineParts: {}",
                diskReadLineParts, lineParts);
    }

    /**
     * @description
     * @param diskWrite
     * @param diskWriteLineParts
     * @param lineParts
     * @author Rain Tang
     */
    public static void parseDiskWrite(DiskWrite diskWrite,
            String[] diskWriteLineParts, String[] lineParts)
    {
        for (int i = 2; i < diskWriteLineParts.length; i++)
        {
            diskWrite.getDiskWriteMap()
                    .put(diskWriteLineParts[i], lineParts[i]);
        }
        logger.trace("Parse DiskWrite, diskWriteLineParts: {}, lineParts: {}",
                diskWriteLineParts, lineParts);
    }

    /**
     * @description
     * @param diskXfer
     * @param diskXferLineParts
     * @param lineParts
     * @author Rain Tang
     */
    public static void parseDiskXfer(DiskXfer diskXfer,
            String[] diskXferLineParts, String[] lineParts)
    {
        for (int i = 2; i < diskXferLineParts.length; i++)
        {
            diskXfer.getDiskXferMap().put(diskXferLineParts[i], lineParts[i]);
        }
        logger.trace("Parse DiskXfer, diskXferLineParts: {}, lineParts: {}",
                diskXferLineParts, lineParts);
    }

    /**
     * @description
     * @param diskBsize
     * @param diskBsizeLineParts
     * @param lineParts
     * @author Rain Tang
     */
    public static void parseDiskBsize(DiskBsize diskBsize,
            String[] diskBsizeLineParts, String[] lineParts)
    {
        for (int i = 2; i < diskBsizeLineParts.length; i++)
        {
            diskBsize.getDiskBsizeMap()
                    .put(diskBsizeLineParts[i], lineParts[i]);
        }
        logger.trace("Parse DiskBsize, diskBsizeLineParts: {}, lineParts: {}",
                diskBsizeLineParts, lineParts);
    }

    /**
     * @description PROC,Processes
     *              stm01,Runnable,Blocked,pswitch,syscall,read,write
     *              ,fork,exec,sem,msg
     *              PROC,T0001,1,0,0.0,-1.0,-1.0,-1.0,0.0,-1.0,-1.0,-1.0
     * @param proc
     * @param lineParts
     * @author Rain Tang
     */
    public static void parseProc(Proc proc, String[] lineParts)
    {
        proc.setRunnable(lineParts[2]);
        proc.setBlocked(lineParts[3]);
        proc.setPswitch(lineParts[4]);
        proc.setSyscall(lineParts[5]);
        proc.setRead(lineParts[6]);
        proc.setWrite(lineParts[7]);
        proc.setFork(lineParts[8]);
        proc.setExec(lineParts[9]);
        proc.setSem(lineParts[10]);
        proc.setMsg(lineParts[11]);
        logger.trace("Parse Proc, lineParts: {}", lineParts.toString());
    }

}
