package com.sangxj.demos.push;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/webSocket")
@Component
public class WebSocket {

    private Logger LOGGER = LoggerFactory.getLogger(WebSocket.class);

    private static String userId;

    @OnOpen
    public void onOpen(Session session){
        LOGGER.debug("新连接");
    }

    @OnClose
    public void onClose(){
        LOGGER.debug("链接关闭");
    }

    @OnMessage
    public void onMessage(String message,Session session){
        LOGGER.debug("收到用户的消息");
    }

    @OnError
    public void onError(Session session){
        LOGGER.debug("发送错误");
    }
}
