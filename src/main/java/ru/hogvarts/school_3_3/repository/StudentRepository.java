package ru.hogvarts.school_3_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogvarts.school_3_3.model.Student;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    public default Collection<Student> getStudentToAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : findAll()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}
