package org.glimmer.domain;

import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glimmer.utils.LongJsonSerializer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_company")
public class Company {
    /**
     * 主键
     */
    @TableId(value = "companyId")
    private Long companyId;
    /**
     * 公司名称
     */
    @TableField("companyName")
    private String companyName;
    /**
     * 公司地址
     */
    @TableField("companyAddress")
    private String companyAddress;
    /**
     * 公司电话
     */
    @TableField("companyPhone")
    private String companyPhone;
    /**
     * 公司邮箱
     */
    @TableField("companyEmail")
    private String companyEmail;
    /**
     * 公司状态
     */
    @TableField("companyStatus")
    private String companyStatus;
    /**
     * 公司类型
     */
    @TableField("companyType")
    private String companyType;
    /**
     * 公司网址
     */
    @TableField("companyUrl")
    private String companyUrl;
    /**
     * 公司简介
     */
    @TableField("companyProfile")
    private String companyProfile;
    /**
     * 公司相册url
     */
    @TableField("companyAlbum")
    private String companyAlbum;

    /**
     * 工商信息
     */



        /**
         *  统一社会信用代码
         */
        @TableField("creditCode")
        private String businessLicense;
        /**
         * 经营范围
         */
        @TableField("businessScope")
        private String businessScope;
        /**
         * 注册资本
         */
        @TableField("registeredCapital")
        private String registeredCapital;
        /**
         * 成立日期
         */
        @TableField("establishDate")
        private String establishDate;
        /**
         * 营业期限
         */
        @TableField("businessTerm")
        private String businessTerm;
        /**
         * 登记机关
         */
        @TableField("registrationAuthority")
        private String registrationAuthority;
        /**
         * 注册地址
         */
        @TableField("registeredAddress")
        private String registeredAddress;
        /**
         * 经营状态
         */
        @TableField("businessStatus")
        private String businessStatus;
    /**
     * 法定代表人
     */
    @TableField("legalRepresentative")
    private String legalRepresentative;

    @TableField("companySize")
    private String companySize;

    @TableField("user_set")
    private  Long userSet;



}
