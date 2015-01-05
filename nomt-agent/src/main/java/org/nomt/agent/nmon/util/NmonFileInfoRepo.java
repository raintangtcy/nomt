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
 * NmonFileInfoRepo.java
 *
 * @author Rain Tang
 *         Jan 5, 2015 9:19:57 AM
 * @description
 */
package org.nomt.agent.nmon.util;

import java.io.Serializable;

import org.nomt.agent.nmon.object.NmonFileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 * @description
 */
public class NmonFileInfoRepo implements Serializable
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final long serialVersionUID = 312108819732574171L;

    private static NmonFileInfo content = null;

    private static Logger logger = LoggerFactory
            .getLogger(NmonFileInfoRepo.class);

    /**
     * @return the content
     */
    public static NmonFileInfo getContent()
    {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public static void setContent(NmonFileInfo content)
    {
        NmonFileInfoRepo.content = content;
        logger.trace("Set NmonFileInfoRepo in memory. " + content);
    }
}
