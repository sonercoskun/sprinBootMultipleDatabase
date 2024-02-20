package com.example.demo.repository.oracle;

import com.example.demo.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleRepository extends JpaRepository<Teacher, Long> {
}
