package com.mingati.mingatibackend.client;

import com.mingati.mingatibackend.client.instance.ClientInstance;
import com.mingati.mingatibackend.client.listener.ClientListener;

import java.net.InetAddress;

public class Connect extends ClientInstance implements ClientListener {
    public Connect(InetAddress ip, int port) {
        super(ip, port);
    }

    @Override
    public void unknownHost() {
        System.out.println("i am unknown host");
    }

    @Override
    public void couldNotConnect() {
        System.out.println("could not connect");
    }

    @Override
    public void recivedInput(String msg) {
        System.out.println("recieved input"+msg);
    }

    @Override
    public void serverClosed() {
        System.out.println("server closed on us");
    }

    @Override
    public void disconnected() {

    }

    @Override
    public void connectedToServer() {

    }
}
