package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "db1EntityMgrFactory",
        transactionManagerRef = "db1TransactionMgr",
        basePackages = "com.example.demo.repository.postgres")
@EnableTransactionManagement
public class Db1Config {

    @Bean(name = "datasource1")
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "db1EntityMgrFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean db1EntityMgrFactory(
            final EntityManagerFactoryBuilder builder,
            @Qualifier("datasource1") final DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.demo.domain")
                .persistenceUnit("db1")
                .build();
    }
    @Bean(name = "db1TransactionMgr")
    @Primary
    public PlatformTransactionManager db1TransactionMgr(
            @Qualifier("db1EntityMgrFactory") final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}