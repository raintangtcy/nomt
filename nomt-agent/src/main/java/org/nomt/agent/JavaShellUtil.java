/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2014
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package org.nomt.agent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaShellUtil
{
    // ��¼Shellִ��״������־�ļ���λ��(���·��)
    private ASMProp asmprop = ASMProp.getInstanse();

    private static String executeShellLogFile = null;

    private static Logger logger = LoggerFactory.getLogger(JavaShellUtil.class);

    public int executeShell(String shellCommand) throws IOException
    {
        executeShellLogFile = asmprop.logPath.concat("executeShell.log");
        int success = 0;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        // ��ʽ������ʱ�䣬��¼��־ʱʹ��
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS ");
        try
        {
            stringBuffer.append(dateFormat.format(new Date()))
                    .append("Shell ready to execute the command  ")
                    .append(shellCommand).append(" \r\n");
            Process pid = null;
            // ִ��Shell����
            pid = Runtime.getRuntime().exec(shellCommand);
            if (pid != null)
            {
                // stringBuffer.append("pid��").append(pid.toString()).append("\r\n");
                // bufferedReader���ڶ�ȡShell���������
                bufferedReader = new BufferedReader(new InputStreamReader(
                        pid.getInputStream()), 1024);
                pid.waitFor();
            }
            else
            {
                stringBuffer.append("no pid\r\n");
            }
            stringBuffer.append(dateFormat.format(new Date())).append(
                    "Finished Shell command execution results��\r\n");
            String line = null;
            // ��ȡShell��������ݣ�����ӵ�stringBuffer��
            while (bufferedReader != null
                    && (line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line).append("\r\n");
            }
            // logger.info("stringBuffer:" + stringBuffer.toString());
        }
        catch (Exception ioe)
        {
            stringBuffer
                    .append("Shell exception occurred while executing the command��\r\n")
                    .append(ioe.getMessage()).append("\r\n");
        }
        finally
        {
            if (bufferedReader != null)
            {
                // runLog(stringBuffer, bufferedReader);
            }
            success = 1;
        }
        return success;
    }

    private void runLog(StringBuffer stringBuffer, BufferedReader bufferedReader)
            throws IOException
    {
        BufferedWriter bw = null;
        try
        {
            bufferedReader.close();
            // ��Shell��ִ������������־�ļ���
            File logfile = new File(executeShellLogFile);
            if (!logfile.exists())
            {
                logfile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(logfile, true));
            bw.write(stringBuffer.toString());
            bw.newLine();
            bw.flush();
        }
        catch (Exception e)
        {
            logger.warn("Run Shell: " + stringBuffer.toString());
            e.printStackTrace();
        }
        finally
        {
            bw.close();
        }
    }
}
