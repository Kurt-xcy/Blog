package com.xcy.blog.service;

import com.xcy.blog.pojo.Notice;

import java.util.List;

public interface NoticeService {
    /**
     * 查询所有公告
     * @return
     */
    public List<Notice> listNotice();

    /**
     * 新增公告
     * @param notice
     * @return
     */
    public Integer insertNotice(Notice notice);

    /**
     * 删除公告
     * @param id
     * @return
     */
    public Integer deleteNotice(Integer id);

    /**
     * 根据id查询公告
     * @param id
     * @return
     */
    public Notice getNoticeById(Integer id);

    /**
     * 更新公告
     * @param notice
     * @return
     */
    public Integer updateNotice(Notice notice);
}
