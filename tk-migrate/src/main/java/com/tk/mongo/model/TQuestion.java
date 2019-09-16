package com.tk.mongo.model;

import lombok.Data;

import java.util.List;

/**
 * @Classname T_Question
 * @Description TODO
 * @Date 2019/9/6 2:20 PM
 * @Created by alex
 */
@Data
public class TQuestion {
    private String quesId;
    private String degree;
    private String subjectEnname;
    private String difficId;
    private String questypeId;
    private String quesContent;

    private List<Option> optList;

    private String paperId;
    private String paperName;
    private String subjectId;
    private String periodId;
    private String answer;

    private String content;

    private List<Point> pointList;

    private String quesAnswer;

    private String quesComment;
    private String topic;

    private String relPointList;
}
