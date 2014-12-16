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

import java.io.Serializable;

/**
 * 
 * @Description: EnmonBean
 * 
 * @author bean
 * 
 */
public class EnmonBean implements Serializable
{
    /*
     * 
     * ctime | timestamp with time zone | not null hostname | character varying | not null mem_total | bigint | not null
     * mem_used | bigint | not null mem_actual_used | bigint | not null mem_actual_free | bigint | not null swap_total |
     * bigint | not null swap_used | bigint | not null swap_page_in | bigint | not null swap_page_out | bigint | not
     * null cpu_user | double precision | not null cpu_sys | double precision | not null cpu_idle | double precision |
     * not null load0 | double precision | not null load1 | double precision | not null load2 | double precision | not
     * null disk_ro_rate | bigint | not null disk_wo_rate | bigint | not null disk_rb_rate | bigint | not null
     * disk_wb_rate | bigint | not null net_rp_rate | bigint | not null net_wp_rate | bigint | not null net_rb_rate |
     * bigint | not null net_wb_rate | bigint | not null
     */
    /**
     * @Description:
     * @author bean serialVersionUID
     */
    private static final long serialVersionUID = 5875515390060882899L;

    private String ctime;
    private String status;

    private String hostname;

    private String cluster_id;

    private double mem_total;

    private double mem_used;

    private double mem_actual_used;

    private double mem_actual_free;

    private double swap_total;

    private double swap_used;

    private double swap_page_in;

    private double swap_page_out;

    private double cpu_user;

    private double cpu_sys;

    private double cpu_idle;

    private double load0;

    private double load1;

    private double load2;

    private double disk_ro_rate;

    private double disk_wo_rate;

    private double disk_rb_rate;

    private double disk_wb_rate;

    private double net_rp_rate;

    private double net_wp_rate;

    private double net_rb_rate;

    private double net_wb_rate;

    /**
     * Creates a new instance of <code>EnmonBean</code>
     * 
     * @author bean
     */
    public EnmonBean()
    {
    }

    public String getCluster_id()
    {
        return cluster_id;
    }

