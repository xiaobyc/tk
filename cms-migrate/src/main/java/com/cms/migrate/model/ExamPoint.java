package com.cms.migrate.model;

//import com.baomidou.mybatisplus.annotation.TableField;

//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;

//import com.baomidou.mybatisplus.annotation.TableField;

//import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname ExamPoint
 * @Description TODO
 * @Date 2019/9/9 11:17 AM
 * @Created by alex
 */
//@TableName("cmsuser.T_EXAMPOINT")
@Data
public class ExamPoint {
    //@TableId("POINT_ID")
    private String pointId;
    //@TableField("POINT_NAME")
    private String pointName;
    //@TableField("POINT_PID")
    private String pointPid;
    //@TableField("CMS_PERIOD_ID")
    private String periodId;
    //@TableField("CMS_SUBJECT_ID")
    private String subjectId;
    //@TableField("STATUS")
    private String status;
    private String isLeaf;
    private Integer lev;
}
