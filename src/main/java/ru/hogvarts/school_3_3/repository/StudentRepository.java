package ru.hogvarts.school_3_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogvarts.school_3_3.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
