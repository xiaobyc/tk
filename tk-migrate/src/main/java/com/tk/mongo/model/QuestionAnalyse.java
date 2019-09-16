package com.tk.mongo.model;

import lombok.Data;

import java.util.List;

/**
 * @Classname QuestionAnalyse
 * @Description TODO
 * @Date 2019/9/6 3:21 PM
 * @Created by alex
 */
@Data
public class QuestionAnalyse {

    private String questionId;
    private String answer;
    private String quesAnswer;
    private String content;
    private String quesComment;
    private String topic;
    private List<Point> pointList;
}
