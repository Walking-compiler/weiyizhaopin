package org.glimmer.service.Impl;

import lombok.val;
import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.UserLikeJob;
import org.glimmer.mapper.JobMapper;
import org.glimmer.mapper.UserLikeJobMapper;
import org.glimmer.service.UserLikeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserLikeJobServiceImpl implements UserLikeJobService {
    @Autowired
    UserLikeJobMapper userLikeJobMapper;
    @Autowired
    JobMapper  jobMapper;
    @Override
    public ResponseResult likeJob(Long userId, Long jobId) {
        UserLikeJob userLikeJob = new UserLikeJob(userId, jobId);
        try {
            userLikeJobMapper.insert(userLikeJob);
            return new ResponseResult(200, "收藏成功", null);
        } catch (Exception e) {
            return new ResponseResult(500, "收藏失败", null);
        }

    }

    @Override
    public ResponseResult unlikeJob(Long userId, Long jobId) {
        try {
            userLikeJobMapper.unlikeJob(userId, jobId);
            return new ResponseResult(200, "取消收藏成功", null);
        } catch (Exception e) {
            return new ResponseResult(500, "取消收藏失败", null);
        }

    }

    @Override
    public ResponseResult getLikeJobsByUserId(Long userId) {
        try {
            List<UserLikeJob> userLikeJobs = userLikeJobMapper.getLikeJobsByUserId(userId);



            return new ResponseResult(200, "查询成功", userLikeJobs);
        } catch (Exception e) {
            return new ResponseResult(500, "查询失败", null);
        }
    }

    @Override
    public ResponseResult getLikeCountByJobId(Long jobId) {
        try {
            int count = userLikeJobMapper.getLikeCountByJobId(jobId);
            return new ResponseResult(200, "查询成功", new HashMap<>(){{put("count",count);}});
        } catch (Exception e) {
            return new ResponseResult(500, "查询失败", null);
        }
    }
}
