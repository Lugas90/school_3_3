package ru.hogvarts.school_3_3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogvarts.school_3_3.model.Faculty;
import ru.hogvarts.school_3_3.service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity <Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.getFaculty(id);
        if (faculty == null) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping
    public ResponseEntity <Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty editorialFaculty = facultyService.editFaculty(faculty);
        if (editorialFaculty == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editorialFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <Collection<Faculty>> findFacultyByColor(@RequestParam(required = false) String color) {
        if (color != null && !color.isBlank()){
            return ResponseEntity.ok(facultyService.getFacultyToColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
}
