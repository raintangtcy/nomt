package org.nomt.base.network;

public interface NetworkEndIf
{
    /**
     * @description Start a network client or server
     * @return
     * @author Rain Tang
     */
    abstract boolean start();

    abstract boolean stop();
}
