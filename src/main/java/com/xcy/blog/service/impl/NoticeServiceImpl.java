package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.NoticeMapper;
import com.xcy.blog.pojo.Notice;
import com.xcy.blog.pojo.NoticeExample;
import com.xcy.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> listNotice() {
        return noticeMapper.selectByExample(new NoticeExample());
    }

    @Override
    public List<Notice> listNoticeByStatus(Integer status) {
        NoticeExample example = new NoticeExample();
        example.createCriteria().andNoticeStatusEqualTo(status);
        return noticeMapper.selectByExample(example);
    }

    @Override
    public Integer insertNotice(Notice notice) {
        return noticeMapper.insert(notice);
    }

    @Override
    public Integer deleteNotice(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Notice getNoticeById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateNotice(Notice notice) {
        return noticeMapper.updateByPrimaryKey(notice);
    }
}
