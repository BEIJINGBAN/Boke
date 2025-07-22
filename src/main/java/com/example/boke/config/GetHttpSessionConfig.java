package com.example.boke.config;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

/**
 * @author bjingban
 * @date 2025-07-06 18:52
 */

public class GetHttpSessionConfig extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {

        //获取HttpSession对象
        HttpSession httpSession = (HttpSession) request.getHttpSession();

        //将httpSession对象保存起来
        config.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}
