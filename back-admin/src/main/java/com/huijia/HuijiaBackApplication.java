package com.huijia;

import com.huijia.common.mail.config.properties.MailProperties;
import com.huijia.common.web.config.properties.CaptchaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 启动程序
 *
 * @author Lion Li
 */

@SpringBootApplication
@EnableConfigurationProperties({CaptchaProperties.class, MailProperties.class})
public class HuijiaBackApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(HuijiaBackApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Common-back-plus启动成功   ლ(´ڡ`ლ)ﾞ");
    }

}
