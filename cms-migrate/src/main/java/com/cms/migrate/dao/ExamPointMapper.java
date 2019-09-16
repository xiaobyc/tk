package com.cms.migrate.dao;

import com.cms.migrate.model.ExamPoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname ExamPointDao
 * @Description TODO
 * @Date 2019/9/9 11:23 AM
 * @Created by alex
 */
@Mapper
public interface ExamPointMapper  {

    public List<ExamPoint> selectExamPoint(@Param("subjectId") String subjectId, @Param("periodId") String periodId);
}
