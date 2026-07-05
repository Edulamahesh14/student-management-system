package com.vcube.studentmanagement01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.studentmanagement01.entity.Student;



public interface StudentRepository extends JpaRepository<Student, Integer> {

}