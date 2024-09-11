package org.glimmer.service;

import org.glimmer.domain.Company;
import org.glimmer.domain.ResponseResult;

import java.util.HashMap;

public interface CompanyInfoService {
    /**
     * 根据公司ID查询公司信息
     */
    public ResponseResult getCompanyInfoByCompanyID(Long companyID);
    /**
     * 修改公司信息
     */
    public ResponseResult updateCompanyInfo(Company company);
    /**
     * 根据公司名称查询公司信息
     */
    public ResponseResult getCompanyInfoByCompanyName(String companyName);

    /**
     * 新建公司信息
     */
    public ResponseResult createCompanyInfo(Company company);
    /**
     * 删除公司信息
     */
    public ResponseResult deleteCompanyInfo(Long companyID);
}
