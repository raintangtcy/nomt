package org.nomt.agent.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Version
{

    private Properties properties;

    public Version()
    {
        BufferedReader in = null;

        try
        {
            // in = new BufferedReader(
            // new FileReader(
            // "C:/Program Files (x86)/eclipse-java-juno-SR1-win32-x86_64/eclipse/workspace/cdr-mediation/src/main/resources/app.properties"));
            in = new BufferedReader(new FileReader(
                    "../config/nomtAgent.properties"));

            this.properties = new Properties();
            this.properties.load(in);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException("app.properties not found.");
        }
        catch (IOException e)
        {
            throw new RuntimeException(
                    "An error occured while loading app.properties: ", e);
        }
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ignore)
            {
            }
        }
    }

    public void printVersion()
    {
        String appName = this.properties.getProperty("app.name");
        String appVersion = this.properties.getProperty("app.version");

        System.out.println(appName + " version " + appVersion);
    }

    public static void main(String[] args)
    {
        new Version().printVersion();
    }
}
