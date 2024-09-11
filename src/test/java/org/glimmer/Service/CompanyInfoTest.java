//package org.glimmer.Service;
//
//
//import org.glimmer.domain.Company;
//import org.glimmer.domain.ResponseResult;
//import org.glimmer.mapper.CompanyMapper;
//import org.glimmer.service.CompanyInfoService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class CompanyInfoTest {
//
//    @Autowired
//    private CompanyInfoService companyInfoService;
//    @Autowired
//    private CompanyMapper companyMapper;
//
//    @Test
//    public void testGetCompanyInfoByCompanyID() {
//        Company company  = new Company();
//
//        company.setCompanyName("百度");
//        companyInfoService.createCompanyInfo(company);
//        ResponseResult company1 = companyInfoService.getCompanyInfoByCompanyName("百度");
//
//        System.out.println(company1.getData());
//        company.setCompanyAddress("shanghai1");
//        company.setCompanyId(1773329988305563650L);
//        companyInfoService.updateCompanyInfo(company);
//        company1 = companyInfoService.getCompanyInfoByCompanyName("百度");
//        System.out.println(company1.getData());
//
//    }
//    @Test
//    public void testCreateCompanyInfo() {
//        companyInfoService.deleteCompanyInfo(1773993911606325250L);
//        //成功
//    }
//
//}
