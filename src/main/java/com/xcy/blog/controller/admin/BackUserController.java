package com.xcy.blog.controller.admin;

import com.xcy.blog.VO.CommentVO;
import com.xcy.blog.VO.Result;
import com.xcy.blog.VO.UserVO;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.User;
import com.xcy.blog.service.UserService;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class BackUserController {
    @Autowired
    private UserService userServiceImpl;

    /**
     * 后台用户列表显示
     * @return
     */
    @RequestMapping(value = "")
    public ModelAndView userList()  {
        ModelAndView modelandview = new ModelAndView();

        List<UserVO> userListVO = userServiceImpl.listUserVO();

        modelandview.addObject("userList",userListVO);
        modelandview.setViewName("Admin/User/index");
        return modelandview;

    }

    /**
     * 个人信息页面展示
     * @return
     */
    @RequestMapping("/profile")
    public ModelAndView profile(){
        //之前登陆时的user信息已经存入session
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/User/profile");
        return modelAndView;
    }

    /**
     * 编辑个人信息页面展示
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editUserView(@PathVariable("id") Integer id,HttpServletRequest request)  {
        ModelAndView modelAndView = new ModelAndView();

        User userSession = (User)request.getSession().getAttribute("user");
        if (userSession.getUserId()!=id){
            throw new UnauthorizedException();
        }
        //User user =  userServiceImpl.getUserById(id);
        modelAndView.addObject("user",userSession);

        modelAndView.setViewName("Admin/User/edit");
        return modelAndView;
    }

    @RequestMapping("/checkUserEmail")
    @ResponseBody
    public Result checkUserEmail(HttpServletRequest request){
        Result result = new Result();
        String email = request.getParameter("email");
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userServiceImpl.getUserByEmail(email);
        if(user!=null){
            if (email.equals(user.getUserEmail())){
                if (id!=user.getUserId()){
                    result.setCode(Result.RESULT_WRONG);
                    result.setMsg("电子邮箱已存在");
                    return result;
                }
            }
        }
        result.setCode(Result.RESULT_OK);
        result.setMsg("");
        return result;

    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public Result cheUserName(HttpServletRequest request){
        Result result = new Result();
        String username = request.getParameter("username");
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userServiceImpl.getUserByName(username);
        if(user!=null){
            if (username.equals(user.getUserName())){
                if(user.getUserId()!=id){
                    result.setCode(Result.RESULT_WRONG);
                    result.setMsg("用户名已存在");
                    return result;
                }
            }
        }
        result.setCode(Result.RESULT_OK);
        result.setMsg("");
        return result;
    }

    /**
     * 编辑用户提交
     * @param user
     * @return
     */
    @RequestMapping(value = "/editSubmit")
    public String editUserSubmit(User user,HttpServletRequest request)  {
        userServiceImpl.updUser(user);
        return "redirect:/admin/user";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    @RequiresRoles(value = {"admin"})
    public String deleteUser(@PathVariable("id") Integer id)  {
        userServiceImpl.deleteUser(id);
        return "redirect:/admin/user";
    }

    /**
     * 后台添加用户页面显示
     * @return
     */
    @RequestMapping(value = "/insert")
    public ModelAndView insertUserView()  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/User/insert");
        return modelAndView;
    }
    /**
     * 后台添加用户页面提交
     *
     * @param user
     * @return
     */

    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String insertUserSubmit(User user)  {
        User user2 = userServiceImpl.getUserByName(user.getUserName());
        User user3 = userServiceImpl.getUserByEmail(user.getUserEmail());
        if(user2==null&&user3==null) {
            user.setUserRegisterTime(new Date());
            user.setUserStatus(1);
            userServiceImpl.insertUser(user);
        }
        return "redirect:/admin/user";
    }

}
