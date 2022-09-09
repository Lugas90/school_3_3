package ru.hogvarts.school_3_3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogvarts.school_3_3.model.Faculty;
import ru.hogvarts.school_3_3.repository.FacultyRepository;
import ru.hogvarts.school_3_3.service.FacultyService;

import java.util.Optional;

import static ru.hogvarts.school_3_3.FacultyConstants.*;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {

    Faculty f1 = new Faculty(1L, NAME1, COLOR1);
    Faculty f2 = new Faculty(2L, NAME2, COLOR2);
    Faculty f3 = new Faculty(3L, NAME3, COLOR3);
    @Mock
    private FacultyRepository facultyRepository;

    @InjectMocks
    private FacultyService facultyService;


    @Test
    public void shouldReturnAddFaculty() {
        Mockito.when(facultyRepository.save(f1)).thenReturn(f1);
        Assertions.assertThat(facultyService.addFaculty(f1)).isEqualTo(f1);
    }

    @Test
    public void shouldReturnGetFaculty() {
        Mockito.when(facultyRepository.findById(2L)).thenReturn(Optional.ofNullable(f2));
        Assertions.assertThat(facultyService.getFaculty(2L)).isEqualTo(f2);
    }
}
