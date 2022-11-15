package com.mingati.mingatibackend.server;

import com.mingati.mingatibackend.client.instance.ClientInstance;
import com.mingati.mingatibackend.server.listener.ServerListener;

import java.io.PrintWriter;

public class impl implements ServerListener {
    @Override
    public void clientConncted(ClientInstance client, PrintWriter out) {
        System.out.println("client instance connected "+ client.toString());
    }

    @Override
    public void clientDisconnected(ClientInstance client) {
        System.out.println("client instance in client disconnected "+client.toString());
    }

    @Override
    public void recivedInput(ClientInstance client, String msg) {
        System.out.println("client instance recieved "+client.toString());
    }

    @Override
    public void serverClosed() {
        System.out.println("server closing");
    }
}
