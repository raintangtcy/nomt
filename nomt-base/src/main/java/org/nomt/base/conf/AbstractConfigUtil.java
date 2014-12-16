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
import java.util.logging.Logger;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * @author : echutag
 * @Description : configuration utils of app.properties
 */
public abstract class AbstractConfigUtil
{
    /**
     * echutag
     *
     * @description
     */
    private static final String TRUE_STR = "true";

    /**
     * echutag
     *
     * @description
     */
    private String propertiesFile = "";

    /**
     * echutag
     *
     * @description logger instance
     */
    private static Logger logger = Logger.getLogger(AbstractConfigUtil.class
            .getName());

    // /**
    // * CONFIG_FILEPATH
    // *
    // * @Description :path of app.properties
    // */
    // private static String CONFIG_FILEPATH = ClassLoader.getSystemResource(
    // "" + PROPERTIES_FILE_NAME).getPath();

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
     * @Description : initialize the properties instance
     * @Return: void
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
            e.printStackTrace();
        }
        catch (ConfigurationException e)
        {
            e.printStackTrace();
        }
        isSucess = properties != null;
        return isSucess;
    }

    /**
     * @Author : echutag
     * @Description : get integer value from configuration file
     * @param xpath
     * @return
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
            logger.fine("!!!Not integer value for : " + xpath
                    + ". Return default integer value 0.");
        }
        return result;
    }

    /**
     * @Description : get string value from configuration file
     * @param xpath
     * @return
     * @Return: String
     */
    public String getStrValue(String xpath)
    {
        if (!isSucess)
        {
            logger.fine("Properties not initialized yet, start to initialize.");
            initializeConfig();
        }

        final String value = properties.getString(xpath).trim();
        if (value == null)
        {
            isSucess = false;
            logger.fine("!!!NULL configuration for : " + xpath);
        }
        else
        {
            logger.fine("Configuration: key: " + xpath + " / value: " + value);
        }
        return value;
    }

    /**
     * @description get a String list from a String seperated by the certain sep
     *              flag
     * @param xpath
     * @param sep
     * @return
     * @author echutag
     */
    public List<String> getStringList(String xpath, String sep)
    {
        ArrayList<String> strList = new ArrayList<String>();
        strList.addAll(Arrays.asList(getStrValue(xpath).split(sep)));
        return strList;
    }

    /**
     * @description get a String list from a String seperated by the certain sep
     *              flag
     * @param xpath
     * @param sep
     * @return
     * @author echutag
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
     * @Author : echutag
     * @Description : return the initialization result
     * @return
     */
    public boolean isSucess()
    {
        return isSucess;
    }

    public abstract String getPropertiesFilePath();

}
