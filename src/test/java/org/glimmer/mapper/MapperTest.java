//package org.glimmer.mapper;
//
//import javafx.util.Pair;
//import lombok.val;
//import org.glimmer.domain.Job;
//import org.glimmer.domain.User;
//import org.glimmer.domain.UserLikeJob;
//import org.glimmer.service.JobInfoService;
//import org.glimmer.service.UserLikeJobService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class MapperTest {
//    @Autowired
//    UserMapper userMapper;
//    @Autowired
//    private MenuMapper menuMapper;
//    @Autowired
//    private CompanyMapper companyMapper;
//    @Autowired
//    private JobMapper jobMapper;
//    @Autowired
//    private JobInfoService jobInfoService;
//    @Autowired
//    UserLikeJobMapper userLikeJobMapper;
//    @Test
//    void SelectTest(){
//        List<User>users = userMapper.selectList(null);
//        System.out.println(users);
//    }
//    @Test
//    public void testselectPermsByUserId(){
//        System.out.println(userMapper.selectById(12132314L) + "" + menuMapper.selectPermsByUserId(12132314L));
//        System.out.println(userMapper.selectById(1123123L) + "" + menuMapper.selectPermsByUserId(1123123L));
//    }
//    @Test
//    public void getNextKey(){
//        System.out.println(userMapper.getNextId());
//    }
//
//    @Test
//    public void testSelectJobByCompanyId(){
//        val jobs = companyMapper.getJobsByCompanyId(1L);
//        for(Job job: jobs){
//            System.out.println(job);
//        }
//    }
//    @Test
//    public void testSearchJobs(){
//
//        val jobs = jobMapper.searchJobs(null, null, null, null, null, null,100);
//        System.out.println("test1:");
//        for(Job job: jobs){
//            System.out.println(job);
//        }
//        val jobs2 = jobMapper.searchJobByName("engineer");
//        System.out.println("test2:");
//        for(Job job: jobs2){
//            System.out.println(job);
//        }
//        val jobs3 = jobMapper.searchJobByType("I");
//        System.out.println("test3:");
//        for(Job job: jobs3){
//            System.out.println(job);
//        }
//    }
//
//    @Test
//    public void testJobMapper(){
//        Job job = new Job();
//        job.setJobName("tesqaweqwt");
//
//        job.setCompanyId(13L);
//        job.setJobEducation("本科");
//        job.setJobId(13L);
//        System.out.println(jobInfoService.updateJob(job));
//    }
//
//    @Test
//    public void testUserLikeJobMapper(){
//        System.out.println(userLikeJobMapper.insert(new UserLikeJob(12132314L, 1L)));
//        System.out.println(userLikeJobMapper.getLikeJobsByUserId(12132314L));
//        System.out.println(userLikeJobMapper.getLikeCountByJobId(1L));
//        System.out.println(userLikeJobMapper.unlikeJob(12132314L, 1L));
////        System.out.println(userLikeJobMapper.likeJob(12132314L,2L));
////        System.out.println(userLikeJobMapper.likeJob(12132314L,3L));
//    }
//
//}
