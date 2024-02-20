package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "table1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "first")
    private String first;
    @Column(name = "last")
    private String last;
}