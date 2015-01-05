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
 * Net.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 3:53:14 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Rain Tang
 * @description NET,Network I/O
 *              stm01,lo-read-KB/s,eth0-read-KB/s,eth1-read-KB/s,
 *              bond0-read-KB/s,
 *              lo-write-KB/s,eth0-write-KB/s,eth1-write-KB/s,bond0-write-KB/s,
 *              NET,T0001,0.0,0.7,0.6,1.3,0.0,1.6,2.7,4.3,
 */
public class Net implements Serializable
{
    /**
     * @author Rain Tang
     * @description &lt;interface name, in&gt;
     */
    private HashMap<String, String> networkReadMap = new HashMap<String, String>();

    /**
     * @author Rain Tang
     * @description &lt;interface name, out&gt;
     */
    private HashMap<String, String> networkWriteMap = new HashMap<String, String>();

    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 7098592631435373935L;

    /**
     * @return the networkReadMap
     */
    public HashMap<String, String> getNetworkReadMap()
    {
        return networkReadMap;
    }

    /**
     * @param networkReadMap
     *            the networkReadMap to set
     */
    public void setNetworkReadMap(HashMap<String, String> networkReadMap)
    {
        this.networkReadMap = networkReadMap;
    }

    /**
     * @return the networkWriteMap
     */
    public HashMap<String, String> getNetworkWriteMap()
    {
        return networkWriteMap;
    }

    /**
     * @param networkWriteMap
     *            the networkWriteMap to set
     */
    public void setNetworkWriteMap(HashMap<String, String> networkWriteMap)
    {
        this.networkWriteMap = networkWriteMap;
    }

}
