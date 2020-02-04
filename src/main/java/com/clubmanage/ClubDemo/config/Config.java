package com.clubmanage.ClubDemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "onlyoffice")
public class Config {

  private String convertServer;

  public String getConvertServer() {
    return convertServer;
  }

  public void setConvertServer(String convertServer) {
    this.convertServer = convertServer;
  }
}
