package org.glimmer.request;

//向falsk接口发送简历文件和用户id

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.glimmer.domain.FlaskAddress;
import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.UserInfo;
import org.glimmer.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

@Service
public class PostResume {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private FlaskAddress flaskAddress;
    @Autowired
    private DiscoveryClient discoveryClient;
    public ResponseResult postResume(String userId, String resumePath) {
        String url = flaskAddress.getHost() + ":" + flaskAddress.getPort() + "/postResume";
        if(resumePath == null || resumePath.equals("")){
            resumePath = userInfoMapper.selectResumeFilePathByUserID(Long.parseLong(userId));
        }
        //将用户简历发送到flask接口
        FileSystemResource fileSystemResource = new FileSystemResource(resumePath);
        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        params.add("userID",userId);
        params.add("file",fileSystemResource);

        headers.setContentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String,Object>> requestEntity = new HttpEntity<>(params,headers);
        List<ServiceInstance> instances  = discoveryClient.getInstances("rest-service");
        for(ServiceInstance instance : instances){
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
        }
        ServiceInstance serviceInstance = instances.get(0);
        String result = restTemplate.postForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/uploadResume", requestEntity, String.class);
        System.out.println(result);
        JSONObject jsonObject = JSON.parseObject(result);
        System.out.println(jsonObject);

        return new ResponseResult(Integer.parseInt(jsonObject.get("code").toString()),jsonObject.get("msg").toString());//TODO 修改返回值
    }
}
