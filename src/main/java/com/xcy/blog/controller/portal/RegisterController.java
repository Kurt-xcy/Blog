package com.xcy.blog.controller.portal;

import com.xcy.blog.VO.JsonResult;
import com.xcy.blog.VO.Result;
import com.xcy.blog.VO.UploadFileVO;
import com.xcy.blog.pojo.User;
import com.xcy.blog.service.UserRoleService;
import com.xcy.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
@Slf4j
@Controller
public class RegisterController {

    @Autowired
    UserService userServiceImpl;

    @Autowired
    UserRoleService userRoleServiceImpl;

    @RequestMapping("/registerPage")
    public String registerPage(){
        return "Register/register";
    }

    @RequestMapping("/registerSubmit")
    public String register(User user){
        User user2 = userServiceImpl.getUserByName(user.getUserName());
        User user3 = userServiceImpl.getUserByEmail(user.getUserEmail());

        if(user2==null&&user3==null) {
            user.setUserRegisterTime(new Date());
            user.setUserStatus(1);
            userServiceImpl.insertUser(user);
            User usertemp = userServiceImpl.getUserByName(user.getUserName());
            userRoleServiceImpl.insertUserRole(usertemp.getUserId(),2);
        }

        return "Admin/login";
    }



    @RequestMapping("/registerCheckUserName")
    @ResponseBody
    public Result cheUserNameReg(HttpServletRequest request){
        Result result = new Result();
        String username = request.getParameter("username");
        User user = userServiceImpl.getUserByName(username);
        if(user!=null){
            result.setCode(Result.RESULT_WRONG);
            result.setMsg("用户名已存在");
            return result;
        }
        result.setCode(Result.RESULT_OK);
        result.setMsg("");
        return result;
    }

    @RequestMapping("/registerCheckUserEmail")
    @ResponseBody
    public Result checkUserEmail(HttpServletRequest request){
        Result result = new Result();
        String email = request.getParameter("email");
        User user = userServiceImpl.getUserByEmail(email);
        if(user!=null){
            result.setCode(Result.RESULT_WRONG);
            result.setMsg("电子邮箱已存在");
            return result;
        }
        result.setCode(Result.RESULT_OK);
        result.setMsg("");
        return result;

    }


    /**
     * 文件保存目录，物理路径
     */

    public final String rootPath = "/usr/local/blogfile/uploads";

    public final String allowSuffix = ".bmp.jpg.jpeg.png.gif.pdf.doc.zip.rar.gz";

    /**
     * 上传文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/register/upload/img", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadFile(@RequestParam("file") MultipartFile file) {

        //1.文件后缀过滤，只允许部分后缀
        //文件的完整名称,如spring.jpeg
        String filename = file.getOriginalFilename();
        //文件名,如spring
        String name = filename.substring(0, filename.indexOf("."));
        //文件后缀,如.jpeg
        String suffix = filename.substring(filename.lastIndexOf("."));

        if (allowSuffix.indexOf(suffix) == -1) {
            return new JsonResult().fail("不允许上传该后缀的文件！");
        }


        //2.创建文件目录
        //创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1));

        //目标文件
        File descFile = new File(rootPath + File.separator + dateDirs + File.separator + filename);
        int i = 1;
        //若文件存在重命名
        String newFilename = filename;
        while (descFile.exists()) {
            newFilename = name + "(" + i + ")" + suffix;
            String parentPath = descFile.getParent();
            descFile = new File(parentPath + File.separator + newFilename);
            i++;
        }
        //判断目标文件所在的目录是否存在
        if (!descFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            descFile.getParentFile().mkdirs();
        }

        //3.存储文件
        //将内存中的数据写入磁盘
        try {
            file.transferTo(descFile);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传失败，cause:{}", e);
        }
        //完整的url
        String fileUrl = "/uploads/" + dateDirs + "/" + newFilename;

        //4.返回URL
        UploadFileVO uploadFileVO = new UploadFileVO();
        uploadFileVO.setTitle(filename);
        uploadFileVO.setSrc(fileUrl);
        return new JsonResult().ok(uploadFileVO);
    }
}
