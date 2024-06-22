package com.ssgnack.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssgnack", annotationClass = Mapper.class)
public class MybatisConfiguration {
}