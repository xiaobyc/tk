package com.tk.migrate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tk.migrate.model.AdminKnowledge;

public interface AdminKnowledgeService extends IService<AdminKnowledge> {
    AdminKnowledge selectKnowledgeById(String pointId);
}
