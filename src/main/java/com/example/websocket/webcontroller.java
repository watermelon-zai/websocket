package com.example.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/test")
@Component
public class webcontroller {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("success");
    }

    /**
     * 客户端关闭
     * @param session session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("close");
    }

    /**
     * 发生错误
     * @param throwable e
     */
    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        System.out.println("发生错误");
    }


    /**
     * 收到客户端发来消息
     * @param message  消息对象
     */
    @OnMessage
    public void onMessage(String message) {
        this.sendAll(message);
        System.out.println("收到客户端的信息");
    }

    /**
     * 群发消息
     * @param message 消息内容
     */
    private void sendAll(String message) {
        System.out.println("群发信息");
    }


}
