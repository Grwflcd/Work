package com.example.circle.Mapper;

import com.example.circle.Entity.User;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    public boolean isExist(String phone);
}
