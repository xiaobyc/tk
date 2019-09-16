package com.tk.migrate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.migrate.dao.AdminKnowledgeDao;
import com.tk.migrate.model.AdminKnowledge;
import com.tk.migrate.service.AdminKnowledgeService;
import org.springframework.stereotype.Service;

@Service
public class AdminKnowledgeServiceImpl extends ServiceImpl<AdminKnowledgeDao,AdminKnowledge> implements AdminKnowledgeService {
    @Override
    public AdminKnowledge selectKnowledgeById(String pointId) {
        return this.baseMapper.selectKnowledgeById(pointId);
    }
}
