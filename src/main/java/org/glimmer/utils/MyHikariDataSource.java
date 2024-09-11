package org.glimmer.utils;

import com.zaxxer.hikari.HikariDataSource;

public class MyHikariDataSource extends HikariDataSource {

    @Override
    public String getUsername() {
        // 对用户名进行解密
        return SM4Utils.decryptStr(super.getUsername());
    }

    @Override
    public String getPassword() {
        // 对密码进行解密
        return SM4Utils.decryptStr(super.getPassword());
    }
}
