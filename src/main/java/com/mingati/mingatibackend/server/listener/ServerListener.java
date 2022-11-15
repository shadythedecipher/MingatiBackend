package com.mingati.mingatibackend.server.listener;

import com.mingati.mingatibackend.client.instance.ClientInstance;

import java.io.PrintWriter;

public interface ServerListener {
    public void clientConncted(ClientInstance client, PrintWriter out);
    public void clientDisconnected(ClientInstance client);
    public void recivedInput(ClientInstance client, String msg);
    public void serverClosed();
}
