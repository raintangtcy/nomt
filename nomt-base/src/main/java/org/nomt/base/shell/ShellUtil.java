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
 * ShellUtil.java
 *
 * @author Rain Tang
 *         Dec 23, 2014 10:36:36 AM
 * @description
 */
package org.nomt.base.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public class ShellUtil
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final static ShellUtil instance = new ShellUtil();

    public static ShellUtil getInstance()
    {
        return instance;
    }

    private ShellUtil()
    {
        // for Singleton
    }

    /**
     * @description execute command and return the output
     * @param command
     * @return
     * @author Rain Tang
     */
    public String executeCommand(String command)
    {

        StringBuffer output = new StringBuffer();

        Process p;
        try
        {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null)
            {
                output.append(line + "\n");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return output.toString();

    }

    /**
     * @description ping a destination(domain name or IP), if reachable, return
     *              true, else return
     *              false
     * @param destination
     * @return
     * @author Rain Tang
     */
    public boolean ping(String destination)
    {
        String command;
        boolean result = false;
        if (SystemUtils.IS_OS_WINDOWS)
        {
            command = "ping -n 3 " + destination;
        }
        else
        {
            command = "ping -c 3 " + destination;
        }

        String output = this.executeCommand(command);

        if (output.contains("from"))
        {
            result = true;
            logger.debug("ping {} successfully.", destination);
        }

        return result;
    }
}
