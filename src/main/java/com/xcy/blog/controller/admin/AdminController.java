package com.xcy.blog.controller.admin;

import com.xcy.blog.VO.CommentVO;
import com.xcy.blog.VO.Result;
import com.xcy.blog.pojo.Article;
import static com.xcy.blog.util.MyUtils.*;
import com.xcy.blog.pojo.User;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.CommentService;
import com.xcy.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class AdminController {

    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private CommentService commentServiceImpl;

    @Autowired
    private UserService userServiceImpl;
    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping("/admin")
    public String index(Model model)  {

        List<Article> articleList = articleServiceImpl.listRecentArticle(5);
        model.addAttribute("articleList",articleList);
        List<CommentVO> commentList = commentServiceImpl.listRecentComment(5);
        model.addAttribute("commentList",commentList);
        return "Admin/index";
    }

    /**
     * 登陆
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        return "Admin/login";
    }

    /**
     * 登陆验证
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/loginVerify")
    @ResponseBody
    public Result loginVerify(HttpServletRequest request, HttpServletResponse response){
      /*  String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        User user = userServiceImpl.getUserByName(username);
        Result result = new Result();
        if(user!=null){
            if(password.equals(user.getUserPass())){
                result.setCode(1);
                result.setMsg("登陆成功");
                //添加session
                request.getSession().setAttribute("user", user);
                if(rememberme!=null&&rememberme.equals("1")){
                    //添加cookie
                    //创建两个Cookie对象
                    Cookie nameCookie = new Cookie("username", username);
                    //设置Cookie的有效期为3天
                    nameCookie.setMaxAge(60 * 60 * 24 * 3);
                    Cookie pwdCookie = new Cookie("password", password);
                    pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                    response.addCookie(nameCookie);
                    response.addCookie(pwdCookie);
                }
            }else{
                result.setCode(0);
                result.setMsg("密码错误，请重试");
            }
        }else{
            result.setCode(0);
            result.setMsg("用户不存在!");
        }
        User userupd = new User();
        userupd.setUserLastLoginIp(getIpAddr(request));
        userupd.setUserLastLoginTime(new Date());
        userServiceImpl.updUser(userupd);
        return result;*/

      //使用shiro
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        Result result = new Result();
        try{
            subject.login(token);
            result.setCode(1);
            result.setMsg("登陆成功");

            //记住我，三天免登陆
            if(rememberme!=null&&rememberme.equals("1")){
                //添加cookie
                //创建两个Cookie对象
                Cookie nameCookie = new Cookie("username", username);
                //设置Cookie的有效期为3天
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie pwdCookie = new Cookie("password", password);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }

            //更新最后登陆的ip和时间
            User userupd = userServiceImpl.getUserByName(username);
            userupd.setUserLastLoginIp(getIpAddr(request));
            userupd.setUserLastLoginTime(new Date());
            userServiceImpl.updUser(userupd);
            //添加session
            User user = userServiceImpl.getUserByName(username);
            user.setUserPass(null);
            request.getSession().setAttribute("user", user);
        }catch (AuthenticationException e){
            e.printStackTrace();
            result.setCode(0);
            result.setMsg("用户名或密码错误，请重试");
        }
        return result;

    }

    /**
     * 登出
     * @param request
     * @return
     */
    @RequestMapping("/admin/logout")
    public String logout(HttpServletRequest request){
        //request.getSession().removeAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        //shiro的logout会清除session
        subject.logout();
        return "redirect:/login";
    }



}
