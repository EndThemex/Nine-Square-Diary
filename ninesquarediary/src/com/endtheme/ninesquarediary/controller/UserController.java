package com.endtheme.ninesquarediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.endtheme.ninesquarediary.exception.ParameterException;
import com.endtheme.ninesquarediary.exception.ServiceException;
import com.endtheme.ninesquarediary.model.User;
import com.endtheme.ninesquarediary.service.UserService;
import com.endtheme.ninesquarediary.util.SessionUtil;

@Controller
@RequestMapping("page/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 	返回默认的欢迎页面
     * @return
     */
    @RequestMapping("/welcome")
    public ModelAndView indexPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }

    /**
     * 	返回登陆页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    /**
     * 	登陆方法 成功登陆跳转到主页面
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(
                              @RequestParam(value = "userName", defaultValue = "") String userName,
                              @RequestParam(value = "password", defaultValue = "") String password
                              ) {

        ModelAndView modelAndView = new ModelAndView();
        User user = null;
        try {
            user = userService.login(userName, password);
            SessionUtil.addSession("user", user);
            modelAndView.setView(this.getRedirectView("user/welcome"));
        } catch (ParameterException parameterException) {
            SessionUtil.addSession("TIP_MESSAGE", parameterException.getMessage());
            modelAndView.setViewName("login");
            parameterException.printStackTrace();
        } catch (ServiceException serviceException) {
            SessionUtil.addSession("TIP_MESSAGE", serviceException.getMessage());
            modelAndView.setViewName("login");
            serviceException.printStackTrace();
        }

        return modelAndView;
    }

    /**
     * 	返回登陆页面
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");

        return modelAndView;
    }
    
    @RequestMapping(value = "/myspace")
    public ModelAndView mySpace() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/myspace");

        return modelAndView;
    }

}
