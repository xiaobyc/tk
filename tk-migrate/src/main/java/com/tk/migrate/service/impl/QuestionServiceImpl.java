package com.tk.migrate.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.migrate.dao.QuestionDao;
import com.tk.migrate.model.Category;
import com.tk.migrate.model.Question;
import com.tk.migrate.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname QuestionServiceImpl
 * @Description TODO
 * @Date 2019/9/6 11:00 AM
 * @Created by alex
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionDao,Question> implements QuestionService {
    @Override
    public void updateSubjectByPeriodAndSubjectId(String subjectId, String subjectItem, String periodId) {
        baseMapper.updateSubjectByPeriodAndSubjectId(subjectId,subjectItem,periodId);
    }

    @Override
    public void updateQuesTypeId(List<Category> list, String eduQuesType) {
        baseMapper.updateQuesTypeId(list,eduQuesType);
    }

    @Override
    public Page<Question> selectQuesPageList(Page<Question> page) {
        return baseMapper.selectQuesPageList(page);
    }

    @Override
    public void updateQuestionList(List<Question> list) {
        baseMapper.updateQuestionList(list);
    }

    @Override
    public Page<Question> selectQuesPageListForKnow(Page<Question> page) {
        return baseMapper.selectQuesPageListForKnow(page);
    }
}
