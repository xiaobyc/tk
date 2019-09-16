package com.tk.migrate.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Category
 * @Description TODO
 * @Date 2019/9/12 9:25 AM
 * @Created by alex
 */
@Data
@TableName("admin_category")
public class Category {
    @TableId("id")
    private Integer id;
    @TableField("ty_subject_id")
    private String subjectId;
    @TableField("question_category_name")
    private String categoryName;
    @TableField(exist = false)
    private String eduQuesType;
    @TableField(exist = false)
    private String eduQuesTypeName;
}
