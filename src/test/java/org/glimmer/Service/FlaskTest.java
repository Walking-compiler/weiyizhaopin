//package org.glimmer.Service;
//
//import com.drew.tools.FileUtil;
//import org.glimmer.domain.FlaskAddress;
//import org.glimmer.domain.ResponseResult;
//import org.glimmer.mapper.UserInfoMapper;
//import org.glimmer.request.PostResume;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.File;
//import java.net.URLEncoder;
//import java.util.List;
//
//@SpringBootTest
//public class FlaskTest {
//
//    @Autowired
//    private PostResume postResume;
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private UserInfoMapper userInfoMapper;
//    @Autowired
//    private FlaskAddress flaskAddress;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Test
//    void postResumeTest() {
//        String resumePath = "D:\\p\\1.docx";
//        String userId = "12321";
////        String url = "http://192.168.177.106:20003/uploadResume";
////        if(resumePath == null || resumePath.equals("")){
////            resumePath = userInfoMapper.selectResumeFilePathByUserID(Long.parseLong(userId));
////        }
////        //将用户简历发送到flask接口
//        FileSystemResource fileSystemResource = new FileSystemResource(resumePath);
//        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
//        HttpHeaders headers = new HttpHeaders();
//        params.add("userID",userId);
//        params.add("file",fileSystemResource);
//
//        headers.setContentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA);
//        HttpEntity<MultiValueMap<String,Object>> requestEntity = new HttpEntity<>(params,headers);
//
////        String result = restTemplate.postForObject(url,requestEntity,String.class).toString();
////        System.out.println(result);
//        List<ServiceInstance> instances  = discoveryClient.getInstances("rest-service");
//        for(ServiceInstance instance : instances){
//            System.out.println(instance.getHost());
//            System.out.println(instance.getPort());
//        }
//        ServiceInstance serviceInstance = instances.get(0);
//        String result = restTemplate.postForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/uploadResume",requestEntity,String.class).toString();
//
//
//
//    }
//    //测试postResume方法
//    //测试数据：用户id为1，简历文件路径为D:\\cs_book\\C++现代白皮书.pdf
//    //模仿服务端接收postResume方法的请求
////    @Test
////    void postResumeTest() {
////        try{
////            postResume.postResume("1", "D:\\cs_book\\C++现代白皮书.pdf");
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////
////    }
//
//
//
//}
