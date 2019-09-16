package com.tk.migrate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tk.migrate.model.Category;

import java.util.List;

/**
 * @Classname CategoryService
 * @Description TODO
 * @Date 2019/9/12 9:29 AM
 * @Created by alex
 */
public interface CategoryService  extends IService<Category>{

    public List<Category> selectCategoryList(String eduQuesTypeName);
}
