package org.glimmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.glimmer.domain.Company;
import org.glimmer.domain.Job;

import java.util.List;

@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
    @Select("SELECT * FROM sys_job WHERE companyId = #{companyId}")
    List<Job> getJobsByCompanyId(@Param("companyId") Long companyId);

    /**
     * 根据公司ID查询公司信息
     */
    @Select("SELECT * FROM sys_company WHERE companyId = #{companyId}")
    Company getCompanyInfoByCompanyID(@Param("companyId") Long companyId);
    /**
     * 修改公司全部信息
     * 将一行信息全部更新
     */
    @Update("UPDATE sys_company SET companyName = #{companyName}," +
            "companyType = #{companyType}," +
            "companyAddress = #{companyAddress}," +
            "companyPhone = #{companyPhone}," +
            "companyEmail = #{companyEmail}," +
            "companyStatus = #{companyStatus}," +
            "companyUrl = #{companyUrl}," +
            "companyProfile = #{companyProfile}, " +
            "companyAlbum = #{companyAlbum}," +
            "businessLicense = #{businessLicense}, " +
            "businessScope = #{businessScope}, " +
            "registeredCapital = #{registeredCapital}, " +
            "establishDate = #{establishDate}, " +
            "businessTerm = #{businessTerm}," +
            "registrationAuthority = #{registrationAuthority}, " +
            "registeredAddress = #{registeredAddress}," +
            "businessStatus = #{businessStatus}," +
            "legalRepresentative = #{legalRepresentative} ," +
            "companySize = #{companySize} "+
            "WHERE companyId = #{companyId}")
    int updateCompanyInfo(@Param("companyName") String companyName,
                          @Param("companyType") String companyType,
                          @Param("companyAddress") String companyAddress,
                            @Param("companyPhone") String companyPhone,
                            @Param("companyEmail") String companyEmail,
                            @Param("companyStatus") String companyStatus,
                            @Param("companyUrl") String companyUrl,
                            @Param("companyProfile") String companyProfile,
                            @Param("companyAlbum") String companyAlbum,
                            @Param("businessLicense") String businessLicense,
                            @Param("businessScope") String businessScope,
                            @Param("registeredCapital") String registeredCapital,
                            @Param("establishDate") String establishDate,
                            @Param("businessTerm") String businessTerm,
                            @Param("registrationAuthority") String registrationAuthority,
                            @Param("registeredAddress") String registeredAddress,
                            @Param("businessStatus") String businessStatus,
                            @Param("legalRepresentative") String legalRepresentative,
                            @Param("companySize") String companySize,
                            @Param("companyId") Long companyId);

    /**
     * 根据公司名称查询公司信息
     */
    @Select("SELECT * FROM sys_company WHERE companyName = #{companyName}")
    Company getCompanyInfoByCompanyName(@Param("companyName") String companyName);

    /**
     * 根据公司名字模糊查询公司信息
     */
    @Select("SELECT * FROM sys_company WHERE companyName LIKE CONCAT('%',#{companyName},'%')")
    List<Company> getCompanyInfoByCompanyNameLike(@Param("companyName") String companyName);
    /**
     * 根据公司类型查询公司信息
     */
    @Select("SELECT * FROM sys_company WHERE companyType = #{companyType}")
    List<Company> getCompanyInfoByCompanyType(@Param("companyType") String companyType);
    /**
     * 根据id查询公司名称
     */

    @Select( "SELECT companyName FROM sys_company WHERE companyId = #{companyId}")
    String selectCompanyName(Long companyId);

}
