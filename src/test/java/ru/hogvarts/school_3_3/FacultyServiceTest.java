package ru.hogvarts.school_3_3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.repository.cdi.Eager;
import ru.hogvarts.school_3_3.model.Faculty;
import ru.hogvarts.school_3_3.repository.FacultyRepository;
import ru.hogvarts.school_3_3.service.FacultyService;

import java.util.HashSet;
import java.util.Set;

import static ru.hogvarts.school_3_3.FacultyConstants.*;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {

    @Mock
    private FacultyService facultyService;

    @InjectMocks
    private FacultyRepository facultyRepository;


    @Test
    public void shouldReturnAddFaculty() {
        Faculty fac = new Faculty(1L, NAME1, COLOR1);
        Faculty actual = facultyService.addFaculty(fac);
        Faculty expected = new Faculty(1L, NAME1, COLOR1);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnGetFaculty() {
        Faculty fac = new Faculty(1L, NAME2, COLOR2);
        facultyService.addFaculty(fac);
        Faculty actual = facultyService.getFaculty(1L);
        Faculty expected = new Faculty(1L, NAME2, COLOR2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnEditFaculty() {
        Faculty fac = new Faculty(1L, NAME2, COLOR2);
        Faculty fac2 = new Faculty(2L, NAME3, COLOR3);
        facultyService.addFaculty(fac);
        Faculty actual = facultyService.editFaculty(2L, fac2);
        Faculty expected = new Faculty(2L, NAME3, COLOR3);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnDeleteFaculty() {
        Faculty fac = new Faculty(1L, NAME1, COLOR1);
        Faculty fac2 = new Faculty(2L, NAME2, COLOR2);
        facultyService.addFaculty(fac);
        facultyService.addFaculty(fac2);
        Set<Faculty> expected = new HashSet<>(Set.of(fac));
        facultyService.deleteFaculty(2L);
        Assertions.assertThat(facultyService.getAll()).isEqualTo(expected);
    }
}
