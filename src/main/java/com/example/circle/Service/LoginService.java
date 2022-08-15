package com.example.circle.Service;

import com.example.circle.Mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "LoginService")
public class LoginService {
    @Autowired(required = false)
    private LoginMapper loginMapper;
    public boolean isExist(String phone){
        return loginMapper.isExist(phone);
    }
}
