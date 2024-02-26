package com.example.demo.controller;

import com.example.demo.Deneme;
import com.example.demo.domain.Student;
import com.example.demo.repository.postgres.PostgresRepository;
import com.example.demo.service.OracleService;
import com.example.demo.service.PostgresService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DenemeController {
    private PostgresRepository postgresRepository;

    private OracleService oracleService;
    private PostgresService postgresService;
    @Resource
    @Qualifier("jdbc1")
    private JdbcTemplate jdbcTemplate1;
    @Resource
    @Qualifier("jdbc2")
    private JdbcTemplate jdbcTemplate2;

    private final Deneme deneme;
    public DenemeController(Deneme deneme,
                            PostgresRepository postgresRepository, OracleService oracleService,
                            PostgresService postgresService,JdbcTemplate jdbcTemplate1,JdbcTemplate jdbcTemplate2){
        this.deneme = deneme;
        this.postgresRepository = postgresRepository;
        this.oracleService = oracleService;
        this.postgresService = postgresService;
        this.jdbcTemplate1 = jdbcTemplate1;
        this.jdbcTemplate2 = jdbcTemplate2;
    }
    @GetMapping

    @Transactional
    public void get() {

        Student student = new Student();
        student.setId(1L);
        student.setFirst("soner");
        student.setLast("coskun");
        postgresRepository.save(student);

        int a = jdbcTemplate1.update("insert into table1 (id) values (2)");
        System.out.println(a);
        int b = jdbcTemplate2.update("insert into table2 (id) values (2)");
        System.out.println(b);

        //oracleService.get();
        //postgresService.get();
    }
}
