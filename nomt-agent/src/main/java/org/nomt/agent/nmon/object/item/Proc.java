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
 * Proc.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 4:17:51 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;

/**
 * @author Rain Tang
 * @description PROC,Processes
 *              stm01,Runnable,Blocked,pswitch,syscall,read,write,
 *              fork,exec,sem,msg
 *              PROC,T0001,1,0,0.0,-1.0,-1.0,-1.0,0.0,-1.0,-1.0,-1.0
 */
public class Proc implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 4713633837695558448L;

    private String runnable;

    private String blocked;

    private String pswitch;

    private String syscall;

    private String read;

    private String write;

    /**
     * @return the runnable
     */
    public String getRunnable()
    {
        return runnable;
    }

    /**
     * @param runnable
     *            the runnable to set
     */
    public void setRunnable(String runnable)
    {
        this.runnable = runnable;
    }

    /**
     * @return the blocked
     */
    public String getBlocked()
    {
        return blocked;
    }

    /**
     * @param blocked
     *            the blocked to set
     */
    public void setBlocked(String blocked)
    {
        this.blocked = blocked;
    }

    /**
     * @return the pswitch
     */
    public String getPswitch()
    {
        return pswitch;
    }

    /**
     * @param pswitch
     *            the pswitch to set
     */
    public void setPswitch(String pswitch)
    {
        this.pswitch = pswitch;
    }

    /**
     * @return the syscall
     */
    public String getSyscall()
    {
        return syscall;
    }

    /**
     * @param syscall
     *            the syscall to set
     */
    public void setSyscall(String syscall)
    {
        this.syscall = syscall;
    }

    /**
     * @return the read
     */
    public String getRead()
    {
        return read;
    }

    /**
     * @param read
     *            the read to set
     */
    public void setRead(String read)
    {
        this.read = read;
    }

    /**
     * @return the write
     */
    public String getWrite()
    {
        return write;
    }

    /**
     * @param write
     *            the write to set
     */
    public void setWrite(String write)
    {
        this.write = write;
    }
}
