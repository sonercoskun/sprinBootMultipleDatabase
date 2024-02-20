package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "db2EntityMgrFactory", transactionManagerRef = "db2TransactionMgr",
        basePackages = "com.example.demo.repository.oracle")
@EnableTransactionManagement
public class Db2Config {
    @Bean(name = "datasource2")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "db2EntityMgrFactory")
    public LocalContainerEntityManagerFactoryBean db2EntityMgrFactory (
            final EntityManagerFactoryBuilder builder,
            @Qualifier("datasource2") final DataSource dataSource) {
        final Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.physical_naming_strategy",
                "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("com.example.demo.domain")
                .persistenceUnit("db2")
                .build();
    }
    @Bean(name = "db2TransactionMgr")
    public PlatformTransactionManager db2TransactionMgr(@Qualifier("db2EntityMgrFactory") final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
