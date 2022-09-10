package ru.hogvarts.school_3_3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogvarts.school_3_3.model.Student;
import ru.hogvarts.school_3_3.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity <Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}")
    public ResponseEntity <Student> editStudent(@RequestBody Student student, @PathVariable Long id) {
        Student editorialStudent = studentService.editStudent(id, student);
        if (editorialStudent == null) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editorialStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity <Collection<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping
    public ResponseEntity <Collection<Student>> findStudentsByAge(@RequestParam (required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findStudentsByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/ageMinMax")
    public ResponseEntity <Collection<Student>> findStudentsByAgeBetween (@RequestParam(required = false) int min,
                                                                          @RequestParam (required = false) int max) {
        if (min > 0) {
            return ResponseEntity.ok(studentService.findStudentsByAgeBetween(min, max));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

}
