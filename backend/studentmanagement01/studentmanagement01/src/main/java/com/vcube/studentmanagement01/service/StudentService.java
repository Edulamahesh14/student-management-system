package com.vcube.studentmanagement01.service;

import java.util.List;
import java.util.Optional;

import com.vcube.studentmanagement01.entity.Student;



public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Integer id);

    Student updateStudent(Integer id, Student student);

    void deleteStudent(Integer id);

}