package com.example.demo.service;

import com.example.demo.config.Db2Config;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OracleService {
    private final JdbcTemplate oracleJdbcTemplate;
    private final Db2Config db2Config;

    public OracleService(JdbcTemplate oracleJdbcTemplate, Db2Config db2Config){
        this.oracleJdbcTemplate = oracleJdbcTemplate;
        this.db2Config = db2Config;
    }
    public void get(){
        oracleJdbcTemplate.setDataSource(db2Config.dataSource());
        int a = oracleJdbcTemplate.update("insert into table2 (id) values (2)");
        System.out.println("rows inserted oracle " + a);
    }
}
