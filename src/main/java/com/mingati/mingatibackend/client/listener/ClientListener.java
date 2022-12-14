package com.mingati.mingatibackend.client.listener;

public interface ClientListener {
    public void unknownHost();
    public void couldNotConnect();
    public void recivedInput(String msg);
    public void serverClosed();
    public void disconnected();
    public void connectedToServer();
}
