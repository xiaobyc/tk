//package com.cms.config;
//
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * mybatis-plus配置
// */
//@Configuration
//@MapperScan(basePackages={"com.cms.*.dao"})
//public class MybatisPlusConfig {
//
//    /**
//     * 分页插件
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor interceptor=new PaginationInterceptor();
//        //interceptor.setDialectType("oracle");
//        return interceptor;
//    }
//}
