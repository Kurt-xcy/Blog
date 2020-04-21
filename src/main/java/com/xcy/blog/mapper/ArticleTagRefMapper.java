package com.xcy.blog.mapper;

import com.xcy.blog.pojo.ArticleTagRefExample;
import com.xcy.blog.pojo.ArticleTagRefKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleTagRefMapper {
    int countByExample(ArticleTagRefExample example);

    int deleteByExample(ArticleTagRefExample example);

    int deleteByPrimaryKey(ArticleTagRefKey key);

    int insert(ArticleTagRefKey record);

    int insertSelective(ArticleTagRefKey record);

    List<ArticleTagRefKey> selectByExample(ArticleTagRefExample example);

    int updateByExampleSelective(@Param("record") ArticleTagRefKey record, @Param("example") ArticleTagRefExample example);

    int updateByExample(@Param("record") ArticleTagRefKey record, @Param("example") ArticleTagRefExample example);
}