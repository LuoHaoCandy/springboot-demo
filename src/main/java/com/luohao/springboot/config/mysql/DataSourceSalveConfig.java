package com.luohao.springboot.config.mysql;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration //注册到springboot 容器中
@MapperScan(basePackages = "com.luohao.springboot.mysql.mapper.slave", sqlSessionTemplateRef = "salveSqlSessionTemplate")
public class DataSourceSalveConfig {

    @Bean(name = "salveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.salve")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "salveSqlSessionFactory")
    public SqlSessionFactory salveSqlSessionFactory(@Qualifier("salveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //加载其他文件，如mapper.xml
        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
        return bean.getObject();
    }

    //事务管理
    @Bean(name = "salveTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("salveDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "salveSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("salveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
