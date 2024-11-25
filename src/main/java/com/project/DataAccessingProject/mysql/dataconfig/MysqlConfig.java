package com.project.DataAccessingProject.mysql.dataconfig;



import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.project.DataAccessingProject.mysql.repository",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlConfig {
    @Value("${spring.mysql.datasource.username}")
    private String username;

    @Value("${spring.mysql.datasource.password}")
    private String password;

    @Value("${spring.mysql.datasource.url}")
    private String url;


    @Bean(name = "mysqlDatasource")
    public DataSource mysqlDatasource(){
        return DataSourceBuilder.create()
                .url(url)
                .password(password)
                .username(username)
                .build();
    }

    @Bean(name= "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mysqlDatasource") DataSource mysqlDatasource
    ){
        return builder
                .dataSource(mysqlDatasource)
                .packages("com.project.DataAccessingProject.mysql.model")
                .build();
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory
    ){
        return new JpaTransactionManager(mysqlEntityManagerFactory.getObject());
    }

}
