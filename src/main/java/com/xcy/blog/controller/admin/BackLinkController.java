package com.xcy.blog.controller.admin;



import com.xcy.blog.pojo.Link;
import com.xcy.blog.service.LinkService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/admin/link")
public class BackLinkController {

    @Autowired
    private LinkService linkServiceImpl;

    /**
     * 后台链接列表显示
     *
     * @return modelAndView
     */
    @RequestMapping(value = "")
    public ModelAndView linkList()  {
        ModelAndView modelandview = new ModelAndView();

        List<Link> linkList = linkServiceImpl.listLink();
        modelandview.addObject("linkList",linkList);

        modelandview.setViewName("Admin/Link/index");
        return modelandview;

    }

    /**
     * 后台添加链接页面显示
     *
     * @return modelAndView
     */
    @RequestMapping(value = "/insert")
    public ModelAndView insertLinkView()  {
        ModelAndView modelAndView = new ModelAndView();

        List<Link> linkList = linkServiceImpl.listLink();
        modelAndView.addObject("linkList",linkList);

        modelAndView.setViewName("Admin/Link/insert");
        return modelAndView;
    }

    /**
     * 后台添加链接页面提交
     *
     * @param link 链接
     * @return 响应
     */
    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String insertLinkSubmit(Link link)  {
        link.setLinkCreateTime(new Date());
        link.setLinkUpdateTime(new Date());
        link.setLinkStatus(1);
        linkServiceImpl.insertLink(link);
        return "redirect:/admin/link/insert";
    }

    /**
     * 删除链接
     *
     * @param id 链接ID
     * @return 响应
     */
    @RequestMapping(value = "/delete/{id}")
    @RequiresRoles("admin")
    public String deleteLink(@PathVariable("id") Integer id)  {

        linkServiceImpl.deleteLink(id);
        return "redirect:/admin/link";
    }

    /**
     * 编辑链接页面显示
     *
     * @param id
     * @return modelAndVIew
     */
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editLinkView(@PathVariable("id") Integer id)  {
        ModelAndView modelAndView = new ModelAndView();

        Link linkCustom =  linkServiceImpl.getLinkById(id);
        modelAndView.addObject("linkCustom",linkCustom);

        List<Link> linkList = linkServiceImpl.listLink();
        modelAndView.addObject("linkList",linkList);

        modelAndView.setViewName("Admin/Link/edit");
        return modelAndView;
    }


    /**
     * 编辑链接提交
     *
     * @param link 链接
     * @return 响应
     */
    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String editLinkSubmit(Link link)  {
        link.setLinkUpdateTime(new Date());
        linkServiceImpl.updateLink(link);
        return "redirect:/admin/link";
    }
}
