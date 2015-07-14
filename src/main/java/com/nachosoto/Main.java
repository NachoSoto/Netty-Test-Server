package com.nachosoto;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import com.corundumstudio.socketio.listener.ConnectListener;

public final class Main {
    public static void main(final String[] args) {
        final SocketIOServer server = new SocketIOServer(createConfig());

        server.start();

        server.addConnectListener(new ConnectListener() {
            public void onConnect(final SocketIOClient client) {
                System.out.println("NEW CLIENT");
            }
        });
    }

    private static Configuration createConfig() {
        final Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(3001);
        config.setTransports(Transport.WEBSOCKET);

        return config;
    }
}
