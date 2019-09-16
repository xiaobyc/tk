package com.cms.migrate.controller;

import com.cms.migrate.model.ExamPoint;
import com.cms.migrate.service.ExamPointService;
import com.cms.migrate.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ExamPointController
 * @Description TODO
 * @Date 2019/9/9 11:25 AM
 * @Created by alex
 */
@RestController
public class ExamPointController {

    private static Logger logger = LoggerFactory.getLogger(ExamPointController.class);
    @Autowired
    private ExamPointService  examPointService;
    @RequestMapping(value = "/testExam")
    public String testExam(HttpServletResponse response){
//      List<ExamPoint> examPointList = examPointService.selectPointList();
//        if(examPointList!=null&&examPointList.size()>0){
//            return examPointList.get(0).getPointName();
//        }
        String subjectId="jcsub15";
        String periodId="pg";
        List<ExamPoint> examPointList = examPointService.selectExamPoint(subjectId,periodId);
        String title ="高中生物";
        List<String> list = new ArrayList<>();
        list.add("知识点ID");
        list.add("一级知识点");
        list.add("二级知识点");
        list.add("三级知识点");
        list.add("四级知识点");
        list.add("五级知识点");
        list.add("六级知识点");
        HSSFWorkbook workbook = ExcelUtils.getHSSFWorkBook(title,list,examPointList);
        OutputStream out=null;
        if(workbook!=null){
            try {
                String fileName = title+".xls";
                String headStr = "attachment; filename=\"" + fileName + "\"";
                response.setContentType("APPLICATION/OCTET-STREAM");
                response.setHeader("Content-Disposition", new String(headStr.getBytes("UTF-8"),"iso-8859-1"));
                response.setCharacterEncoding("utf-8");
                out = response.getOutputStream();
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        logger.error("用户试用下载关闭失败");
                    }
                }
            }
        }
        return "error";
    }



}
