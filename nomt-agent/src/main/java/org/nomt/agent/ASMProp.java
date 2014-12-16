package org.nomt.agent;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ASMProp
{
    private static ASMProp asmprop = null;

    public static String clientType = "Jetty";

    public static String hostname = "";

    public String serverip = "127.0.0.1";

    public int serverport = 9123;

    // db info ,server ip port,
    // nmon -s 30 -c 2880 -f -m /tmp ��������
    // ��Ҫ���õĲ���
    public long nmon_file_interval = 60 * 1000;// ms ������һ���ļ� , ����:һ���Ӹ�����һ��
                                               // һ�����86400

    public String jobexpression = "0 * * * * ?";// ÿһ����ִ��һ��

    public String parsejobexpression = "0 * * * * ?";// ÿһ����ִ��һ��

    public int nmon_interval = 30 * 1000;// s ÿ��30��ȥ���/��ȡһ�����

    public int retry = 5;

    public int timeout = 10 * 1000;

    public String sqlliteurl = "jdbc:sqlite:/usr/local/storm/nmon/db/nmon.db";

    private int clusterId = 0;// only used for Andromeda, 0 is default, 1 is
                             // EADS, 2 is EADP

    /*
     * 0 0 12 * * ? public static int nmon_file_interval = 60 * 60 * 24 *
     * 1000;//һ�� public static String
     * jobexpression="0 0 0 * * ?";// ÿһ������0������һ��nmon
     */
    // nmon�ļ���
    public String nmonPath = "/usr/local/storm/nmon/";

    // nmon��ִ���ļ�
    public String nmonExeFile = "nmon";

    // data�ļ�������ļ���
    public String nmonDataPath = "/usr/local/storm/nmon/data/";

    // ��log�ĵط�,ע�� �����ļ��б������.
    public String logPath = "/usr/local/storm/nmon/log/";

    // ��Ϊmysql

    private ASMProp()
    {
    }

    public static ASMProp getInstanse()
    {
        if (asmprop == null)
        {
            asmprop = new ASMProp();
            asmprop.loadMetaprop();
        }
        return asmprop;
    }

    private void loadMetaprop()
    {
        String Path = getClass().getProtectionDomain().getCodeSource()
                .getLocation().getPath();
        int firstIndex = Path.lastIndexOf(System.getProperty("path.separator")) + 1;
        int lastIndex = Path.lastIndexOf(File.separator) + 1;
        String filePath = Path.substring(firstIndex, lastIndex);
        filePath = filePath.concat("/ASM.properties");
        try
        {
            InputStream serverprop = new FileInputStream(new File(filePath));
            Properties prop = new Properties();
            prop.load(serverprop);
            serverprop.close();
            // װ����
            serverip = prop.getProperty("serverip");
            serverport = Integer
                    .valueOf(prop.getProperty("serverport", "9123"));
            nmon_file_interval = Integer.valueOf(prop.getProperty(
                    "nmon_file_interval", "86400")) * 1000;// һ��
            jobexpression = prop.getProperty("jobexpression", "0 0 0 * * ?");// ÿ��0��0��0������һ���µ�nmon
            parsejobexpression = prop.getProperty("parsejobexpression",
                    "1,31 * * * * ?");// ÿ��30��ȥ����һ��
            nmon_interval = Integer.valueOf(prop.getProperty("nmon_interval",
                    "30")) * 1000;// ÿ30�����һ�����
            retry = Integer.valueOf(prop.getProperty("retry", "5"));
            timeout = Integer.valueOf(prop.getProperty("timeout", "10")) * 1000;
            sqlliteurl = prop.getProperty("sqlliteurl");
            nmonPath = prop.getProperty("nmonPath");
            nmonExeFile = prop.getProperty("nmonExeFile");
            nmonDataPath = prop.getProperty("nmonDataPath");
            createFile(nmonDataPath);
            logPath = prop.getProperty("logPath");
            createFile(logPath);
            clusterId = Integer.valueOf(prop.getProperty("cluster_id"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void createFile(String path)
    {
        File file = new File(path);
        if (!file.exists())
        {
            file.mkdirs();
        }
    }

    /**
     * @return the clusterId
     */
    public int getClusterId()
    {
        return clusterId;
    }

    /**
     * @param clusterId the clusterId to set
     */
    public void setClusterId(int clusterId)
    {
        this.clusterId = clusterId;
    }
}
