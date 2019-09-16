package com.tk.migrate.utils;

import com.tk.migrate.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname CalculateDegree
 * @Description TODO
 * @Date 2019/9/7 10:43 AM
 * @Created by alex
 */
public class CalculateDegree {
    /**
     * 计算题目的难度系数值
     * @param degree
     * @return
     */
    public static  Integer calculateDegree(float degree){
        if(degree>0.8){
            return 371;
        }else if(degree>0.6){
            return 373;
        }else if(degree>0.4){
            return 372;
        }else if(degree>0.2){
            return 375;
        }else if(degree>0){
            return 378;
        }else {
            return 371;
        }
    }
    /**
     * CMS  t1 多选  t2 填空 t3 解答 t0 单选 t4 判断
     */
    public static List<Category> calculateQuesType(String quesType){
        List<Category> list  = new ArrayList<>();
        Category category = new Category();
        category.setEduQuesType("t0");
        category.setEduQuesTypeName("单选题");
        list.add(category);
        Category category1 = new Category();
        category1.setEduQuesType("t1");
        category1.setEduQuesTypeName("多选题");
        list.add(category1);
        Category category2 = new Category();
        category2.setEduQuesType("t2");
        category2.setEduQuesTypeName("填空题");
        list.add(category2);
        Category category3 = new Category();
        category3.setEduQuesType("t3");
        category3.setEduQuesTypeName("解答题");
        list.add(category3);
        Category category4 = new Category();
        category4.setEduQuesType("t4");
        category4.setEduQuesTypeName("判断题");
        list.add(category4);
        return  list;
    }
}
