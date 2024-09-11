package org.glimmer.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.glimmer.domain.LoginUser;
import org.glimmer.domain.User;
import org.glimmer.mapper.MenuMapper;
import org.glimmer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.eq(User::getUserName,s);
        User user = userMapper.selectOne(wrapper);
        if(Objects.isNull(user)) {
            throw new RuntimeException("用户或密码错误");
        }

        List<String> permsByUserId = menuMapper.selectPermsByUserId(user.getId());
        return new LoginUser(user,permsByUserId);
    }
}
