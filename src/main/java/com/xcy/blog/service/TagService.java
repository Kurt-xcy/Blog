package com.xcy.blog.service;

import com.xcy.blog.pojo.Tag;

import java.util.List;

public interface TagService {
    /**
     * 查询所有标签
     * @return
     */
    public List<Tag> listTag();

    /**
     * 查询所有标签，带标签下的文章数
     * @return
     */
    public List<Tag> listTagWithCount();

    /**
     * 新增标签
     * @param tag
     * @return
     */
    public Integer insertTag(Tag tag);

    /**
     * 删除标签
     * @param id
     * @return
     */
    public Integer deleteTag(Integer id);

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    public Tag getTagById(Integer id);

    /**
     * 更新标签
     * @param tag
     * @return
     */
    public Integer updateTag(Tag tag);

    /**
     * 查询所有标签
     * @return
     */
    public Integer countTag();
}
