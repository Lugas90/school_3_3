package ru.hogvarts.school_3_3.service;

import org.springframework.stereotype.Service;
import ru.hogvarts.school_3_3.model.Student;
import ru.hogvarts.school_3_3.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(Long id, Student student) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Student fromDB = optional.get();
            fromDB.setName(fromDB.getName());
            fromDB.setAge(fromDB.getAge());
            return studentRepository.save(fromDB);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findStudentsByAge(int age) {
        return studentRepository.findStudentsByAge(age);
    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> findStudentsByAgeBetween(int min, int max) {
        return studentRepository.findStudentsByAgeBetween(min, max);
    }
}
