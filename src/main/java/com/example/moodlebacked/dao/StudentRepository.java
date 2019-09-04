package com.example.moodlebacked.dao;

import com.example.moodlebacked.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByXuehao(String xuehao);

}
