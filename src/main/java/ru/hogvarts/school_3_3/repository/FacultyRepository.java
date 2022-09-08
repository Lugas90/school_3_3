package ru.hogvarts.school_3_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogvarts.school_3_3.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Repository
public interface FacultyRepository extends JpaRepository <Faculty, Long> {

    public default Collection<Faculty> getFacultyToColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : findAll()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }
}
