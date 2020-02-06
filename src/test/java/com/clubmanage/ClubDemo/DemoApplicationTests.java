package com.clubmanage.ClubDemo;

import com.clubmanage.ClubDemo.Pojo.Club;
import com.clubmanage.ClubDemo.config.testConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@SpringBootTest
@RunWith(SpringRunner.class )
class DemoApplicationTests {

    @Autowired private com.clubmanage.ClubDemo.config.testConfig testConfig;
    @Test
    void contextLoads() {
        System.out.println("asdada"+testConfig.getTestMap());
    }

    @Test
    void stringFormatTest(){
        Club club=new Club();
        club.setName("mike");
        club.setManager("junior");
        club.setCreateDate(new Date(121212));
        club.setActivitytimes(1);
        club.setMembercount(1);
        String test=String.format("%s :%s",club.getManager(),club.getName());
        System.out.println(test);
    }

}
