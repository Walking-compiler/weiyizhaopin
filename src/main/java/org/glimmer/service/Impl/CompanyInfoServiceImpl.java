package org.glimmer.service.Impl;

import org.glimmer.domain.Company;
import org.glimmer.domain.ResponseResult;
import org.glimmer.mapper.CompanyMapper;
import org.glimmer.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public ResponseResult<Company> getCompanyInfoByCompanyID(Long companyID) {
        Company company = companyMapper.getCompanyInfoByCompanyID(companyID);
        if (company != null) {
            return new ResponseResult<Company>(200, "查询成功", company);
        } else {
            return new ResponseResult<Company>(500, "查询失败", null);
        }
    }
    @Override
    public ResponseResult updateCompanyInfo(Company company) {
        int result = companyMapper.updateCompanyInfo(company.getCompanyName(),
                company.getCompanyType(),
                company.getCompanyAddress(),
                company.getCompanyPhone(),
                company.getCompanyEmail(),
                company.getCompanyStatus(),
                company.getCompanyUrl(),
                company.getCompanyProfile(),
                company.getCompanyAlbum(),
                company.getBusinessLicense(),
                company.getBusinessScope(),
                company.getRegisteredCapital(),
                company.getEstablishDate(),
                company.getBusinessTerm(),
                company.getRegistrationAuthority(),
                company.getRegisteredAddress(),
                company.getBusinessStatus(),
                company.getLegalRepresentative(),
                company.getCompanySize(),
                company.getCompanyId());
        if (result > 0) {
            return new ResponseResult(200, "修改成功", null);
        } else {
            return new ResponseResult(500, "修改失败", null);
        }
    }
    @Override
    public ResponseResult createCompanyInfo(Company company) {
        int result = companyMapper.insert(company);
        if (result > 0) {
            return new ResponseResult(200, "创建成功", null);
        } else {
            return new ResponseResult(500, "创建失败", null);
        }
    }
    @Override
    public ResponseResult<Company> getCompanyInfoByCompanyName(String companyName) {
        Company company = companyMapper.getCompanyInfoByCompanyName(companyName);
        if (company != null) {
            return new ResponseResult<Company>(200, "查询成功", company);
        } else {
            return new ResponseResult<Company>(500, "查询失败", null);
        }
    }
    @Override
    public ResponseResult deleteCompanyInfo(Long companyID) {
        int result = companyMapper.deleteById(companyID);
        if (result > 0) {
            return new ResponseResult(200, "删除成功", null);
        } else {
            return new ResponseResult(500, "删除失败", null);
        }
    }
}
