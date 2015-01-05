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
 * CpuX86.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 2:46:16 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;

/**
 * @author Rain Tang
 *
 */
public class CpuX86 implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = -478195832986660492L;

    /**
     * @author Rain Tang
     * @description AAA,x86,VendorId,GenuineIntel
     */
    private String vendorId;

    /**
     * @author Rain Tang
     * @description AAA,x86,ModelName,Intel(R) Xeon(R) CPU L5639 @ 2.13GHz
     */
    private String modelName;

    /**
     * @author Rain Tang
     * @description AAA,x86,MHz,1600.000
     */
    private String mhz;

    /**
     * @author Rain Tang
     * @description AAA,x86,bogomips,4266.50
     */
    private String bogomips;

    /**
     * @author Rain Tang
     * @description AAA,x86,ProcessorChips,1
     */
    private String processorChips;

    /**
     * @author Rain Tang
     * @description AAA,x86,Cores,6
     */
    private String cores;

    /**
     * @author Rain Tang
     * @description AAA,x86,hyperthreads,2
     */
    private String hyperthreads;

    /**
     * @author Rain Tang
     * @description AAA,x86,VirtualCPUs,24
     */
    private String virtualCpus;

    public String getVendorId()
    {
        return vendorId;
    }

    public void setVendorId(String vendorId)
    {
        this.vendorId = vendorId;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getMhz()
    {
        return mhz;
    }

    public void setMhz(String mhz)
    {
        this.mhz = mhz;
    }

    public String getBogomips()
    {
        return bogomips;
    }

    public void setBogomips(String bogomips)
    {
        this.bogomips = bogomips;
    }

    public String getProcessorChips()
    {
        return processorChips;
    }

    public void setProcessorChips(String processorChips)
    {
        this.processorChips = processorChips;
    }

    public String getCores()
    {
        return cores;
    }

    public void setCores(String cross)
    {
        this.cores = cross;
    }

    public String getHyperthreads()
    {
        return hyperthreads;
    }

    public void setHyperthreads(String hyperthreads)
    {
        this.hyperthreads = hyperthreads;
    }

    public String getVirtualCpus()
    {
        return virtualCpus;
    }

    public void setVirtualCpus(String virtualCpus)
    {
        this.virtualCpus = virtualCpus;
    }
}
