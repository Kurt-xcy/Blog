package com.xcy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<Comment> listCommentByPage(Integer pageIndex, Integer pageSize) {
        CommentExample example = new CommentExample();
        example.setOrderByClause("comment_create_time desc");
        PageHelper.startPage(pageIndex,pageSize);
        List<Comment> commentList= commentMapper.selectByExample(example);
        for (Comment comment:commentList){
            Article article = articleMapper.selectByPrimaryKey(comment.getCommentArticleId());
            comment.setArticle(article);
        }
        return new PageInfo<>(commentList);
    }

    @Override
    public Integer insertComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteComment(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Comment> listChildComment(Integer id) {
        CommentExample example = new CommentExample();
        example.createCriteria().andCommentPidEqualTo(id);
        return commentMapper.selectByExample(example);
    }

    @Override
    public Integer updateComment(Comment comment) {
        return commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    public List<Comment> listCommentByArticleId(Integer articleId) {
        CommentExample example = new CommentExample();
        example.createCriteria().andCommentArticleIdEqualTo(articleId);
        return commentMapper.selectByExample(example);
    }
}
