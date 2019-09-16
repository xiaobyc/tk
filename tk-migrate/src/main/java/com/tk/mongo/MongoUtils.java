//package com.tk.mongo;
//
//import lombok.Data;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * mongo工具类，未实现的方法可以继续添加
// */
//@Component
//@Data
//public class MongoUtils {
//    private static final Logger LOGGER= LoggerFactory.getLogger(MongoUtils.class);
//    @Autowired
//    private MongoTemplate mongoTemplate;
//    /**
//     * 保存
//     * @param o
//     */
//    public <T> void save(T o){
//        try {
//            mongoTemplate.save(o);
//        }catch (Exception e){
//            LOGGER.error("mongo保存失败："+e.getMessage());
//        }
//    }
//
//    /**
//     * 根据id查询
//     * @param id
//     * @param objectClass
//     * @param <T>
//     * @return
//     */
//    public <T> T getById(String id,Class<T> objectClass){
//        try {
//            return mongoTemplate.findById(id,objectClass);
//        }catch (Exception e){
//            LOGGER.error("mongo查询失败:"+e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 根据条件查询列表
//     * @param query
//     * @param objectClass
//     * @param <T>
//     * @return
//     */
//    public <T> List<T> findList(Query query,Class<T> objectClass){
//        List<T> list=new ArrayList<>();
//        try {
//            list=mongoTemplate.find(query, objectClass);
//        }catch (Exception e){
//            LOGGER.error("mongo列表查询失败:"+e.getMessage());
//        }
//        return list;
//    }
//
//    /**
//     * 根据条件查询数量
//     * @param query
//     * @param objectClass
//     * @return
//     */
//    public long count(Query query,Class<?> objectClass){
//        try {
//            return mongoTemplate.count(query,objectClass);
//        }catch (Exception e){
//            LOGGER.error("mongo数量查询失败:"+e.getMessage());
//        }
//        return 0L;
//    }
//}