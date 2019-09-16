package com.tk.migrate.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Classname Question
 * @Description TODO
 * @Date 2019/9/6 10:55 AM
 * @Created by alex
 */
@TableName("admin_question")
@Data
public class Question {
    @TableId(value = "tid",type = IdType.AUTO)
    private Integer tId;
    @TableField("word_id")
    private Integer wordId;
    @TableField("test_type")
    private Integer testType;
    @TableField("test_type_name")
    private String testTypeName;
    @TableField("body")
    private String body;
    @TableField("answer")
    private  String answer;
    @TableField("analysis")
    private String analysis;
    @TableField("note")
    private String note;
    @TableField("child_num")
    private Integer childNum;
    @TableField("pack_num")
    private Integer packNum;
    @TableField("options_num")
    private Integer optionsNum;
    @TableField("options")
    private String options;
    @TableField("options_body")
    private String optionsBody;
    @TableField("difficulty")
    private Integer difficulty;
    @TableField("user_id")
    private Integer userId;
    @TableField("subject_id")
    private String subjectId;
    @TableField("knowtype")
    private Integer knowType;
    @TableField("state")
    private Integer  state;
    @TableField("source")
    private Integer source;
    @TableField("source_id")
    private String sourceId;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("ques_comment")
    private String quesComment;
    @TableField("ques_type")
    private String quesType;
    @TableField("paper_id")
    private String paperId;
    @TableField("paper_name")
    private String paperName;
    @TableField("edu_subject_id")
    private String eduSubjectId;
    @TableField("edu_period_id")
    private String eduPeriodId;
    @TableField("edu_point")
    private String eduPoint;
    @TableField("add_time")
    private Integer addTime;
    @TableField("last_time")
    private Integer lastTime;
}
