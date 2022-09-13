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

import java.util.*;

import static ru.hogvarts.school_3_3.constantsStudent.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    Student s1 = new Student(1, NAME1, AGE1);
    Student s2 = new Student(2, NAME2, AGE2);
    Student s3 = new Student(3, NAME3, AGE3);
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    public void shouldReturnAddStudent() {
        Mockito.when(studentRepository.save(s1)).thenReturn(s1);
        Assertions.assertThat(studentService.addStudent(s1)).isEqualTo(s1);
    }

    @Test
    public void shouldReturnGetStudent() {
        Mockito.when(studentRepository.findById(2L)).thenReturn(Optional.ofNullable(s2));
        Assertions.assertThat(studentService.getStudent(2L)).isEqualTo(s2);
    }
}
