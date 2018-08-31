package com.example.common;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by      Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date    :       2018/8/31
 * Time    :       21:48
 * Version :       1.0
 * Company :       realtour
 * MySessionExceptionBean
 */
//@Component
public class MySessionExceptionBean {

    private final DataSource dataSource;

//    @Autowired
    public MySessionExceptionBean(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SessionBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    class SessionBean extends SqlSessionFactoryBean {

        @Override
        public SqlSessionFactory buildSqlSessionFactory() throws IOException{
            try {
                return super.buildSqlSessionFactory();
            } catch (IOException e) {
                e.printStackTrace(); // XML 有错误时打印异常。
                throw new NestedIOException("Failed to parse mapping resource: ", e);
            } finally {
                ErrorContext.instance().reset();
            }
        }
    }
}
