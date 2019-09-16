package com.tk.migrate.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.migrate.dao.AdminPointRelationDao;
import com.tk.migrate.model.AdminPointRelation;
import com.tk.migrate.service.AdminPointRelationService;
import org.springframework.stereotype.Service;

@Service
public class AdminPointRelationServiceImpl extends ServiceImpl<AdminPointRelationDao,AdminPointRelation> implements AdminPointRelationService {
}
