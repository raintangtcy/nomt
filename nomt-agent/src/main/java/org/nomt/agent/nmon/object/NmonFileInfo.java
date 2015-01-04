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
 * NmonStaticInfo.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 11:16:00 AM
 * @description
 */
package org.nomt.agent.nmon.object;

import java.io.Serializable;

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

/**
 * @author Rain Tang
 *
 */
public class NmonFileInfo implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = -6548601918976192109L;

    private Aaa aaa;

    private CpuX86 x86;

    private CpuAll cpuAll;

    private Mem mem;

    private Net net;

    private NetPacket netPacket;

    private JfsInode jfsInode;

    private DiskBusy diskBusy;

    private DiskRead diskRead;

    private DiskWrite diskWrite;

    private DiskXfer diskXfer;

    private DiskBsize bsize;

    /**
     * @return the aaa
     */
    public Aaa getAaa()
    {
        return aaa;
    }

    /**
     * @param aaa
     *            the aaa to set
     */
    public void setAaa(Aaa aaa)
    {
        this.aaa = aaa;
    }

    /**
     * @return the x86
     */
    public CpuX86 getX86()
    {
        return x86;
    }

    /**
     * @param x86
     *            the x86 to set
     */
    public void setX86(CpuX86 x86)
    {
        this.x86 = x86;
    }

    /**
     * @return the cpuAll
     */
    public CpuAll getCpuAll()
    {
        return cpuAll;
    }

    /**
     * @param cpuAll
     *            the cpuAll to set
     */
    public void setCpuAll(CpuAll cpuAll)
    {
        this.cpuAll = cpuAll;
    }

    /**
     * @return the mem
     */
    public Mem getMem()
    {
        return mem;
    }

    /**
     * @param mem
     *            the mem to set
     */
    public void setMem(Mem mem)
    {
        this.mem = mem;
    }

    /**
     * @return the net
     */
    public Net getNet()
    {
        return net;
    }

    /**
     * @param net
     *            the net to set
     */
    public void setNet(Net net)
    {
        this.net = net;
    }

    /**
     * @return the netPacket
     */
    public NetPacket getNetPacket()
    {
        return netPacket;
    }

    /**
     * @param netPacket
     *            the netPacket to set
     */
    public void setNetPacket(NetPacket netPacket)
    {
        this.netPacket = netPacket;
    }

    /**
     * @return the jfsInode
     */
    public JfsInode getJfsInode()
    {
        return jfsInode;
    }

    /**
     * @param jfsInode
     *            the jfsInode to set
     */
    public void setJfsInode(JfsInode jfsInode)
    {
        this.jfsInode = jfsInode;
    }

    /**
     * @return the diskBusy
     */
    public DiskBusy getDiskBusy()
    {
        return diskBusy;
    }

    /**
     * @param diskBusy
     *            the diskBusy to set
     */
    public void setDiskBusy(DiskBusy diskBusy)
    {
        this.diskBusy = diskBusy;
    }

    /**
     * @return the diskRead
     */
    public DiskRead getDiskRead()
    {
        return diskRead;
    }

    /**
     * @param diskRead
     *            the diskRead to set
     */
    public void setDiskRead(DiskRead diskRead)
    {
        this.diskRead = diskRead;
    }

    /**
     * @return the diskWrite
     */
    public DiskWrite getDiskWrite()
    {
        return diskWrite;
    }

    /**
     * @param diskWrite
     *            the diskWrite to set
     */
    public void setDiskWrite(DiskWrite diskWrite)
    {
        this.diskWrite = diskWrite;
    }

    /**
     * @return the diskXfer
     */
    public DiskXfer getDiskXfer()
    {
        return diskXfer;
    }

    /**
     * @param diskXfer
     *            the diskXfer to set
     */
    public void setDiskXfer(DiskXfer diskXfer)
    {
        this.diskXfer = diskXfer;
    }

    /**
     * @return the bsize
     */
    public DiskBsize getBsize()
    {
        return bsize;
    }

    /**
     * @param bsize
     *            the bsize to set
     */
    public void setBsize(DiskBsize bsize)
    {
        this.bsize = bsize;
    }
}
