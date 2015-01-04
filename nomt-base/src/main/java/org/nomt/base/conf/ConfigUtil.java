/**
 * @title: ConfigUtil.java
 * @description:
 */
package org.nomt.base.conf;

import java.util.logging.Logger;

import org.apache.commons.lang.SystemUtils;

/**
 * @author : echutag
 * @Description : configuration utils of app.properties
 */
public class ConfigUtil extends AbstractConfigUtil
{
    /**
     * echutag
     *
     * @description logger instance
     */
    private static Logger logger = Logger.getLogger(ConfigUtil.class.getName());

    private static ConfigUtil instance = new ConfigUtil();

    private ConfigUtil()
    {
    }

    public static ConfigUtil getInstance()
    {
        return instance;
    }

    /**
     * @description
     * @return
     * @author echutag
     */
    public String getHikariCpConfFile()
    {
        String hikaricpPropertiesFile = null;
        String path = getStrValue("db.hikaricp.conf.file");
        if (SystemUtils.IS_OS_LINUX)
        {
            hikaricpPropertiesFile = path;
        }
        else
        {
            hikaricpPropertiesFile = "C:" + path;

        }
        logger.fine("Hikaricp configuration file : " + hikaricpPropertiesFile);
        return hikaricpPropertiesFile;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.ericsson.ece.ca.cmcc.conf.AbstractConfigUtil#getPropertiesFilePath()
     */
    @Override
    public String getPropertiesFilePath()
    {
        String propertiesFile = null;
        if (SystemUtils.IS_OS_LINUX)
        {
            propertiesFile = "/cluster/home/nomt/app.properties";
        }
        else
        {
            propertiesFile = "C:/cluster/home/nomt/app.properties";

        }

        logger.fine("Get properties file from " + propertiesFile);
        return propertiesFile;
    }

}
