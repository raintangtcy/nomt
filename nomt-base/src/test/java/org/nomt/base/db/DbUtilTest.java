package org.nomt.base.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;

public class DbUtilTest
{
    private DbUtil dbUtil;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void setUp()
    {
        dbUtil = DbUtil.getInstance();
    }

    public void testGetConnection()
    {
        Connection connection = null;
        int i = 0;
        for (;; i++)
        {
            connection = dbUtil.getConnection();
            assertNotNull(connection);
            logger.debug("connect {} borns.", i);
        }
    }

    public void testGetHikariConfig()
    {
        HikariConfig hikariConfig = dbUtil.getHikariConfig();
        assertNotNull(hikariConfig);
        assertEquals("com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
                hikariConfig.getDataSourceClassName());
    }

}
