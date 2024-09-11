package org.glimmer.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.glimmer.domain.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT auto_increment FROM information_schema.tables where table_schema='glimmer_index' and table_name='sys_user'")
    Long getNextId();
    /**
     * 修改用户信息
     */
    @Update("update sys_user set password = #{password} where id = #{id}")
    int updatePassword(Long id, String password);
    /**
     * 修改用户名字、手机号、通讯地址
     */
    @Update("update sys_user set user_name = #{userName}, phonenumber = #{phonenumber}, email = #{email} where id = #{id}")
    int updateUserInfo(Long id, String userName, String phonenumber, String email);

    /**
     * 获取邮箱
     *
     */
    @Select("select email from sys_user where id = #{id}")
    String selectEmailById(Long id);
    /**
     * 获取手机号
     *
     */
    @Select("select phonenumber from sys_user where id = #{id}")
    String selectPhonenumberById(Long id);
    /**
     * 获取用户名
     *
     */
    @Select("select user_name from sys_user where id = #{id}")
    String selectUserNameById(Long id);
    /**
     * 获取用户邮箱、电话、用户名
     */
    @Select("select email, phonenumber, user_name from sys_user where id = #{id}")
    User selectUserContact(Long id);
}
