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
 * EidGen.java
 *
 * @author Rain Tang
 *         Jan 5, 2015 10:49:51 AM
 * @description
 */
package org.nomt.base.eid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.nomt.base.db.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 * @description
 */
public class EidGen
{
    private static Logger logger = LoggerFactory.getLogger(EidGen.class);

    private static Set<String> existEids = new HashSet<String>();;

    public static String getNewEid()
    {
        String eid = "";

        Connection connection = DbUtil.getInstance().getConnection();
        try
        {
            ResultSet executeQuery = connection.prepareStatement(
                    "select eId from tbl_node;").executeQuery();
            while (executeQuery.next())
            {
                existEids.add(executeQuery.getString(1));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSSS");
        eid = sdf.format(System.currentTimeMillis());
        while (existEids.contains(eid))
        {
            eid = sdf.format(System.currentTimeMillis());
        }
        existEids.add(eid);
        logger.debug("Generate new eid {}", eid);

        return eid;
    }

    public static void main(String[] args)
    {
        getNewEid();
        getNewEid();
        getNewEid();
    }
}
