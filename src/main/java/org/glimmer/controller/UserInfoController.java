package org.glimmer.controller;

import io.jsonwebtoken.Claims;
import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.User;
import org.glimmer.domain.UserInfo;
import org.glimmer.grpc.client.Service.Impl.ExtractResumeClient;
import org.glimmer.service.UserInfoService;
import org.glimmer.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    ExtractResumeClient extractResumeClient;
    //提交用户简历信息
    @PostMapping("/UserInfo/submit")
    @PreAuthorize( "hasAuthority( 'sys:job:submit' )")
    public ResponseResult submitUserInfo(@RequestBody UserInfo userInfo, HttpServletRequest request ) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
        try{
            userInfo.setUserID(Long.parseLong(userid));
            userInfoService.updateUserInfo(userInfo);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseResult<>(4005,"上传失败");
        }

        return new ResponseResult<>(200, "提交成功", null);
    }
    //获取用户简历信息
    @GetMapping("/UserInfo/get")
    @PreAuthorize( "hasAuthority( 'sys:job:get' )")
    public ResponseResult getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
        return new ResponseResult<>(200, "查询成功", userInfoService.getUserInfo(Long.parseLong(userid)));
    }

    //获取用户联系方式
    @GetMapping("/UserInfo/getContact")
    @PreAuthorize( "hasAuthority( 'sys:job:get' )")
    public ResponseResult getUserContact(@RequestParam("userid") Long userid) {
        //先判断是否存在该用户
        User user= userInfoService.getUserContact(userid);
        if( user == null){
            return new ResponseResult<>(4005,"用户不存在");
        }else{
            return new ResponseResult<>(200, "查询成功", user);
        }
    }

    /**
     * 提交简历后按确定键，将简历信息提取出来
     * @param request
     * @return
     */

    @GetMapping("/UserInfo/extraction")
    @PreAuthorize("hasAuthority('sys:user:info')")
    public ResponseResult extractUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
//        ResponseResult result =  extractResumeClient.uploadExtractResult(userid);
//        if(result.getCode() == 200){
//            return result;
//        }else{
//            return new ResponseResult(4005, "提取失败", null);
//        }
        return new ResponseResult(200,"success");
    }


    /**
     * 当用户修改提取出的简历信息后，将修改后的信息存入redis
     * @param userInfo
     * @param request
     * @return
     */
    @PostMapping("/userinfo/setinfo")
    @PreAuthorize("hasAuthority('sys:user:info')")
    public ResponseResult setJobInfo(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
        userInfo.setUserID(Long.parseLong(userid));
        return userInfoService.modifyUserInfoInRedis(userInfo);
    }

    /**
     * 按确定键，将redis中的简历信息存入数据库
     * @param userInfo
     * @param request
     * @return
     */
    @PostMapping("/userinfo/save")
    @PreAuthorize("hasAuthority('sys:user:info')")
    public ResponseResult saveUserInfo(HttpServletRequest request,@RequestBody UserInfo userInfo) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
        userInfo.setUserID(Long.parseLong(userid));
        userInfoService.modifyUserInfoInRedis(userInfo);
        return userInfoService.saveResumeFromRedisToDB(Long.parseLong(userid));
    }

    @GetMapping("/UserInfo/getDifference")
    @PreAuthorize("hasAuthority('sys:user:info')")
    public ResponseResult getDifference(@RequestParam("companyId") Long companyId, @RequestParam("jobId") Long jobId, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
//        return userInfoService.getDifference(Long.parseLong(userid), companyId, jobId);
        return new ResponseResult<>(200,"success");
    }

    @GetMapping("/UserInfo/getRecommend")
    @PreAuthorize("hasAuthority('sys:user:info')")
    public ResponseResult getRecommend(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
//        return userInfoService.getRecommend(Long.parseLong(userid));
        return new ResponseResult<>(200,"success");
    }

    @GetMapping("UserInfo/getemployee")
    @PreAuthorize("hasAuthority('sys:user:info')")
    public ResponseResult getEmployees(){
        return  userInfoService.getEmployeeRecommend(new Job());
    }
    //TODO


}
