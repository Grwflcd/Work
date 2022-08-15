package com.example.circle.Mapper;

import com.example.circle.Entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class CustomAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    /**
     * AuthorizationInfo 权限认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        return null;
    }
    /**k
     * AuthenticationInfo 身份验证
     * @param token
     * @return
     * @throws javax.naming.AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken  token) throws AuthenticationException {
        //获取前端传过来的用户名和密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        System.out.println(username);
        // 效验用户名和密码是否为空
        if (!StringUtils.hasText(username)){
            throw new NullPointerException("用户名不能为空");
        }
        if (!StringUtils.hasText(password)){
            throw new NullPointerException("密码不能为空");
        }
        // 根据 当前用户名 获取数据库 用户信息
        User user = userMapper.getUserByName(username);
        if (null == user){
            throw new NullPointerException("该用户不存在");
        }
        //  principal：认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对象
        Object principal = user;
        // shiro 效验凭证
        Object credentials = user.getPassWord();
        // 加盐 用户密码加密时用到
        ByteSource credentialsSalt = ByteSource.Util.bytes("zh");
        return new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,this.getClass().getName());
    }


}
