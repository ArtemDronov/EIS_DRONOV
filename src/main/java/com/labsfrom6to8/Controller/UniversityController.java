package com.labsfrom6to8.Controller;

import com.labsfrom6to8.Model.University;
import com.labsfrom6to8.Service.UniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping
    public void addUniversity(@RequestBody University university) {
        universityService.addUniversity(university);
    }

    @PutMapping
    public void updateUniversity(@RequestBody University university) {
        universityService.updateUniversity(university);
    }

    @GetMapping
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversityById(id);
    }
}
