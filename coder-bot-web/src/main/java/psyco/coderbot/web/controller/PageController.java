package psyco.coderbot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lipeng on 15/10/4.
 */
@Controller
public class PageController {

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index-worthy");
    }


//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleCustomException(Exception ex) {
//        ex.printStackTrace();
//        return error("非法请求");
//
//    }
//
//    private ModelAndView error(String message) {
//        ModelAndView re = new ModelAndView("error");
//        re.addObject("error", message);
//        return re;
//    }
}
