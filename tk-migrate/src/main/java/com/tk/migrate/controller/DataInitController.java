package com.tk.migrate.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tk.migrate.model.*;
import com.tk.migrate.service.*;
import com.tk.migrate.utils.CalculateDegree;
import com.tk.migrate.utils.PointVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DataInitController
 * @Description TODO
 * @Date 2019/9/10 4:14 PM
 * @Created by alex
 */
@RestController
@RequestMapping("/dataInit")
public class DataInitController {

    private static Logger logger = LoggerFactory.getLogger(DataInitController.class);

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AdminKnowledgeService adminKnowledgeService;
    @Autowired
    private AdminQuestionKnowService adminQuestionKnowService;

    @RequestMapping(value = "/initSubject")
    public String  init(){
       List<Subject> list = subjectService.list();
        for(Subject subject:list){

            //questionService.update();
//            UpdateWrapper<Question>   wrapper = new UpdateWrapper<>();
//            logger.error("subjectId="+subject.getSubjectId()+";edu_subject_id="+subject.getSubjectItem()+";edu_period_id="+subject.getPeriodId());
//            wrapper.set("subject_id",String.valueOf(subject.getSubjectId()));
//            wrapper.eq("edu_subject_id",subject.getSubjectItem());
//            wrapper.eq("edu_period_id",subject.getPeriodId());
//            wrapper.eq("user_id",9999);
//            wrapper.eq("source_id",4);
//            questionService.update(wrapper);

            questionService.updateSubjectByPeriodAndSubjectId(String.valueOf(subject.getSubjectId()),
                    subject.getSubjectItem(),subject.getPeriodId());
        }
        logger.info("执行更换学段完毕");
        return "ok";
    }

    @RequestMapping(value = "/initQuesType")
    public String initQuesType(){
        List<Category> list = CalculateDegree.calculateQuesType(null);
        for(Category category:list){
          List<Category> currentList =  categoryService.selectCategoryList(category.getEduQuesTypeName());
            questionService.updateQuesTypeId(currentList,category.getEduQuesType());
        }
        return "ok";
    }
    @RequestMapping(value = "/fillBlankInit")
    public String fillBlankInit(){
        recursiveQues(1,100);
        return "ok";
    }


    public void recursiveQues(Integer currentPage,Integer pageSize){
        Page<Question> page = new Page<Question>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        long searchTime = System.currentTimeMillis();
        page  = questionService.selectQuesPageList(page);
        long searchEndTime = System.currentTimeMillis();
        List<Question>  list = page.getRecords();
        if(list!=null&&list.size()>0){
            for(Question question: list){
                String answer = question.getAnswer();
                if(StringUtils.isNotEmpty(answer)){
                    String [] ans = answer.split("、");
                    question.setPackNum(ans.length);
                    StringBuilder stringBuilder = new StringBuilder();
                    for(int i=0;i<ans.length;i++ ){
                        stringBuilder.append("@@");
                        stringBuilder.append(ans[i]);
                    }
                    question.setAnswer(stringBuilder.toString());
                }
            }
            long updateTime =System.currentTimeMillis();
            questionService.updateQuestionList(list);
            long updateEndTime =System.currentTimeMillis();
            logger.info("search cost Time="+(searchEndTime-searchTime)+" updateTime cost Time="+(updateEndTime-updateTime));
            recursiveQues(currentPage+1,pageSize);
        }else {
            return;
        }
    }


    @RequestMapping(value = "/knowOne")
    public String  changeKnow(){
        recurrenceList(15000,100);
        return "ok";
    }


    public void recurrenceList(Integer currentPage,Integer pageSize){
        Page<Question> page = new Page();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        long listTime = System.currentTimeMillis();
        page=questionService.selectQuesPageListForKnow(page);
        long  listEndTime = System.currentTimeMillis();

        logger.info("listTime cost ="+(listEndTime-listTime) +" ;; currentPage="+currentPage);
        if(currentPage>=25000){
            return;
        }
        List<Question> list=page.getRecords();
        if(list!=null&&list.size()>0){
            long pointStart = System.currentTimeMillis();
            toInsertPoint(list,currentPage);
            long pointEnd = System.currentTimeMillis();
            logger.info(" point Insert Time ="+(pointEnd-pointStart));
            recurrenceList(currentPage+1,pageSize);
        }else {
            return;
        }
    }

    //处理教学助手题目数据中的知识点转化为3.0库知识点
    public void toInsertPoint(List<Question> list,Integer currentPage){
        try{
            List<AdminQuestionKnow> knowList=new ArrayList<>();
            for (Question question:list) {
                if(StringUtils.isNotEmpty(question.getEduPoint())){
                    //将json字符串转为java对象
                    List<PointVo> pointVoList= JSON.parseArray(question.getEduPoint(),PointVo.class);
                    //获取到该题目的知识点对象之后根据教学助手与3.0库知识点对应关系表查出对应的慧学3.0知识点
                    for (PointVo pointVo:pointVoList) {
                        AdminKnowledge adminKnowledge=adminKnowledgeService.selectKnowledgeById(pointVo.getPointId());
                        if(adminKnowledge!=null&&StringUtils.isNotEmpty(adminKnowledge.getTyKnowledgeId())){
                            AdminQuestionKnow adminQuestionKnow=new AdminQuestionKnow();
                            adminQuestionKnow.setQuestionId(question.getTId());
                            adminQuestionKnow.setSeat(0);
                            adminQuestionKnow.setKnowId(adminKnowledge.getKnowledgeId());
                            adminQuestionKnow.setTyKnowId(adminKnowledge.getTyKnowledgeId());
                            adminQuestionKnow.setType(1);
                            knowList.add(adminQuestionKnow);
                        }
                    }
                }

            }
            if(!knowList.isEmpty()){
                adminQuestionKnowService.saveBatch(knowList);
            }
            logger.info("导入教学助手题目对应的知识点第"+currentPage+"页成功");
        }catch(Exception e){
            logger.error("导入教学助手题目对应的知识点第"+currentPage+"页失败",e);
        }
    }
}
