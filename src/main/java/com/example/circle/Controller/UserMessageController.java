package com.example.circle.Controller;


import com.example.circle.Bean.UserMessage;
import com.example.circle.Service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ServerEndpoint("/websocket/{username}")
@Controller
@Component
public class UserMessageController {
    /**
     * 设置一次性存储数据的list长度
     */
    private static final Integer LIST_SIZE=3;

    /**
     * 设置在线人数为静态变量
     */
    public static int onlineNumer = 0;

    private static UserMessageService userMessageService;

    /**
     * list集合存储数据
     */
    private static ArrayList<UserMessage> MessageList = new ArrayList<>();

    private static Map<String,UserMessageController> clients = new ConcurrentHashMap<String, UserMessageController>();
    /**
     * session会话
     */
    private Session session;
    /**
     * 用户名称
     */
    private String username;

    public static synchronized int getOnlineCount(){
        return onlineNumer;
    }

    @Autowired
    public void setOgLocationService(UserMessageService userMessageService) {
        UserMessageController.userMessageService = userMessageService;
    }

    /**
     * 进入聊天室
     */
    @RequestMapping("/websocket")
    public String webSocket(Model model){
        //根据时间随机定义名称
        String name = "游客：";
        String datename = new SimpleDateFormat("msss").format(new Date());
        name = name + datename;
        //websocket链接地址
        String path = "ws://127.0.0.1:8080/websocket/";
        model.addAttribute("path",path);
        model.addAttribute("username",name);
        return "socket";
    }
}
