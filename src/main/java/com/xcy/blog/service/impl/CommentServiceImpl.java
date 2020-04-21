package com.xcy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.xcy.blog.VO.CommentVO;
import com.xcy.blog.mapper.ArticleMapper;
import com.xcy.blog.mapper.CommentMapper;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Comment;
import com.xcy.blog.pojo.CommentExample;
import com.xcy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<CommentVO> listRecentComment(Integer limit) {
        CommentExample example = new CommentExample();
        example.setOrderByClause("comment_create_time desc");
        PageHelper.startPage(1,5);
        List<Comment> list = commentMapper.selectByExample(example);
        List<CommentVO> listvo = new ArrayList<>();
        for (Comment c:list){
            CommentVO cvo = new CommentVO(c);
            Article article = articleMapper.selectByPrimaryKey(c.getCommentArticleId());
            cvo.setArticle(article);
            listvo.add(cvo);
        }
        return listvo;
    }
}
