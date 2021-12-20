package com.ee.user.othersServices;

import com.ee.user.model.User;
import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.MessageHandler;
import jakarta.websocket.Session;

import java.io.IOException;

public class WebSocketEx extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String s) {
                try {
                    session.getBasicRemote().sendText("You are reading text from WebSocket Services" + s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
