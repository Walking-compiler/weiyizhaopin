package org.glimmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.glimmer.domain.UserLikeJob;

import java.util.List;

@Mapper
public interface UserLikeJobMapper extends BaseMapper<UserLikeJob> {
    //返回用户收藏的职位
    @Select("SELECT * FROM sys_user_like_job WHERE user_id = #{userId}")
    List<UserLikeJob> getLikeJobsByUserId(@Param("userId") Long userId);
    //职位被收藏的次数
    @Select("SELECT COUNT(*) FROM sys_user_like_job WHERE job_id = #{jobId}")
    int getLikeCountByJobId(@Param("jobId") Long jobId);
    //取消收藏职位
    @Delete("DELETE FROM sys_user_like_job WHERE user_id = #{userId} AND job_id = #{jobId}")
    int unlikeJob(@Param("userId") Long userId, @Param("jobId") Long jobId);

}
