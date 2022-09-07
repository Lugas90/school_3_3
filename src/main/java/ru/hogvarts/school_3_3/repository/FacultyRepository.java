package ru.hogvarts.school_3_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogvarts.school_3_3.model.Faculty;

public interface FacultyRepository extends JpaRepository <Faculty, Long> {
}
