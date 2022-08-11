package com.example.circle.Controller;

import com.example.circle.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
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

}
