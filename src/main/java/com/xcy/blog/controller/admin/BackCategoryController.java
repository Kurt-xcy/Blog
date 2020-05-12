package com.xcy.blog.controller.admin;



import com.xcy.blog.pojo.Category;
import com.xcy.blog.service.ArticleCategoryRefService;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.CategoryService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
@RequestMapping("/admin/category")
public class BackCategoryController {

    @Autowired
    private ArticleService articleServiceImpl;


    @Autowired
    private CategoryService categoryServiceImpl;

    @Autowired
    private ArticleCategoryRefService articleCategoryRefServiceImpl;
    /**
     * 后台分类列表显示
     *
     * @return
     */
    @RequestMapping(value = "")
    public ModelAndView categoryList()  {
        ModelAndView modelandview = new ModelAndView();
        List<Category> categoryList = categoryServiceImpl.listCategoryWithCount();
        modelandview.addObject("categoryList",categoryList);
        modelandview.setViewName("Admin/Category/index");
        return modelandview;

    }


    /**
     * 后台添加分类提交
     *
     * @param category
     * @return
     */
    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String insertCategorySubmit(Category category)  {
        categoryServiceImpl.insertCategory(category);
        return "redirect:/admin/category";
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    @RequiresRoles("admin")
    public String deleteCategory(@PathVariable("id") Integer id)  {
        //禁止删除有文章的分类
        int count = articleCategoryRefServiceImpl.countArticleByCategoryId(id);

        if (count == 0) {
            categoryServiceImpl.deleteCategory(id);
            articleCategoryRefServiceImpl.deleteByCategoryId(id);
        }
        return "redirect:/admin/category";
    }

    /**
     * 编辑分类页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editCategoryView(@PathVariable("id") Integer id)  {
        ModelAndView modelAndView = new ModelAndView();

        Category category =  categoryServiceImpl.getCategoryById(id);
        modelAndView.addObject("category",category);

        List<Category> categoryList = categoryServiceImpl.listCategoryWithCount();
        modelAndView.addObject("categoryList",categoryList);

        modelAndView.setViewName("Admin/Category/edit");
        return modelAndView;
    }

    /**
     * 编辑分类提交
     *
     * @param category 分类
     * @return 重定向
     */
    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String editCategorySubmit(Category category)  {
        categoryServiceImpl.updateCategory(category);
        return "redirect:/admin/category";
    }
}
