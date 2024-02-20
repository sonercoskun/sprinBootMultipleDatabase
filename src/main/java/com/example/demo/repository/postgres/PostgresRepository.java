package com.example.demo.repository.postgres;

import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRepository extends JpaRepository<Student, Long> {
}
