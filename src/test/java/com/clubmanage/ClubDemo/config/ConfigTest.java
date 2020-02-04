package com.clubmanage.ClubDemo.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties({com.clubmanage.ClubDemo.config.Config.class})
class ConfigTest {
  @Autowired private com.clubmanage.ClubDemo.config.Config config;

  @Test
  void contextLoads() {
    System.out.println("convertServer:" + config.getConvertServer());
  }
}
