package life.majiang.mycommunity.advice;

import life.majiang.mycommunity.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 苦逼萌新
 * @date 4/11/2020
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model) {

        if(e instanceof CustomizeException){
            model.addAttribute("message", e.getMessage());
        }else {
            model.addAttribute("message", "服务冒烟了，要不然你稍后再试试！！！");
        }
        return new ModelAndView("error");
    }

}
