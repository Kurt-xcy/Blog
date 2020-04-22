package com.xcy.blog.controller.portal;


import com.xcy.blog.entity.LinkStatus;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Link;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
public class LinkController {
	@Autowired
	private LinkService linkServiceImpl;

	@Autowired
	private ArticleService articleServiceImpl;

	@RequestMapping("/applyLink")
	public String applyLinkView(Model model)  {
		//侧边栏显示
		//获得热评文章
		List<Article> mostCommentArticleList = articleServiceImpl.listArticleByCommentCount(8);
		model.addAttribute("mostCommentArticleList", mostCommentArticleList);
		return "Home/Page/applyLink";
	}


	@RequestMapping(value = "/applyLinkSubmit",method = {RequestMethod.POST})
	@ResponseBody
	public void applyLinkSubmit(Link link)  {
		link.setLinkStatus(LinkStatus.HIDDEN.getValue());
		link.setLinkCreateTime(new Date());
		link.setLinkUpdateTime(new Date());
		linkServiceImpl.insertLink(link);
	}
}
