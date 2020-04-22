package com.xcy.blog.interceptor;


import com.xcy.blog.entity.ArticleStatus;
import com.xcy.blog.entity.LinkStatus;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Category;
import com.xcy.blog.pojo.Menu;
import com.xcy.blog.pojo.Options;
import com.xcy.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyanzhao
 */
@Component
public class HomeResourceInterceptor implements HandlerInterceptor {
    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private CategoryService categoryServiceImpl;

    @Autowired
    private TagService tagServiceImpl;

    @Autowired
    private LinkService linkServiceImpl;

    @Autowired
    private OptionsService optionsServiceImpl;

    @Autowired
    private MenuService menuServiceImpl;

    /**
     * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {

        // 菜单显示
        List<Menu> menuList = menuServiceImpl.listMenu();
        request.setAttribute("menuList", menuList);

        List<Category> categoryList = categoryServiceImpl.listCategory();
        request.setAttribute("allCategoryList", categoryList);

        //获得网站概况
        List<String> siteBasicStatistics = new ArrayList<String>();
        siteBasicStatistics.add(articleServiceImpl.countArticle(ArticleStatus.PUBLISH.getValue()) + "");
        siteBasicStatistics.add(articleServiceImpl.countArticleComment() + "");
        siteBasicStatistics.add(categoryServiceImpl.countCategory() + "");
        siteBasicStatistics.add(tagServiceImpl.countTag() + "");
        siteBasicStatistics.add(linkServiceImpl.countLink(LinkStatus.NORMAL.getValue()) + "");
        siteBasicStatistics.add(articleServiceImpl.countArticleView() + "");
        request.setAttribute("siteBasicStatistics", siteBasicStatistics);
        //最后更新的文章
        Article lastUpdateArticle = articleServiceImpl.getLastUpdateArticle();
        request.setAttribute("lastUpdateArticle", lastUpdateArticle);

        //页脚显示
        //博客基本信息显示(Options)
        Options options = optionsServiceImpl.getOptions();
        request.setAttribute("options", options);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)  {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)  {

    }
}