package com.xcy.blog.mapper;

import com.xcy.blog.pojo.ArticleCategoryRef;
import com.xcy.blog.pojo.ArticleCategoryRefExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleCategoryRefMapper {
    int countByExample(ArticleCategoryRefExample example);

    int deleteByExample(ArticleCategoryRefExample example);

    int insert(ArticleCategoryRef record);

    int insertSelective(ArticleCategoryRef record);

    List<ArticleCategoryRef> selectByExample(ArticleCategoryRefExample example);

    int updateByExampleSelective(@Param("record") ArticleCategoryRef record, @Param("example") ArticleCategoryRefExample example);

    int updateByExample(@Param("record") ArticleCategoryRef record, @Param("example") ArticleCategoryRefExample example);
}