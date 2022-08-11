package com.example.circle.Controller;

import com.example.circle.Entity.User;
import com.example.circle.Service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired(required = false)
    private LoginService loginService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String gets(){
        return "你好啊,LPM";
    }

    @RequestMapping(value = "/isExist")
    public String isExist(String phone){
        if(loginService.isExist(phone))return "是";
        return "否";
    }

    /**
     * 用户登录接口
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Object LigIn(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(),user.getPassWord());
            subject.login(token);
            map.put("code","200");
            map.put("message","success");
            map.put("token",subject.getSession().getId());
            return map;
        }catch (IncorrectCredentialsException e){
            map.put("code","501");
            map.put("message","密码不正确");
            return map;
        }
    }



    /**
     * 用户未登录token失效时 访问其他接口时shiroFilter调用接口
     * @return
     */
    @GetMapping("/401")
    public Object _401(){
        Map<String,Object> map = new HashMap<>();
        map.put("code","401");
        map.put("message","not login");
        return map;
    }

    /**
     * 测试接口
     * @return
     */
    @GetMapping("/test")
    public Object test(){
        Map<String,Object> map = new HashMap<>();
        map.put("code","200");
        map.put("message","success");
        return map;
    }
}
