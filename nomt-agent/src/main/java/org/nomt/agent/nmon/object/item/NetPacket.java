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
 * NetPacket.java
 *
 * @author Rain Tang
 *         Jan 4, 2015 3:55:19 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Rain Tang
 * @description NETPACKET,Network Packets
 *              stm01,lo-read/s,eth0-read/s,eth1-read/s
 *              ,bond0-read/s,lo-write/s,eth0
 *              -write/s,eth1-write/s,bond0-write/s,
 *              NETPACKET,T0001,0.0,7.2,6.5,13.7,0.0,2.2,2.9,5.2,
 */
public class NetPacket implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 3516630664009576302L;

    /**
     * @author Rain Tang
     * @description &lt;interface name, in&gt;
     */
    private HashMap<String, String> netPacketInMap = new HashMap<String, String>();

    /**
     * @author Rain Tang
     * @description &lt;interface name, out&gt;
     */
    private HashMap<String, String> netPacketOutMap = new HashMap<String, String>();

    /**
     * @return the netPacketInMap
     */
    public HashMap<String, String> getNetPacketInMap()
    {
        return netPacketInMap;
    }

    /**
     * @param netPacketInMap
     *            the netPacketInMap to set
     */
    public void setNetPacketInMap(HashMap<String, String> netPacketInMap)
    {
        this.netPacketInMap = netPacketInMap;
    }

    /**
     * @return the netPacketOutMap
     */
    public HashMap<String, String> getNetPacketOutMap()
    {
        return netPacketOutMap;
    }

    /**
     * @param netPacketOutMap
     *            the netPacketOutMap to set
     */
    public void setNetPacketOutMap(HashMap<String, String> netPacketOutMap)
    {
        this.netPacketOutMap = netPacketOutMap;
    }
}
