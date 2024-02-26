package com.example.demo.service;

import com.example.demo.config.Db1Config;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PostgresService {
    private final JdbcTemplate postgresJdbcTemplate;
    private final Db1Config db1Config;

    public PostgresService(JdbcTemplate postgresJdbcTemplate, Db1Config db1Config){
        this.postgresJdbcTemplate = postgresJdbcTemplate;
        this.db1Config = db1Config;
    }
    public void get(){
        postgresJdbcTemplate.setDataSource(db1Config.dataSource());
        int a = postgresJdbcTemplate.update("insert into table1 (id) values (2)");
        System.out.println("rows inserted postgres " + a);
    }
}
