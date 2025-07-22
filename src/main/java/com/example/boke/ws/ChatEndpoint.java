package com.example.boke.ws;

import com.example.boke.config.GetHttpSessionConfig;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bjingban
 * @date 2025-07-06 18:45
 */

@ServerEndpoint(value = "/chat",configurator = GetHttpSessionConfig.class)
@Component
public class ChatEndpoint {

    private static final Map<String,Session> onlineUsers = new ConcurrentHashMap<>();

    /*
    * 建立连接后，被调用
    * */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
        //保存session
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        onlineUsers.put(session.getId(),session);

        //广播消息


    }

    @OnMessage
    public void onMessage(String message, Session session){

    }

    @OnClose
    public void onClose(Session session){

    }
}
