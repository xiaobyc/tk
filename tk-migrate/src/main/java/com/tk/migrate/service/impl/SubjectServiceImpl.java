package com.tk.migrate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.migrate.dao.SubjectDao;
import com.tk.migrate.model.Subject;
import com.tk.migrate.service.SubjectService;
import org.springframework.stereotype.Service;

/**
 * @Classname SubjectServiceImpl
 * @Description TODO
 * @Date 2019/9/10 4:12 PM
 * @Created by alex
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectDao,Subject> implements SubjectService{

}
