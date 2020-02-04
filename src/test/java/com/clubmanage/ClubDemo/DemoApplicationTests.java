package com.clubmanage.ClubDemo;

import com.clubmanage.ClubDemo.config.testConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class )
class DemoApplicationTests {

    @Autowired private com.clubmanage.ClubDemo.config.testConfig testConfig;
    @Test
    void contextLoads() {
        System.out.println("asdada"+testConfig.getTestMap());
    }

}
