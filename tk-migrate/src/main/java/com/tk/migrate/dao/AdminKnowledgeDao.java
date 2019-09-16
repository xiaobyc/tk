package com.tk.migrate.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tk.migrate.model.AdminKnowledge;

public interface AdminKnowledgeDao extends BaseMapper<AdminKnowledge> {
    AdminKnowledge selectKnowledgeById(String pointId);
}
