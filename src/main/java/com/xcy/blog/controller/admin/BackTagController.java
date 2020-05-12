package com.xcy.blog.controller.admin;



import com.xcy.blog.pojo.Tag;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.ArticleTagRefService;
import com.xcy.blog.service.TagService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
@RequestMapping("/admin/tag")
public class BackTagController {

    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private TagService tagServiceImpl;

    @Autowired
    private ArticleTagRefService articleTagRefServiceImpl;

    /**
     * 后台标签列表显示
     * @return
     */
    @RequestMapping(value = "")
    public ModelAndView index()  {
        ModelAndView modelandview = new ModelAndView();
        List<Tag> tagList = tagServiceImpl.listTagWithCount();
        modelandview.addObject("tagList",tagList);

        modelandview.setViewName("Admin/Tag/index");
        return modelandview;

    }


    /**
     * 后台添加分类页面显示
     *
     * @param tag
     * @return
     */
    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    public String insertTagSubmit(Tag tag)  {
        tagServiceImpl.insertTag(tag);
        return "redirect:/admin/tag";
    }

    /**
     * 删除标签
     *
     * @param id 标签ID
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    @RequiresRoles("admin")
    public String deleteTag(@PathVariable("id") Integer id)  {
        Integer count = articleTagRefServiceImpl.countArticleByTagId(id);
        if (count == 0) {
            tagServiceImpl.deleteTag(id);
        }
        return "redirect:/admin/tag";
    }

    /**
     * 编辑标签页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editTagView(@PathVariable("id") Integer id)  {
        ModelAndView modelAndView = new ModelAndView();

        Tag tag =  tagServiceImpl.getTagById(id);
        modelAndView.addObject("tag",tag);

        List<Tag> tagList = tagServiceImpl.listTagWithCount();
        modelAndView.addObject("tagList",tagList);

        modelAndView.setViewName("Admin/Tag/edit");
        return modelAndView;
    }


    /**
     * 编辑标签提交
     *
     * @param tag
     * @return
     */
    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String editTagSubmit(Tag tag)  {
        tagServiceImpl.updateTag(tag);
        return "redirect:/admin/tag";
    }
}
