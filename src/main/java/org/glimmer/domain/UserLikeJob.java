package org.glimmer.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_like_job")
public class UserLikeJob {
    /**
     * 主键
     */
    Long id;
    /**
     * 用户ID
     */
    Long userId;

    /**
     * 职位ID
     */
    Long jobId;
    /**
     * 收藏状态
     */
    int status;




    public UserLikeJob(Long userId, Long jobId){
        this.userId = userId;
        this.jobId = jobId;
    }
}
