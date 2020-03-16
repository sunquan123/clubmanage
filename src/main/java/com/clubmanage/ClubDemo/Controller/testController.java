package com.clubmanage.ClubDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class testController {

  /** 测试返回500的接口 */
  @RequestMapping(value = "/error", method = RequestMethod.GET)
  public String errorReturn() throws Exception {
    throw new  Exception("错误信息");
  }
}
