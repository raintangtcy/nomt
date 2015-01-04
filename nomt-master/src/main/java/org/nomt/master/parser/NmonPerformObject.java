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
 * NeNmonObject.java
 *
 * @author Rain Tang
 *         Dec 27, 2014 5:04:42 PM
 * @description
 */
package org.nomt.master.parser;

import java.io.Serializable;

/**
 * @author Rain Tang
 *
 */
public class NmonPerformObject implements Serializable
{

    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 1419939146960273180L;

    private String eid;

    private String cpuUsage;

    private String memoryUsage;

    private String netReadRate;

    private String netWriteRate;

    private String availableSpace;

    private String lastUpdateTime;

    public String getEid()
    {
        return eid;
    }

    public void setEid(String eid)
    {
        this.eid = eid;
    }

    public String getCpuUsage()
    {
        return cpuUsage;
    }

    public void setCpuUsage(String cpuUsage)
    {
        this.cpuUsage = cpuUsage;
    }

    public String getMemoryUsage()
    {
        return memoryUsage;
    }

    public void setMemoryUsage(String memoryUsage)
    {
        this.memoryUsage = memoryUsage;
    }

    public String getNetReadRate()
    {
        return netReadRate;
    }

    public void setNetReadRate(String netReadRate)
    {
        this.netReadRate = netReadRate;
    }

    public String getNetWriteRate()
    {
        return netWriteRate;
    }

    public void setNetWriteRate(String netWriteRate)
    {
        this.netWriteRate = netWriteRate;
    }

    public String getAvailableSpace()
    {
        return availableSpace;
    }

    public void setAvailableSpace(String availableSpace)
    {
        this.availableSpace = availableSpace;
    }

    public String getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }
}
