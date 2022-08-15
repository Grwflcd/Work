package com.example.circle.Config;

import com.example.circle.Mapper.CustomAuthorizingRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * shiroFilter 过滤
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //需要登录的接口 访问未登录 或 token失效时 回调setLoginUrl里的接口
        shiroFilterFactoryBean.setLoginUrl("/api/401");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        /**
         * anon 匿名也可以访问
         * authc 需要登录以后才可以访问
         * 过滤链由上而下执行的
         */
        filterChainDefinitionMap.put("/api/test", "anon");
        filterChainDefinitionMap.put("/api/test2","authc");
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 配置安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customAuthorizingRealm());
        return securityManager;
    }
    /**
     * 将自定义realm加入容器
     * @return
     */
    @Bean
    public CustomAuthorizingRealm customAuthorizingRealm(){
        CustomAuthorizingRealm realm = new CustomAuthorizingRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }
    /**
     * 定义密码加密规则
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 设置散列算法
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 设置双层MD5  散列次数
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }
}