package com.cms.migrate.service.impl;

import com.cms.migrate.dao.ExamPointMapper;
import com.cms.migrate.model.ExamPoint;
import com.cms.migrate.service.ExamPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ExamPointServiceImpl
 * @Description TODO
 * @Date 2019/9/9 11:24 AM
 * @Created by alex
 */
@Service
public class ExamPointServiceImpl  implements ExamPointService {
    @Autowired
    private ExamPointMapper examPointMapper;
    @Override
    public List<ExamPoint> selectExamPoint(String subjectId, String periodId) {
        return examPointMapper.selectExamPoint(subjectId,periodId);
    }
}
