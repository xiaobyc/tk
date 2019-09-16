package com.tk.migrate.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tk.migrate.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CategoryDao
 * @Description TODO
 * @Date 2019/9/12 9:27 AM
 * @Created by alex
 */
public interface CategoryDao extends BaseMapper<Category> {

    public List<Category> selectCategoryList(@Param("eduQuesTypeName") String eduQuesTypeName);
}
