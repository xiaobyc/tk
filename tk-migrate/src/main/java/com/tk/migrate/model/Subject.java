package com.tk.migrate.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Subject
 * @Description TODO
 * @Date 2019/9/10 4:04 PM
 * @Created by alex
 */
@TableName("admin_subject")
@Data
public class Subject {
    @TableId("ty_subject_id")
    private  Integer subjectId;
    @TableField("ty_subject_item")
    private String subjectItem;
    @TableField("periods_id")
    private String periodId;
}
