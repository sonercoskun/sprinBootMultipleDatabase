package com.example.demo.controller;

import com.example.demo.Deneme;
import com.example.demo.domain.Student;
import com.example.demo.domain.Teacher;
import com.example.demo.repository.oracle.OracleRepository;
import com.example.demo.repository.postgres.PostgresRepository;
import com.example.demo.service.OracleService;
import com.example.demo.service.PostgresService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DenemeController {
    private OracleRepository oracleRepository;
    private PostgresRepository postgresRepository;

    private OracleService oracleService;
    private PostgresService postgresService;

    private final Deneme deneme;
    public DenemeController(Deneme deneme, OracleRepository oracleRepository,
                            PostgresRepository postgresRepository, OracleService oracleService,
                            PostgresService postgresService){
        this.deneme = deneme;
        this.oracleRepository = oracleRepository;
        this.postgresRepository = postgresRepository;
        this.oracleService = oracleService;
        this.postgresService = postgresService;
    }
    @GetMapping

    @Transactional
    public void get() {

        Student student = new Student();
        student.setId(1L);
        student.setFirst("soner");
        student.setLast("coskun");
        postgresRepository.save(student);

        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirst("soner");
        teacher.setLast("coskun");
        oracleRepository.save(teacher);

        oracleService.get();
        postgresService.get();
    }
}
