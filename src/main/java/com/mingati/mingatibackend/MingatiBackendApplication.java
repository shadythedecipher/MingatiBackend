package com.mingati.mingatibackend;

import com.mingati.mingatibackend.client.Client;
import com.mingati.mingatibackend.client.Connect;
import com.mingati.mingatibackend.client.instance.ClientInstance;
import com.mingati.mingatibackend.client.listener.ClientListener;
import com.mingati.mingatibackend.server.impl;
import com.mingati.mingatibackend.server.listener.ServerListener;
import com.mingati.mingatibackend.server.start.Server;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class MingatiBackendApplication {

    public static void main(String[] args)  {

        InetAddress address2;
        PrintWriter out = new PrintWriter(System.out);
        System.out.println("Welcome Mingati Back-end Service");
        System.out.println("Printing Connected peers");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        //Setting ip address for second client;
        try {
           address2 = InetAddress.getByName("8.8.8.8");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        //Setting client instance for connecting to a server;
        ClientInstance instance= new ClientInstance(address2,99);

        //initializing server listener and peer who is connected
        ServerListener Serverlistener=new impl();

        //initializing the server
        Server server= new Server(99,Serverlistener);

        //Acquiring its ip address and printing it out;
        String ip= server.getIp();
        System.out.println(ip);

        InetAddress localhost = null;

        try {
            localhost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        ClientListener listener =new Connect(localhost,89);

        Client client= new Client(ip,99,listener);

        ClientListener listener2 =new Connect(address2,89);

        Client client2= new Client(ip,99,listener);

        //printing and checking if the client is connected or not.
        //1st client
        System.out.println( client.isConnected());
        //2nd client
        System.out.println( "Client of second ip address "  +client2.isConnected());


        //checking the details of the connected client
        Serverlistener.clientConncted(instance,out);
    }

}
