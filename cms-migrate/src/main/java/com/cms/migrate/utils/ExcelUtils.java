package com.cms.migrate.utils;

import com.cms.migrate.model.ExamPoint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * @Classname ExcelUtils
 * @Description TODO
 * @Date 2019/9/9 5:21 PM
 * @Created by alex
 */
public class ExcelUtils {

    public static HSSFWorkbook getHSSFWorkBook(String bookName, List<String> titleList, List<ExamPoint> pointList){
            HSSFWorkbook  hssfWorkbook =  new HSSFWorkbook();
            HSSFSheet sheet  = hssfWorkbook.createSheet(bookName);
            HSSFRow  row = sheet.createRow(0);
            //声明列对象
            HSSFCell cell = null;
        //创建标题
        for (int i = 0; i < titleList.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(titleList.get(i));
        }

        for(int i=0;i<pointList.size();i++){
            row = sheet.createRow(i+1);
            ExamPoint examPoint = pointList.get(i);
            cell = row.createCell(0);
            cell.setCellValue(examPoint.getPointId());
            cell = row.createCell(examPoint.getLev());
            cell.setCellValue(examPoint.getPointName());
        }

        return hssfWorkbook;
    }



}
