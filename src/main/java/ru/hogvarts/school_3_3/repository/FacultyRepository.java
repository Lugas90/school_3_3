package ru.hogvarts.school_3_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogvarts.school_3_3.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Repository
public interface FacultyRepository extends JpaRepository <Faculty, Long> {

    Collection<Faculty> findFacultyByColor(String color);

    Collection<Faculty> findFacultyByColorIgnoreCaseOrNameIgnoreCase(String color, String name);
}
