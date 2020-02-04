package com.clubmanage.ClubDemo.Controller;

import com.clubmanage.ClubDemo.Pojo.ConvertParams;
import com.clubmanage.ClubDemo.Pojo.ConvertResponse;
import com.clubmanage.ClubDemo.config.Config;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/onlyoffice")
public class OnlyOfficeController {
  @Autowired private Config config;

  /** 文档转换接口 */
  @RequestMapping(value = "convert", method = RequestMethod.POST)
  public ConvertResponse documentConvert(@RequestBody ConvertParams convertParams)
      throws URISyntaxException {
    URI convertServer = new URI(config.getConvertServer());
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(convertServer);
    Gson gson = new Gson();
    String jsonString = gson.toJson(convertParams);
    StringEntity entity = new StringEntity(jsonString, "UTF-8");
    httpPost.setEntity(entity);
    httpPost.addHeader("Content-Type", "application/json;charset=utf8");
    httpPost.addHeader("Accept", "application/json");
    CloseableHttpResponse response = null;
    ConvertResponse convertResponse = new ConvertResponse();
    try {
      response = httpClient.execute(httpPost);
      HttpEntity responseEntity = response.getEntity();
      if (response.getStatusLine().getStatusCode() == 200) {
        // 反序列化转换响应参数
        String entityStr = EntityUtils.toString(responseEntity);
        convertResponse = gson.fromJson(entityStr, ConvertResponse.class);
        return convertResponse;
      }
    } catch (IOException e) {
      // 日志打印请求onlyoffice转换错误
      e.printStackTrace();
    } finally {
      try {
        // 释放资源
        if (httpClient != null) {
          httpClient.close();
        }
        if (response != null) {
          response.close();
        }
      } catch (IOException e) {
        // 日志打印关闭http请求失败
        e.printStackTrace();
      }
      return convertResponse;
    }
  }
}
