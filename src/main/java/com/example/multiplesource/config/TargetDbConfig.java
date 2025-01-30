package com.example.multiplesource.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
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

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.multiplesource.repository.target",
        entityManagerFactoryRef = "targetEntityManagerFactory",
        transactionManagerRef = "targetTransactionManager"
)
@Slf4j
public class TargetDbConfig {

    @Bean(name = "targetDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.target")
    public DataSource dataSource() {
        log.info("✅ Connected to Target Database at {}", "jdbc:mysql://localhost:3303/db_target");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "targetEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("targetDataSource") DataSource dataSource) {
        log.info("🔄 Initializing Target EntityManagerFactory...");
        return builder
                .dataSource(dataSource)
                .packages("com.example.multiplesource.model.target")
                .persistenceUnit("target")
                .build();
    }

    @Bean(name = "targetTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("targetEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        log.info("🔄 Initializing Target Transaction Manager...");
        return new JpaTransactionManager(entityManagerFactory);
    }
}
