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
 * NmonCronMain.java
 *
 * @author Rain Tang
 *         Dec 26, 2014 8:06:14 PM
 * @description
 */
package org.nomt.agent.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Rain Tang
 *
 */
public class NmonCronMain
{
    private static Logger logger = LoggerFactory.getLogger(NmonCronMain.class);

    /**
     * @description
     * @param args
     * @author Rain Tang
     */
    public static void main(String[] args)
    {
        logger.debug("NomtMasterApp start.");

        final String SPRING_CONTEXT_XML = "nmonJob-context.xml";

        logger.debug("Spring context XML file is {}.", SPRING_CONTEXT_XML);

        // schedulerFactoryBean 由spring创建注入
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                SPRING_CONTEXT_XML);
    }

}
