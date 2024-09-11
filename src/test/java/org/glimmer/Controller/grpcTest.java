//package org.glimmer.Controller;
//
//import com.alibaba.nacos.api.annotation.NacosInjected;
//import com.alibaba.nacos.api.naming.NamingService;
//import lombok.val;
//import org.glimmer.domain.FlaskAddress;
//import org.glimmer.grpc.client.Service.Impl.DifferenceServiceClient;
//import org.glimmer.grpc.client.Service.Impl.ExtractResumeClient;
//import org.glimmer.grpc.client.Service.Impl.JobRecommendServiceClient;
//import org.glimmer.utils.RedisCache;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class grpcTest {
//
//
//    @Autowired
//    DifferenceServiceClient differenceServiceClient;
//    @Autowired
//    FlaskAddress flaskAddress;
//    @Autowired
//    JobRecommendServiceClient jobRecommendServiceClient;
//    @Autowired
//    ExtractResumeClient extractResumeClient;
//    @Autowired
//    RedisCache redisCache;
//
//    @Test
//    public void flaskAddress(){
//        System.out.println(flaskAddress.getHost());
//        System.out.println(flaskAddress.getPort());
//    }
//    @Test
//    public void JobRecommendTest() {
//       jobRecommendServiceClient.requestRecommend(12132314L);
//
//    }
//    @Test
//    public void test() {
//        System.out.println(differenceServiceClient.requestDifference(12132314L, "path",null));
//    }
//
//
//    @Test
//    public void ExtractTest() {
////        System.out.println(extractResumeClient.uploadExtractResult("12321").getData().toString());
////        System.out.println(extractResumeClient.uploadExtractResult("12321"));
////        System.out.println(extractResumeClient.uploadExtractResult("12321"));
////        System.out.println(extractResumeClient.uploadExtractResult("12321"));
////        System.out.println(extractResumeClient.uploadExtractResult("12321"));
////        System.out.println(extractResumeClient.uploadExtractResult("12321"));
//        System.out.println(differenceServiceClient.requestDifference(12132314L, "上海信栖网络科技有限公司","web前端实习"));
////        System.out.println(differenceServiceClient.requestDifference("12132314", "path"));
////        System.out.println(differenceServiceClient.requestDifference("12132314", "path"));
////        System.out.println(differenceServiceClient.requestDifference("12132314", "path"));
////        System.out.println(differenceServiceClient.requestDifference("12132314", "path"));
////        System.out.println(jobRecommendServiceClient.requestRecommend("12132314"));
////        System.out.println(jobRecommendServiceClient.requestRecommend("12132314"));
////        System.out.println(jobRecommendServiceClient.requestRecommend("12132314"));
////        System.out.println(jobRecommendServiceClient.requestRecommend("12132314"));
////        System.out.println(jobRecommendServiceClient.requestRecommend("12132314"));
////        System.out.println(redisCache.getCacheObject("user_info"+"12132314").toString());;
//
//    }
//}
