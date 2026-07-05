package com.vcube.studentmanagement01.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vcube.studentmanagement01.entity.Student;
import com.vcube.studentmanagement01.repository.StudentRepository;
import com.vcube.studentmanagement01.service.StudentService;

@Service
public  class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {

        Student existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));

        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setGender(student.getGender());
        existing.setDateOfBirth(student.getDateOfBirth());
        existing.setCourse(student.getCourse());
        existing.setAddress(student.getAddress());

        return repository.save(existing);
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }


}