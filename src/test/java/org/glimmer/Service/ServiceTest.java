//package org.glimmer.Service;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import org.glimmer.domain.Job;
//import org.glimmer.domain.User;
//import org.glimmer.domain.UserInfo;
//import org.glimmer.mapper.JobMapper;
//import org.glimmer.mapper.UserMapper;
//import org.glimmer.service.Impl.UserDetailsServiceImpl;
//import org.glimmer.service.JobInfoService;
//import org.glimmer.service.UserInfoService;
//import org.glimmer.service.UserLikeJobService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.client.RestTemplate;
//
//@SpringBootTest
//public class ServiceTest {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//    @Autowired
//    UserMapper userMapper;
//
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    UserLikeJobService userLikeJobService;
//
//    @Autowired
//    JobInfoService jobInfoService;
//    @Autowired
//    JobMapper jobMapper;
//
//    @Test
//    void LoadByUserNameTest() {
//        UserDetails u = userDetailsService.loadUserByUsername("antio323");
//        System.out.println(u);
//    }
//    @Test
//    void loginTest() {
////        User user = new User();
////        user.setUserName("Anti");
////        user.setPassword("1234");
////        userMapper.insert(user);
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
//        wrapper.eq(User::getUserName,"Anti");
//        User user1 = userMapper.selectOne(wrapper);
//        System.out.println(user1);
////        System.out.println(userDetailsService.loadUserByUsername("Anti"));
//    }
//    @Test
//    void testRestTemplate() {
//        String url = "http://192.168.177.108:5008/personpredict/test";
//        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(result);
//    }
//    @Test
//    void printArch() {
//        System.out.println(System.getProperty("os.name"));
//        System.out.println(System.getProperty("os.arch"));
//    }
//
//    @Test
//    void UserLikeJobTest() {
//        System.out.println(userLikeJobService.likeJob(12132314L, 1L));
//        System.out.println(userLikeJobService.getLikeJobsByUserId(12132314L));
//        System.out.println(userLikeJobService.getLikeCountByJobId(1L));
//        System.out.println(userLikeJobService.unlikeJob(12132314L, 1L));
//        System.out.println(userLikeJobService.likeJob(12132314L,2L));
//        System.out.println(userLikeJobService.likeJob(12132314L,3L));
//    }
//
//    @Test
//    void jobTest(){
//        Job job = new Job();
//        job.setJobName("nihao");
//        job.setJobEducation("asdasdsa");
//        job.setCompanyId(1L);
//        job.setJobDescription("asdsldhkashdfkajsd");
//        System.out.println(jobInfoService.addAJob(job));
////        System.out.println(jobInfoService.deleteJob());
//        System.out.println( jobInfoService.getJobInfoByJobID(3L));
//    }
//    @Autowired
//    UserInfoService userInfoService;
//
//    @Test
//    void userTest(){
//        System.out.println(userInfoService.getEmployeeRecommend(new Job()));
//    }
//}
