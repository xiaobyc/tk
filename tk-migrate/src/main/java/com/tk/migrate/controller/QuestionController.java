package com.tk.migrate.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.tk.migrate.model.Question;
import com.tk.migrate.service.QuestionService;
import com.tk.migrate.utils.CalculateDegree;
import com.tk.mongo.model.Option;
import com.tk.mongo.model.TQuestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname QuestionController
 * @Description TODO
 * @Date 2019/9/6 11:02 AM
 * @Created by alex
 */
@RestController
public class QuestionController {

    private  static Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private QuestionService questionService;
//    @Autowired
//    private MongoUtils mongoUtils;

    @RequestMapping(value = "/test")
    public String test(){
      Question question = questionService.getById(5706);
    return question.getBody();
    }

    @RequestMapping(value = "/testMongo")
    public String testMongo(){
        long startTime = System.currentTimeMillis();
        recursiveDb(1,100);
        long entTime = System.currentTimeMillis();
        logger.info("消耗时间 time="+ (entTime-startTime)/1000);
        return  "ok";




    }




    public void recursiveDb(Integer currentPage,Integer pageSize){
//        int start = (currentPage-1)*pageSize+1872400;
//        logger.error("当前执行第="+start);
//        Query query = new Query();
//        query.limit(pageSize);
//        query.skip(start);
//        List<TQuestion> list =   mongoUtils.getMongoTemplate().find(query,TQuestion.class,"t_question");
//        if(list!=null&&list.size()>0){
//                for(TQuestion question :list){
//                    Query analyseQuery = new Query();
//                    Criteria analyseCriteria = new Criteria();
//                    analyseCriteria.and("questionId").is(question.getQuesId());
//                     analyseQuery.addCriteria(analyseCriteria);
//                  List<QuestionAnalyse> analyses =  mongoUtils.getMongoTemplate().find(analyseQuery, QuestionAnalyse.class,"t_question_analyse");
//                    if(analyses!=null&&analyses.size()>0){
//                        QuestionAnalyse  analyse = analyses.get(0);
//                        if(StringUtils.isNotEmpty(analyse.getAnswer())){
//                            question.setAnswer(analyse.getAnswer());
//                        }
//                        if(StringUtils.isNotEmpty(analyse.getContent())){
//                            question.setContent(analyse.getContent());
//                        }
//                        if(StringUtils.isNotEmpty(analyse.getQuesAnswer())){
//                            question.setQuesAnswer(analyse.getQuesAnswer());
//                        }
//                        if(StringUtils.isNotEmpty(analyse.getQuesComment())){
//                            question.setQuesComment(analyse.getQuesComment());
//                        }
//                        if(StringUtils.isNotEmpty(analyse.getTopic())){
//                            question.setTopic(analyse.getTopic());
//                        }
//                        if(analyse.getPointList()!=null){
//                            question.setPointList(analyse.getPointList());
//                        }
//                    }
//                }
//            //执行插入操作
//
//            batchInsertQuestion(list);
//            //递归自己
//            recursiveDb(currentPage+1,pageSize);
//        }else {
//            return;
//        }
    }
    //执行插入操作
    public void batchInsertQuestion(List<TQuestion> tQuestionList){
        List<Question> questions = new ArrayList<>();
        for(TQuestion tQuestion:tQuestionList){
            Question question  =new Question();
            //题干
            question.setBody(tQuestion.getQuesContent());
            //答案
            question.setAnswer(tQuestion.getQuesAnswer());


            //分析
            question.setAnalysis(tQuestion.getAnswer());
            //解题步骤分析
            question.setNote(tQuestion.getContent());
            //设置难度系数
            if(StringUtils.isNotEmpty(tQuestion.getDegree())){
                float  degree = Float.parseFloat(tQuestion.getDegree());
                question.setDifficulty(CalculateDegree.calculateDegree(degree));
            }else {
                question.setDifficulty(371);
            }
            //设置userId
            question.setUserId(9999);
            //知识点绑定类型
            question.setKnowType(0);
            //发布状态
            question.setState(1);
            //设置来源
            question.setSource(4);
            //设置来源ID
            question.setSourceId(tQuestion.getQuesId());
            //创建时间
            question.setCreateTime(new Date());
            //助手对应字段
            question.setQuesComment(tQuestion.getQuesComment());
            //设置试卷名称
            question.setPaperName(tQuestion.getPaperName());
            //设置试卷id
            question.setPaperId(tQuestion.getPaperId());
            question.setQuesType(tQuestion.getQuestypeId());
            //选择题设置题型
            if(StringUtils.isNotEmpty(tQuestion.getQuestypeId())){
                String quesType =tQuestion.getQuestypeId();
                if(quesType.equals("t0")||quesType.equals("t1")||quesType.equals("t4")){
                    if(tQuestion.getOptList()!=null&&tQuestion.getOptList().size()>0){
                        question.setOptionsNum(tQuestion.getOptList().size());
                        question.setOptionsBody(tQuestion.getQuesContent());
                        List<String>  optList = new ArrayList<>();
                        for(Option option:tQuestion.getOptList()){
                            optList.add(option.getOpt());
                        }
                        question.setOptions(JSONArray.toJSONString(optList));
                    }

                }
            }
            //设置学段学科
            question.setEduSubjectId(tQuestion.getSubjectId());
            question.setEduPeriodId(tQuestion.getPeriodId());
            if(tQuestion.getPointList()!=null&&tQuestion.getPointList().size()>0){
                question.setEduPoint(JSONArray.toJSONString(tQuestion.getPointList()));
            }
            question.setWordId(0);
            question.setTestType(0);
            question.setTestTypeName("未处理");
            question.setChildNum(0);
            question.setPackNum(0);
            question.setSubjectId("未处理");
            question.setAddTime((int)System.currentTimeMillis()/1000);
            question.setLastTime((int)System.currentTimeMillis()/1000);
            if(StringUtils.isEmpty(question.getAnalysis())||question.getAnalysis().length()<8000){
                questions.add(question);
            }
        }
        if(questions.size()>0){
            questionService.saveBatch(questions);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
