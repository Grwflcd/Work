package com.example.circle;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class MD5 {
    @Test
    public void testMD5(){
        //加密方式md5
        String hashName = "md5";
        String pwd = "123456";
        //加密次数 2
        ByteSource credentialsSalt = ByteSource.Util.bytes("zh");
        Object result = new SimpleHash(hashName,pwd,credentialsSalt,2);
        System.out.println(result);
    }
}
