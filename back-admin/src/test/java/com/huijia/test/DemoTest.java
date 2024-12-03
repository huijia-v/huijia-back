package com.huijia.test;

import com.huijia.common.redis.utils.RedisUtils;
import com.huijia.domain.Dealer;
import com.huijia.mapper.DealerMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huijia
 * @date 2024/12/2 18:04
 */

@SpringBootTest
public class DemoTest {


    @Resource
    private DealerMapper dealerMapper;

    @DisplayName("测试mybatis引入成功")
    @Test
    public void test() {
        Dealer dealer = dealerMapper.selectById(1L);
        System.out.println(dealer);
    }


    @Test
    public void test2() {
        RedisUtils.getClient();
    }
}