    public void setCluster_id(String clusterId)
    {
        cluster_id = clusterId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCtime()
    {
        return ctime;
    }

    public void setCtime(String ctime)
    {
        this.ctime = ctime;
    }

    public String getHostname()
    {
        return hostname;
    }

    public void setHostname(String hostname)
    {
        this.hostname = hostname;
    }

    public double getMem_total()
    {
        return mem_total;
    }

    public void setMem_total(double memTotal)
    {
        mem_total = memTotal;
    }

    public double getMem_used()
    {
        return mem_used;
    }

    public void setMem_used(double memUsed)
    {
        mem_used = memUsed;
    }

    public double getMem_actual_used()
    {
        return mem_actual_used;
    }

    public void setMem_actual_used(double memActualUsed)
    {
        mem_actual_used = memActualUsed;
    }

    public double getMem_actual_free()
    {
        return mem_actual_free;
    }

    public void setMem_actual_free(double memActualFree)
    {
        mem_actual_free = memActualFree;
    }

    public double getSwap_total()
    {
        return swap_total;
    }

    public void setSwap_total(double swapTotal)
    {
        swap_total = swapTotal;
    }

    public double getSwap_used()
    {
        return swap_used;
    }

    public void setSwap_used(double swapUsed)
    {
        swap_used = swapUsed;
    }

    public double getSwap_page_in()
    {
        return swap_page_in;
    }

    public void setSwap_page_in(double swapPageIn)
    {
        swap_page_in = swapPageIn;
    }

    public double getSwap_page_out()
    {
        return swap_page_out;
    }

    public void setSwap_page_out(double swapPageOut)
    {
        swap_page_out = swapPageOut;
    }

    public double getCpu_user()
    {
        return cpu_user;
    }

    public void setCpu_user(double cpuUser)
    {
        cpu_user = cpuUser;
    }

    public double getCpu_sys()
    {
        return cpu_sys;
    }

    public void setCpu_sys(double cpuSys)
    {
        cpu_sys = cpuSys;
    }

    public double getCpu_idle()
    {
        return cpu_idle;
    }

    public void setCpu_idle(double cpuIdle)
    {
        cpu_idle = cpuIdle;
    }

    public double getLoad0()
    {
        return load0;
    }

    public void setLoad0(double load0)
    {
        this.load0 = load0;
    }

    public double getLoad1()
    {
        return load1;
    }

    public void setLoad1(double load1)
    {
        this.load1 = load1;
    }

    public double getLoad2()
    {
        return load2;
    }

    public void setLoad2(double load2)
    {
        this.load2 = load2;
    }

    public double getDisk_ro_rate()
    {
        return disk_ro_rate;
    }

    public void setDisk_ro_rate(double diskRoRate)
    {
        disk_ro_rate = diskRoRate;
    }

    public double getDisk_wo_rate()
    {
        return disk_wo_rate;
    }

    public void setDisk_wo_rate(double diskWoRate)
    {
        disk_wo_rate = diskWoRate;
    }

    public double getDisk_rb_rate()
    {
        return disk_rb_rate;
    }

    public void setDisk_rb_rate(double diskRbRate)
    {
        disk_rb_rate = diskRbRate;
    }

    public double getDisk_wb_rate()
    {
        return disk_wb_rate;
    }

    public void setDisk_wb_rate(double diskWbRate)
    {
        disk_wb_rate = diskWbRate;
    }

    public double getNet_rp_rate()
    {
        return net_rp_rate;
    }

    public void setNet_rp_rate(double netRpRate)
    {
        net_rp_rate = netRpRate;
    }

    public double getNet_wp_rate()
    {
        return net_wp_rate;
    }

    public void setNet_wp_rate(double netWpRate)
    {
        net_wp_rate = netWpRate;
    }

    public double getNet_rb_rate()
    {
        return net_rb_rate;
    }

    public void setNet_rb_rate(double netRbRate)
    {
        net_rb_rate = netRbRate;
    }

    public double getNet_wb_rate()
    {
        return net_wb_rate;
    }

    public void setNet_wb_rate(double netWbRate)
    {
        net_wb_rate = netWbRate;
    }

    @Override
    public String toString()
    {
        return "EnmonBean [cpu_idle=" + cpu_idle + ", cpu_sys=" + cpu_sys
                + ", cpu_user=" + cpu_user + ", ctime=" + ctime
                + ", disk_rb_rate=" + disk_rb_rate + ", disk_ro_rate="
                + disk_ro_rate + ", disk_wb_rate=" + disk_wb_rate
                + ", disk_wo_rate=" + disk_wo_rate + ", hostname=" + hostname
                + ", load0=" + load0 + ", load1=" + load1 + ", load2=" + load2
                + ", mem_actual_free=" + mem_actual_free + ", mem_actual_used="
                + mem_actual_used + ", mem_total=" + mem_total + ", mem_used="
                + mem_used + ", net_rb_rate=" + net_rb_rate + ", net_rp_rate="
                + net_rp_rate + ", net_wb_rate=" + net_wb_rate
                + ", net_wp_rate=" + net_wp_rate + ", swap_page_in="
                + swap_page_in + ", swap_page_out=" + swap_page_out
                + ", swap_total=" + swap_total + ", swap_used=" + swap_used
                + ", status=" + status
                + "]";
    }
    
    public String toCsvString(){
        return cpu_idle + "," + cpu_sys
        + "," + cpu_user + "," + ctime
        + "," + disk_rb_rate + ","
        + disk_ro_rate + "," + disk_wb_rate
        + "," + disk_wo_rate + "," + hostname
        + "," + load0 + "," + load1 + "," + load2
        + "," + mem_actual_free + ","
        + mem_actual_used + "," + mem_total + ","
        + mem_used + "," + net_rb_rate + ","
        + net_rp_rate + "," + net_wb_rate
        + "," + net_wp_rate + ","
        + swap_page_in + "," + swap_page_out
        + "," + swap_total + "," + swap_used
        + "," + status+"\r\n";
    }
    
}
