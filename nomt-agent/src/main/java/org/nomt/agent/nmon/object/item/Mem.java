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
 * Mem.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 3:22:24 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;

/**
 * @author Rain Tang
 * @description MEM,Memory MB
 *              stm01,memtotal,hightotal,lowtotal,swaptotal,memfree
 *              ,highfree,lowfree
 *              ,swapfree,memshared,cached,active,bigfree,buffers
 *              ,swapcached,inactive
 *              MEM,T0001,48226.0,-0.0,-0.0,49152.0,45052.9,-0.0,-0.0,49152.0,-
 *              0.0,1439.2,1517.3,-1.0,364.3,0.0,900.5
 */
public class Mem implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 3015668725197800857L;

    private String memTotal;

    private String highTotal;

    private String lowTotal;

    private String swapTotal;

    private String memFree;

    private String highFree;

    private String lowFree;

    private String swapFree;

    private String memShared;

    private String cached;

    private String active;

    private String bigFree;

    private String buffers;

    private String swapCached;

    private String inactive;

    public String getMemTotal()
    {
        return memTotal;
    }

    public void setMemTotal(String memTotal)
    {
        this.memTotal = memTotal;
    }

    public String getHighTotal()
    {
        return highTotal;
    }

    public void setHighTotal(String highTotal)
    {
        this.highTotal = highTotal;
    }

    /**
     * @return the lowTotal
     */
    public String getLowTotal()
    {
        return lowTotal;
    }

    /**
     * @param lowTotal
     *            the lowTotal to set
     */
    public void setLowTotal(String lowTotal)
    {
        this.lowTotal = lowTotal;
    }

    /**
     * @return the swapTotal
     */
    public String getSwapTotal()
    {
        return swapTotal;
    }

    /**
     * @param swapTotal
     *            the swapTotal to set
     */
    public void setSwapTotal(String swapTotal)
    {
        this.swapTotal = swapTotal;
    }

    /**
     * @return the memFree
     */
    public String getMemFree()
    {
        return memFree;
    }

    /**
     * @param memFree
     *            the memFree to set
     */
    public void setMemFree(String memFree)
    {
        this.memFree = memFree;
    }

    /**
     * @return the highFree
     */
    public String getHighFree()
    {
        return highFree;
    }

    /**
     * @param highFree
     *            the highFree to set
     */
    public void setHighFree(String highFree)
    {
        this.highFree = highFree;
    }

    /**
     * @return the lowFree
     */
    public String getLowFree()
    {
        return lowFree;
    }

    /**
     * @param lowFree
     *            the lowFree to set
     */
    public void setLowFree(String lowFree)
    {
        this.lowFree = lowFree;
    }

    /**
     * @return the swapFree
     */
    public String getSwapFree()
    {
        return swapFree;
    }

    /**
     * @param swapFree
     *            the swapFree to set
     */
    public void setSwapFree(String swapFree)
    {
        this.swapFree = swapFree;
    }

    /**
     * @return the memShared
     */
    public String getMemShared()
    {
        return memShared;
    }

    /**
     * @param memShared
     *            the memShared to set
     */
    public void setMemShared(String memShared)
    {
        this.memShared = memShared;
    }

    /**
     * @return the cached
     */
    public String getCached()
    {
        return cached;
    }

    /**
     * @param cached
     *            the cached to set
     */
    public void setCached(String cached)
    {
        this.cached = cached;
    }

    /**
     * @return the active
     */
    public String getActive()
    {
        return active;
    }

    /**
     * @param active
     *            the active to set
     */
    public void setActive(String active)
    {
        this.active = active;
    }

    /**
     * @return the bigFree
     */
    public String getBigFree()
    {
        return bigFree;
    }

    /**
     * @param bigFree
     *            the bigFree to set
     */
    public void setBigFree(String bigFree)
    {
        this.bigFree = bigFree;
    }

    /**
     * @return the buffers
     */
    public String getBuffers()
    {
        return buffers;
    }

    /**
     * @param buffers
     *            the buffers to set
     */
    public void setBuffers(String buffers)
    {
        this.buffers = buffers;
    }

    /**
     * @return the swapCached
     */
    public String getSwapCached()
    {
        return swapCached;
    }

    /**
     * @param swapCached
     *            the swapCached to set
     */
    public void setSwapCached(String swapCached)
    {
        this.swapCached = swapCached;
    }

    /**
     * @return the inactive
     */
    public String getInactive()
    {
        return inactive;
    }

    /**
     * @param inactive
     *            the inactive to set
     */
    public void setInactive(String inactive)
    {
        this.inactive = inactive;
    }
}
