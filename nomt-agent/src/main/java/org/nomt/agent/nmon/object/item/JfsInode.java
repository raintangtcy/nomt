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
 * JfsInode.java
 * 
 * @author Rain Tang
 *         Jan 4, 2015 4:25:52 PM
 * @description
 */
package org.nomt.agent.nmon.object.item;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Rain Tang
 * @description
 */
public class JfsInode implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 1599154552710827732L;

    private HashMap<String, String> jfsInodeMap = new HashMap<String, String>();

    /**
     * @return the jfsInodeMap
     */
    public HashMap<String, String> getJfsInodeMap()
    {
        return jfsInodeMap;
    }

    /**
     * @param jfsInodeMap
     *            the jfsInodeMap to set
     */
    public void setJfsInodeMap(HashMap<String, String> jfsInodeMap)
    {
        this.jfsInodeMap = jfsInodeMap;
    }
}
