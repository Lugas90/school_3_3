package ru.hogvarts.school_3_3.service;

import org.springframework.stereotype.Service;
import ru.hogvarts.school.model.Student;
import ru.hogvarts.school_3_3.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Long id, Student student) {
        return studentRepository.save(student);
        }

    public void deleteStudent(Long id) {
        return studentRepository.deleteAllById(id);
    }

    public Collection<Student> getStudentToAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }
}
