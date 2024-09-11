package org.glimmer.service.Impl;


import org.glimmer.domain.ResponseResult;
import org.glimmer.mapper.CompanyMapper;
import org.glimmer.mapper.JobMapper;
import org.glimmer.service.SearchJobOrCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchJobOrCompanyServiceImpl implements SearchJobOrCompanyService {
    @Autowired
    JobMapper jobMapper;
    @Autowired
    CompanyMapper companyMapper;


    @Override
    public ResponseResult searchJobOrCompany(String keyword){
        return new ResponseResult<>(200,"success");
    }





}
