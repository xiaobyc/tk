package com.tk.migrate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tk.migrate.model.Category;
import com.tk.migrate.model.Question;

import java.util.List;

/**
 * @Classname QuestionService
 * @Description TODO
 * @Date 2019/9/6 10:59 AM
 * @Created by alex
 */
public interface QuestionService  extends IService<Question> {

    /**
     * 更新替换subjectId
     * @param subjectId
     * @param subjectItem
     * @param periodId
     */
    public void updateSubjectByPeriodAndSubjectId(String subjectId,String subjectItem,String periodId);

    /**
     * 批量更新题型
     * @param list
     * @param eduQuesType
     */
    public void updateQuesTypeId(List<Category> list , String eduQuesType);

    /**
     * 分页获取填空题数据
     * @param page
     * @return
     */
    public Page<Question> selectQuesPageList(Page<Question> page);

    /**
     * 更新填空题答案及其他选项
     * @param list
     */
    public void updateQuestionList(List<Question> list);


    /**
     * 查题目对应知识点修正
     * @param page
     * @return
     */
    public Page<Question>selectQuesPageListForKnow(Page<Question> page);
}
