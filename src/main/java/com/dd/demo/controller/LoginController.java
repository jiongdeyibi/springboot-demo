package com.dd.demo.controller;

import com.base.BaseController;
import com.dd.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by I on 2018/1/1.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController{

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        logger.info("======用户进入了ShiroController的/login.html");
        return "login";
    }
    @ResponseBody
    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request) {
        User user= (User) request.getSession().getAttribute("user");
        logger.info("======用户进入了ShiroController的/login.html");
        return user==null?"":user.getUsername();
    }

    @RequestMapping(value = "/logout")
    public String doLogout(HttpServletRequest request, Model model) {
        logger.info("======用户" + request.getSession().getAttribute("user") + "退出了系统");
        SecurityUtils.getSubject().logout();
        return "redirect:login.html";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(User user, HttpServletRequest request, Model model) {
        logger.info("======用户进入了ShiroController的/doLogin.html");
        String msg;
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                request.getSession().setAttribute("user", user);
                SavedRequest savedRequest = WebUtils.getSavedRequest(request);
                // 获取保存的URL
                if (savedRequest == null || savedRequest.getRequestUrl() == null) {
                    return "admin/home";
                } else {
                    //String url = savedRequest.getRequestUrl().substring(12, savedRequest.getRequestUrl().length());
                    return "forward:" + savedRequest.getRequestUrl();
                }
            } else {
                return "login";
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            model.addAttribute("message", msg);
            System.out.println(msg);
        }
        return "login";
    }
}
