package com.example.boke.config;

import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author bjingban
 * @date 2025-07-06 18:43
 */

public class WebsocketConfig {

    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    };
}
