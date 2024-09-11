package org.glimmer.service;

import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.UserLikeJob;

import java.util.List;

public interface UserLikeJobService {
    //用户收藏职位
    public ResponseResult likeJob(Long userId, Long jobId);
    //用户取消收藏职位
    public ResponseResult unlikeJob(Long userId, Long jobId);
    //用户收藏的职位
    public ResponseResult getLikeJobsByUserId(Long userId);
    //职位被收藏的次数
    public ResponseResult getLikeCountByJobId(Long jobId);
}
