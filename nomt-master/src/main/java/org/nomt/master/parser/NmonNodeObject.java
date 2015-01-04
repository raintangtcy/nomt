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
public class NmonNodeObject implements Serializable
{

    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 1419939146960273180L;

    private String hostName;

    private String netType;

    private String ip;

    private String cpuSpeed;

    private String cpuNum;

    private String memory;

    private String harddisk;

    /**
     * @author Rain Tang
     * @description VendorId
     */
    private String manufaturer;

    private String commodel;

    private String osName;

    private String lastUpdateTime;

    public String getHostName()
    {
        return hostName;
    }

    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    public String getNetType()
    {
        return netType;
    }

    public void setNetType(String netType)
    {
        this.netType = netType;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getCpuSpeed()
    {
        return cpuSpeed;
    }

    public void setCpuSpeed(String cpuSpeed)
    {
        this.cpuSpeed = cpuSpeed;
    }

    public String getCpuNum()
    {
        return cpuNum;
    }

    public void setCpuNum(String cpuNum)
    {
        this.cpuNum = cpuNum;
    }

    public String getMemory()
    {
        return memory;
    }

    public void setMemory(String memory)
    {
        this.memory = memory;
    }

    public String getHarddisk()
    {
        return harddisk;
    }

    public void setHarddisk(String harddisk)
    {
        this.harddisk = harddisk;
    }

    public String getManufaturer()
    {
        return manufaturer;
    }

    public void setManufaturer(String manufaturer)
    {
        this.manufaturer = manufaturer;
    }

    public String getCommodel()
    {
        return commodel;
    }

    public void setCommodel(String commodel)
    {
        this.commodel = commodel;
    }

    public String getOsName()
    {
        return osName;
    }

    public void setOsName(String osName)
    {
        this.osName = osName;
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
