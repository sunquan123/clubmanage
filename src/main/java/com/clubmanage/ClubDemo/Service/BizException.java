package com.clubmanage.ClubDemo.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BizException {
//  private static final Logger logger = LoggerFactory.getLogger(BizException.class);

  /**
   * 运行时异常
   * @param exception
   * @return
   */
  @ExceptionHandler({ RuntimeException.class })
  @ResponseStatus(HttpStatus.OK)
  public ModelAndView processException(RuntimeException exception) {
//    logger.info("自定义异常处理-RuntimeException");
    ModelAndView m = new ModelAndView();
    m.addObject("exception", exception.getMessage());
    m.setViewName("error/500");
    return m;

  }

  /**
   * Excepiton异常
   * @param exception
   * @return
   */
  @ExceptionHandler({ Exception.class })
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ModelAndView processException(Exception exception) {
//    logger.info("自定义异常处理-Exception");
    ModelAndView m = new ModelAndView();
    m.addObject("exception", exception.getMessage());
    m.setViewName("error/500");
    return m;

  }
}
