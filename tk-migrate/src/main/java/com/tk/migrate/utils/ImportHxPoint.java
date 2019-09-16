//package com.tk.migrate.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.tk.migrate.model.AdminKnowledge;
//import com.tk.migrate.model.AdminPointRelation;
//import com.tk.migrate.model.AdminQuestionKnow;
//import com.tk.migrate.service.AdminKnowledgeService;
//import com.tk.migrate.service.AdminPointRelationService;
//import com.tk.migrate.service.AdminQuestionKnowService;
//import javafx.scene.control.Cell;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AdminApplication.class)
//@Slf4j
//public class ImportHxPoint {
//    private static Logger logger= LoggerFactory.getLogger(ImportHxPoint.class);
//    @Autowired
//    private AdminPointRelationService adminPointRelationService;
//    @Autowired
//    private AdminQuestionService adminQuestionService;
//    @Autowired
//    private AdminKnowledgeService adminKnowledgeService;
//    @Autowired
//    private AdminQuestionKnowService adminQuestionKnowService;
//
//    //导入教学助手和慧学的知识点对应关系表
//    @Test
//    public void importPointRelation()throws Exception{
//        String excelPath="D:\\pointRelation\\高中语文（已关联20190910）.xls";
//        File excelFile=new File(excelPath);
//        ZipSecureFile.setMinInflateRatio(-1.0d);
//        Workbook workbook= WorkbookFactory.create(excelFile);
//        Sheet sheet=workbook.getSheetAt(0);
//        int rowCount=sheet.getPhysicalNumberOfRows();
//        for(int i=1;i<rowCount;i++){
//            Row row=sheet.getRow(i);
//            String jxzsId=getCellValue(row.getCell(0));
//            String hxId=getCellValue(row.getCell(8));
//            if(StringUtils.isNotEmpty(jxzsId) && StringUtils.isNotEmpty(hxId)){
//                AdminPointRelation adminPointRelation=new AdminPointRelation();
//                adminPointRelation.setJxzsPointId(jxzsId);
//                adminPointRelation.setHxPointId(hxId);
//                adminPointRelation.setCreateTime(new Date());
//                adminPointRelationService.save(adminPointRelation);
//
//            }
//        }
//    }
//    private String getCellValue(Cell cell){
//        if(cell==null){
//            return "";
//        }else{
//            switch (cell.getCellTypeEnum()){
//                case STRING: return cell.getStringCellValue();
//                case NUMERIC: return String.valueOf(cell.getNumericCellValue());
//                case BLANK: return cell.getStringCellValue();
//                default: return "";
//            }
//        }
//    }
//
//
//    //递归导入教学助手题目的知识点
//    @Test
//    public void importHxQuesPoint(){
//        //分页查询教学助手的题目
//        recurrenceList(1115,100);
//    }
//    public void recurrenceList(Integer currentPage,Integer pageSize){
//        IPage page = new Page();
//        page.setCurrent(currentPage);
//        page.setSize(pageSize);
//        IPage<AdminQuestion>   resultPage = null;
//        QueryWrapper<AdminQuestion> wrapper=new QueryWrapper<>();
//        wrapper.eq("user_id",9999);
//        resultPage=adminQuestionService.page(page,wrapper);
//        List<AdminQuestion> list=resultPage.getRecords();
//        toInsertPoint(list,currentPage);
//        //判断是否满足递归自己的条件
//        if(resultPage.getPages()>currentPage){
//            recurrenceList(currentPage+1,pageSize);
//        }
//    }
//    //处理教学助手题目数据中的知识点转化为3.0库知识点
//    public void toInsertPoint(List<AdminQuestion> list,Integer currentPage){
//        try{
//            List<AdminQuestionKnow> knowList=new ArrayList<>();
//            for (AdminQuestion question:list
//                 ) {
//              if(StringUtils.isNotEmpty(question.getEduPoint())){
//                  //将json字符串转为java对象
//                  List<PointVo> pointVoList= JSON.parseArray(question.getEduPoint(),PointVo.class);
//                  //获取到该题目的知识点对象之后根据教学助手与3.0库知识点对应关系表查出对应的慧学3.0知识点
//                  for (PointVo pointVo:pointVoList
//                       ) {
//                      AdminKnowledge adminKnowledge=adminKnowledgeService.selectKnowledgeById(pointVo.getPointId());
//                      if(adminKnowledge!=null&&StringUtils.isNotEmpty(adminKnowledge.getTyKnowledgeId())){
//                         AdminQuestionKnow adminQuestionKnow=new AdminQuestionKnow();
//                         adminQuestionKnow.setQuestionId(question.getTid());
//                         adminQuestionKnow.setSeat(0);
//                         adminQuestionKnow.setKnowId(adminKnowledge.getKnowledgeId());
//                         adminQuestionKnow.setTyKnowId(adminKnowledge.getTyKnowledgeId());
//                         adminQuestionKnow.setType(1);
//                         knowList.add(adminQuestionKnow);
//                      }
//                  }
//              }
//
//            }
//            if(!knowList.isEmpty()){
//                adminQuestionKnowService.saveBatch(knowList);
//            }
//            logger.info("导入教学助手题目对应的知识点第"+currentPage+"页成功");
//        }catch(Exception e){
//            logger.error("导入教学助手题目对应的知识点第"+currentPage+"页失败",e);
//        }
//    }
//}
