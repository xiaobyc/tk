package com.tk.migrate.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("admin_point_relation")
public class AdminPointRelation {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String jxzsPointId;
    private String hxPointId;
    private Date createTime;
}
