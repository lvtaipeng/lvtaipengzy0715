package com.lvtaipeng.sc;

import com.lvtaipeng.sc.com.lvtaipeng.controller.BanlanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 启动消费者
 */
@SpringBootApplication
@RibbonClient(name="providerName",configuration = {BanlanceConfig.class})
public class StartConsumer {

    public static void main(String[] args) {
        SpringApplication.run(StartConsumer.class);
    }
}
