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
 * DiskXfer.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 4:14:02 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Rain Tang
 * @description DISKXFER,Disk transfers per second stm01,sda,sda1,sda2,sda3,sda4
 *              DISKXFER,T0001,0.3,0.0,0.3,0.0,0.0
 */
public class DiskXfer implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = -6556871093213120799L;

    /**
     * @author Rain Tang
     * @description &lt;diskname, transfer&gt;
     */
    private HashMap<String, String> diskXferMap = new HashMap<String, String>();

    /**
     * @return the diskXferMap
     */
    public HashMap<String, String> getDiskXferMap()
    {
        return diskXferMap;
    }

    /**
     * @param diskXferMap
     *            the diskXferMap to set
     */
    public void setDiskXferMap(HashMap<String, String> diskXferMap)
    {
        this.diskXferMap = diskXferMap;
    }
}
