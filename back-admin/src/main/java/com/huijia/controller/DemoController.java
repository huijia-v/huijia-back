package com.huijia.controller;

import com.huijia.common.core.utils.StringUtils;
import com.huijia.domain.Dealer;
import com.huijia.mapper.DealerMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huijia
 * @date 2024/12/2 18:38
 */
@RestController("/test")
public class DemoController {


    @Autowired
    private DealerMapper dealerMapper;

    @GetMapping("/hello")
    public String test() {
        Dealer dealer = dealerMapper.selectById(1);
        return "hello world," + dealer.getAgent();
    }
}
