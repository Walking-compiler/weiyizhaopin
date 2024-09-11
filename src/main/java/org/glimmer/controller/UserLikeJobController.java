package org.glimmer.controller;

import io.jsonwebtoken.Claims;
import org.glimmer.domain.ResponseResult;
import org.glimmer.service.UserLikeJobService;
import org.glimmer.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserLikeJobController {
    @Autowired
    UserLikeJobService userLikeJobService;
//TODO 修改权限和逻辑

    @PostMapping("/user/likejob")
    @PreAuthorize("hasAuthority('system:user:likejob')")
    public ResponseResult likeJob(HttpServletRequest request, @RequestParam(name = "jobId") Long jobId) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
        return userLikeJobService.likeJob(Long.parseLong(userid),jobId);


    }

    @PostMapping("/user/unlikejob")
    @PreAuthorize("hasAuthority('system:user:likejob')")
    public ResponseResult unlikeJob(HttpServletRequest request, @RequestParam(name = "jobId") Long jobId) {

        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
        return userLikeJobService.unlikeJob(Long.parseLong(userid),jobId);
    }

    @GetMapping("/user/getlikejobs")
    @PreAuthorize("hasAuthority('system:user:likejob')")
    public ResponseResult getLikeJobsByUserId(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userid;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        }catch (Exception e){
            return new ResponseResult<>(401,"用户认证失败，请重新登陆");
        }
        return userLikeJobService.getLikeJobsByUserId(Long.parseLong(userid));
    }
    @GetMapping("/user/getlikecount")
    @PreAuthorize("hasAuthority('system:user:likejob')")
    public ResponseResult getLikeCountByJobId(@RequestParam(name = "jobId") Long jobId) {
        return userLikeJobService.getLikeCountByJobId(jobId);
    }

}
