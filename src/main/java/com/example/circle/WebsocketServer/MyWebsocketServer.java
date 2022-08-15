package com.example.circle.WebsocketServer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



@ServerEndpoint("/test")
@Component
@Slf4j
public class MyWebsocketServer {
    /**
     * 管理在线的客户端
     */
    private static Map<String, Session> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session){
        System.out.println("有新的客户端连接了："+session.getId());
        clients.put(session.getId(),session);
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("有用户断开了连接，id为："+session.getId());
        clients.remove(session.getId());
    }

    @OnError
    public void onError(Throwable throwable){
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("服务端收到客户端发来的消息："+message);
        this.sendAll(message);
    }

    /**
     * 群发消息
     * @param message 消息内容
     */
    private void sendAll(String message){
        for(Map.Entry<String,Session> sessionEntry : clients.entrySet()){
            sessionEntry.getValue().getAsyncRemote().sendText(message);
        }
    }
}
