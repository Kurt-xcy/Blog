package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.ArticleCategoryRefMapper;
import com.xcy.blog.mapper.CategoryMapper;
import com.xcy.blog.pojo.ArticleCategoryRef;
import com.xcy.blog.pojo.ArticleCategoryRefExample;
import com.xcy.blog.pojo.Category;
import com.xcy.blog.pojo.CategoryExample;
import com.xcy.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleCategoryRefMapper articleCategoryRefMapper;
    @Override
    public List<Category> listCategory() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public List<Category> listCategoryWithCount() {
        List<Category> categoryList = categoryMapper.selectByExample(new CategoryExample());
        for (Category category:categoryList){
            ArticleCategoryRefExample example = new ArticleCategoryRefExample();
            example.createCriteria().andCategoryIdEqualTo(category.getCategoryId());
            List<ArticleCategoryRef> articleCategoryRefList = articleCategoryRefMapper.selectByExample(example);
            category.setArticleCount(articleCategoryRefList.size());
        }
        return  categoryList;
    }

    @Override
    public Integer insertCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public Integer deleteCategory(Integer categoryId) {
        return categoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public Category getCategoryById(Integer categoryId) {

        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public Integer updateCategory(Category category) {
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public Integer countCategory() {
        return categoryMapper.countByExample(new CategoryExample());
    }
}
