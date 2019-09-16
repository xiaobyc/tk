package com.tk.migrate.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin_question_know")
public class AdminQuestionKnow {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer questionId;
    private Integer seat;
    private Integer knowId;
    private String tyKnowId;
    private Integer type;
}
