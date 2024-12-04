package com.huijia.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author huijia
 * @date 2024/12/2 18:04
 */

@SpringBootTest
public class DemoTest {


    @Resource
    ThreadPoolTaskExecutor executor;



    @Test
    public void test2() {

        for (int i = 0; i < 12; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "执行任务");
            });
        }
    }



}
