package com.clubmanage.ClubDemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.thymeleaf.expression.Maps;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "filemap")
public class testConfig {
    private Map<String,String> testMap= new HashMap<>();

    public Map<String, String> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<String, String> testMap) {
        this.testMap = testMap;
    }
}
