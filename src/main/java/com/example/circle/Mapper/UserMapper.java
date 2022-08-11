package com.example.circle.Mapper;

import com.example.circle.Entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 根据用户名查询该用户
     * @return
     *
     */
    User getUserByName(@Param("name") String name);
}
