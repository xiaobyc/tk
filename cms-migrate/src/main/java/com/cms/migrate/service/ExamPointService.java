package com.cms.migrate.service;

import com.cms.migrate.model.ExamPoint;

import java.util.List;

/**
 * @Classname ExamPointService
 * @Description TODO
 * @Date 2019/9/9 11:23 AM
 * @Created by alex
 */
public interface ExamPointService  {

    public List<ExamPoint> selectExamPoint(String subjectId,String periodId);
}
