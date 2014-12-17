/**
 * @title: ConfigUtil.java
 * @description:
 */
package org.nomt.base.conf;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rain Tang
 *
 */
public abstract class AbstractConfigUtil
{
    /**
     * @author Rain Tang
     * @description
     */
    private static final String TRUE_STR = "true";

    /**
     * @author Rain Tang
     * @description
     */
    private String propertiesFile = "";

    /**
     * @author Rain Tang
     * @description
     */
    private static Logger logger = LoggerFactory
            .getLogger(AbstractConfigUtil.class);

    /**
     * properties
     *
     * @Description : properties instance
     */
    private static PropertiesConfiguration properties;

    private static boolean isSucess = false;

    public AbstractConfigUtil()
    {
        initializeConfig();
    }

    /**
     * @description 加载properties文件，文件改动动态生效
     * @return true:加载成功
     * @author Rain Tang
     */
    private boolean initializeConfig()
    {
        try
        {
            propertiesFile = URLDecoder
                    .decode(getPropertiesFilePath(), "utf-8");
            properties = new PropertiesConfiguration(propertiesFile);

            final FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
            strategy.setRefreshDelay(1000);
            properties.setReloadingStrategy(strategy);
            properties.setAutoSave(true);
        }
        catch (UnsupportedEncodingException e)
        {
            logger.error(
                    "UnsupportedEncodingException in AbstractConfigUtil.initializeConfig()",
                    e);
        }
        catch (ConfigurationException e)
        {
            logger.error(
                    "ConfigurationException in AbstractConfigUtil.initializeConfig()",
                    e);
        }
        isSucess = properties != null;
        return isSucess;
    }

    /**
     * @description 返回整数
     * @param xpath
     * @return
     * @author Rain Tang
     */
    public int getIntValue(String xpath)
    {
        int result = 0;
        try
        {
            result = Integer.parseInt(getStrValue(xpath));
        }
        catch (final NumberFormatException e)
        {
            isSucess = false;
            logger.error("!!!Not integer value for : " + xpath
                    + ". Return default integer value 0.");
        }
        return result;
    }

    /**
     * @description 返回long
     * @param xpath
     * @return
     * @author Rain Tang
     */
    public long getLongValue(String xpath)
    {
        long result = 0;
        try
        {
            result = Long.parseLong(getStrValue(xpath));
        }
        catch (final NumberFormatException e)
        {
            isSucess = false;
            logger.error("!!!Not Long value for : " + xpath
                    + ". Return default long value 0.");
        }
        return result;
    }

    /**
     * @Description : 返回String类型的值
     * @param xpath
     * @return
     * @Return: String
     */
    public String getStrValue(String xpath)
    {
        if (!isSucess)
        {
            logger.info("Properties not initialized yet, start to initialize.");
            initializeConfig();
        }

        final String value = properties.getString(xpath).trim();
        if (value == null)
        {
            isSucess = false;
            logger.info("!!!NULL configuration for : " + xpath);
        }
        else
        {
            logger.debug("Configuration: key: " + xpath + " / value: " + value);
        }
        return value;
    }

    /**
     * @description 返回String的列表
     * @param xpath
     * @param sep
     * @return
     * @author Rain Tang
     */
    public List<String> getStringList(String xpath, String sep)
    {
        ArrayList<String> strList = new ArrayList<String>();
        strList.addAll(Arrays.asList(getStrValue(xpath).split(sep)));
        return strList;
    }

    /**
     * @description 返回整数列表
     * @param xpath
     * @param sep
     * @return
     * @author Rain Tang
     */
    public List<Integer> getIntList(String xpath, String sep)
    {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        String[] intArray = getStrValue(xpath).split(sep);
        for (String aInt : intArray)
        {
            intList.add(Integer.parseInt(aInt.trim()));
        }
        return intList;
    }

    /**
     * @description 返回boolean值
     * @param xpath
     * @return
     * @author Rain Tang
     */
    public boolean getBoolean(String xpath)
    {
        String boolString = getStrValue(xpath);
        boolean result = false;
        if (boolString != null && !boolString.isEmpty())
        {
            result = boolString.equalsIgnoreCase(TRUE_STR);
        }
        return result;
    }

    /**
     * @description 判断properties文件是否加载成功
     * @return
     * @author Rain Tang
     */
    public boolean isSucess()
    {
        return isSucess;
    }

    /**
     * @description 由子类指定具体的properties文件的路径
     * @return
     * @author Rain Tang
     */
    public abstract String getPropertiesFilePath();

}
