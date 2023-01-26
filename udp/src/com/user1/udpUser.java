package com.user1;

public class udpUser{
    com.user1.udpClient udpClient;
    com.user1.udpServer udpServer;
    public udpUser(){
        this.udpClient = new udpClient();
        this.udpServer = new udpServer();
    }
    public void start(){
        udpClient.start();
        udpServer.start();
    }

}
