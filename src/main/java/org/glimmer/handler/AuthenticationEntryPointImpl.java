package org.glimmer.handler;

import com.alibaba.fastjson.JSON;
import org.glimmer.domain.ResponseResult;
import org.glimmer.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败的异常
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseResult result  =new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"用户认证失败，请重新登陆");
        String s = JSON.toJSONString(result);
        WebUtils.renderString(httpServletResponse,s);
    }
}
