package org.glimmer.controller;

import org.glimmer.domain.Company;
import org.glimmer.domain.ResponseResult;
import org.glimmer.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyInfoController {
    @Autowired
    CompanyInfoService companyInfoService;
    @GetMapping("/company/getinfo")
    @PreAuthorize("hasAuthority('system:company:getinfo')")
    public ResponseResult getCompanyInfoByCompanyID(@RequestParam(name="companyID") Long companyID) {
        return companyInfoService.getCompanyInfoByCompanyID(companyID);
    }
    @GetMapping("/company/getinfobyname")
    @PreAuthorize("hasAuthority('system:company:getinfo')")
    public ResponseResult getCompanyInfoByCompanyName(@RequestParam(name="companyName") String companyName) {
        return companyInfoService.getCompanyInfoByCompanyName(companyName);
    }

    @PostMapping("/company/updateinfo")
    @PreAuthorize("hasAuthority('system:company:owner')")
    public ResponseResult updateCompanyInfo(@RequestBody Company company) {
        if (company.getCompanyId() == null){
            return new ResponseResult(500, "修改失败", null);
        }
        return companyInfoService.updateCompanyInfo(company);
    }


    @PostMapping("/company/createinfo")
    @PreAuthorize("hasAuthority('system:company:owner')")
    public ResponseResult createCompanyInfo(@RequestBody Company company){
        return companyInfoService.createCompanyInfo(company);
    }

}
