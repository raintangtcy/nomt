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
 * CpuAll.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 3:14:51 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;

/**
 * @author Rain Tang
 * @description CPU_ALL,CPU Total stm01,User%,Sys%,Wait%,Idle%,Busy,CPUs
 *              CPU_ALL,T0001,0.0,0.1,0.0,99.9,,24
 */
public class CpuAll implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 8428051909785144794L;

    /**
     * @author Rain Tang
     * @description
     */
    private String user;

    private String sys;

    private String wait;

    private String idle;

    private String busy;

    private String cpus;

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getSys()
    {
        return sys;
    }

    public void setSys(String sys)
    {
        this.sys = sys;
    }

    public String getWait()
    {
        return wait;
    }

    public void setWait(String wait)
    {
        this.wait = wait;
    }

    public String getIdle()
    {
        return idle;
    }

    public void setIdle(String idle)
    {
        this.idle = idle;
    }

    public String getBusy()
    {
        return busy;
    }

    public void setBusy(String busy)
    {
        this.busy = busy;
    }

    public String getCpus()
    {
        return cpus;
    }

    public void setCpus(String cpus)
    {
        this.cpus = cpus;
    }

}
