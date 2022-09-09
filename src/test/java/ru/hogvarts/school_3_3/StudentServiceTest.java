package ru.hogvarts.school_3_3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogvarts.school_3_3.model.Student;
import ru.hogvarts.school_3_3.repository.StudentRepository;
import ru.hogvarts.school_3_3.service.StudentService;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.hogvarts.school_3_3.constantsStudent.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    Student s1 = new Student(1, NAME1, AGE1);
    Student s2 = new Student(2, NAME2, AGE2);
    Student s3 = new Student(3, NAME3, AGE3);
    private List <Student> students = new ArrayList<>();
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    public void shouldReturnAddStudent() {
        Mockito.when(studentService.getAll()).thenReturn(students);
        Student expected = new Student (1, NAME1, AGE1);
        studentService.addStudent(s1);
        Assertions.assertThat(studentRepository.findById(1L)).isEqualTo(expected);

//        Student st = new Student(1L, NAME1, AGE1);
//        Student actual = studentService.addStudent(st);
//        Student expected = new Student(1L, NAME1, AGE1);
//        Assertions.assertThat(actual).isEqualTo(expected);
    }

//    @Test
//    public void shouldReturnGetStudent() {
//        Student st = new Student(1L, NAME2, AGE2);
//        studentService.addStudent(st);
//        Student actual = studentService.getStudent(1L);
//        Student expected = new Student(1L, NAME2, AGE2);
//        Assertions.assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    public void shouldReturnEditStudent() {
//        Student st = new Student(1L, NAME2, AGE2);
//        Student st2 = new Student(2L, NAME3, AGE3);
//        studentService.addStudent(st);
//        Student actual = studentService.editStudent(2L, st2);
//        Student expected = new Student(2L, NAME3, AGE3);
//        Assertions.assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    public void shouldReturnDeleteStudent() {
//        Student st = new Student(1L, NAME1, AGE1);
//        Student st2 = new Student(2L, NAME2, AGE2);
//        studentService.addStudent(st);
//        studentService.addStudent(st2);
//        Set<Student> expected = new HashSet<>(Set.of(st));
//        studentService.deleteStudent(2L);
//        Assertions.assertThat(studentService.getAll()).isEqualTo(expected);
//    }
}
