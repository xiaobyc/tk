package com.tk.migrate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.migrate.dao.CategoryDao;
import com.tk.migrate.model.Category;
import com.tk.migrate.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CategoryServiceImpl
 * @Description TODO
 * @Date 2019/9/12 9:48 AM
 * @Created by alex
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao,Category> implements CategoryService {
    @Override
    public List<Category> selectCategoryList(String eduQuesTypeName) {
        return baseMapper.selectCategoryList(eduQuesTypeName);
    }
}
