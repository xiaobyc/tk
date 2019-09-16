package com.tk.migrate.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin_knowledge")
public class AdminKnowledge {
    @TableId("knowledge_id")
    private Integer knowledgeId;
    private String tyKnowledgeId;
    private String knowledgeName;
}
