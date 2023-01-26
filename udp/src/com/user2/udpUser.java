package com.user2;

public class udpUser{
    udpClient udpClient;
    udpServer udpServer;
    public udpUser(){
        this.udpClient = new udpClient();
        this.udpServer = new udpServer();
    }
    public void start(){
        udpClient.start();
        udpServer.start();
    }

}
