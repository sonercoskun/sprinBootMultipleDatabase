package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "table2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    private Long id;
    private String first;
    private String last;
}