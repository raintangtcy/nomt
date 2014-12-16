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
 * DbUtil.java
 * echutag
 * Nov 13, 2014 10:35:34 AM
 *
 * @description
 */
package org.nomt.base.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.nomt.base.conf.ConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author echutag
 *
 */
public class DbUtil
{
    private static DbUtil instance = new DbUtil();

    private Logger logger = LoggerFactory.getLogger(DbUtil.class);

    private ConfigUtil conf = ConfigUtil.getInstance();

    private HikariDataSource hikariDataSource = null;

    private DbUtil()
    {
    }

    /**
     * @description get an instance of DbUtil
     * @return
     * @author echutag
     */
    public static DbUtil getInstance()
    {
        return instance;
    }

    public HikariDataSource getHikariDataSource()
    {
        if (hikariDataSource == null)
        {
            hikariDataSource = new HikariDataSource(getHikariConfig());
        }
        return hikariDataSource;
    }

    /**
     * @description
     * @return
     * @author echutag
     */
    public Connection getConnection()
    {
        Connection connection = null;
        try
        {
            connection = getHikariDataSource().getConnection();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @description load HikariCP configuration from its properties file
     * @return
     * @author echutag
     */
    public HikariConfig getHikariConfig()
    {
        HikariConfig dbConfig = null;
        try
        {
            dbConfig = new HikariConfig(conf.getHikariCpConfFile());
            logger.debug("Load database configuration successfully.");
        }
        catch (Exception e)
        {
            logger.error("Load database configuration failed!!!", e);
        }
        return dbConfig;
    }

}
