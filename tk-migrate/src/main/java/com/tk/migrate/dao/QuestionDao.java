package com.tk.migrate.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tk.migrate.model.Category;
import com.tk.migrate.model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname QuestionDao
 * @Description TODO
 * @Date 2019/9/6 10:59 AM
 * @Created by alex
 */
public interface QuestionDao extends BaseMapper<Question> {

    public void updateSubjectByPeriodAndSubjectId(@Param("subjectId") String subjectId,
                                                  @Param("subjectItem") String subjectItem,
                                                  @Param("periodId") String periodId);


    public void updateQuesTypeId(@Param("list") List<Category> list , @Param("eduQuesType") String eduQuesType);


    public Page<Question> selectQuesPageList(Page<Question> page);

    /**
     * 更新填空题数据
     * @param list
     */
    public void updateQuestionList(@Param("list") List<Question>list);

    /**
     *
     * @param page
     * @return
     */
    public Page<Question> selectQuesPageListForKnow(Page<Question> page);
}
