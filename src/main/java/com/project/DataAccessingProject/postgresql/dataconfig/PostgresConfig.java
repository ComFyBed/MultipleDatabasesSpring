package com.project.DataAccessingProject.postgresql.dataconfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager",
        basePackages = {"com.project.DataAccessingProject.postgresql.repository"}
)
public class PostgresConfig {
    @Value("${spring.postgres.datasource.url}")
    private String url;

    @Value("${spring.postgres.datasource.username}")
    private String username;

    @Value("${spring.postgres.datasource.password}")
    private String password;

    @Value("${spring.postgres.datasource.driver-class-name}")
    private String driver;

    @Primary
    @Bean(name = "postgresqlDatasource")
    public DataSource postgresqlDatasource(){
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driver)
                .build();
    }

    @Primary
    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("postgresqlDatasource") DataSource postgresqlDatasource
    ){
        return builder
                .dataSource(postgresqlDatasource)
                .packages("com.project.DataAccessingProject.postgresql.model")
                .build();
    }

    @Primary
    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionModel(
            @Qualifier("postgresEntityManagerFactory") LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory
            ){
        return new JpaTransactionManager(primaryEntityManagerFactory.getObject());
    }


}
