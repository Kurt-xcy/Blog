package com.xcy.blog.service;

import com.github.pagehelper.PageInfo;
import com.xcy.blog.VO.CommentVO;
import com.xcy.blog.pojo.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 查询最新的几个评论
     * @param limit
     * @return
     */
    public List<CommentVO> listRecentComment(Integer limit);

    /**
     * 查询指定页数的评论
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<Comment> listCommentByPage(Integer pageIndex, Integer pageSize);

    /**
     * 新增评论
     * @return
     */
    public Integer insertComment(Comment comment);

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment getCommentById(Integer id);

    /**
     * 根据id删除评论
     * @param id
     * @return
     */
    public Integer deleteComment(Integer id);

    /**
     * 根据id查询子评论
     * @param id
     * @return
     */
    public List<Comment> listChildComment(Integer id);

    /**
     * 更新评论
     * @param comment
     * @return
     */
    public Integer updateComment(Comment comment);

    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */
    public List<Comment> listCommentByArticleId(Integer articleId);
}
