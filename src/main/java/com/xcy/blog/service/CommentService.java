package com.xcy.blog.service;

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
}
