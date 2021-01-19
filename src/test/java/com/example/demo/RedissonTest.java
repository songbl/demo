package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
//import org.redisson.api.RBucket;
//import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={DemoApplication.class})// 指定启动类
public class RedissonTest {

//    @Autowired
//    private RedissonClient redissonClient;
    @Autowired
    RedisUtil redisUtil ;
    @Test
    public void set() {

        String stock = redisUtil.get("stock");
        System.out.println(stock);

        // 设置字符串
//        RBucket<String> keyObj = redissonClient.getBucket("k1");
//       keyObj.set("4566");
//
////        keyObj.set("v1236");
//        System.out.println(keyObj.get());
    }
}
