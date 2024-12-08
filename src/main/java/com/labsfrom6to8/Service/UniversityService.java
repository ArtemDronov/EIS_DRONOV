package com.labsfrom6to8.Service;

import com.labsfrom6to8.Mapper.UniversityMapper;
import com.labsfrom6to8.Model.University;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityMapper universityMapper;

    public UniversityService(UniversityMapper universityMapper) {
        this.universityMapper = universityMapper;
    }

    public void addUniversity(University university) {
        universityMapper.insertUniversity(university);
    }

    public void updateUniversity(University university) {
        universityMapper.updateUniversity(university);
    }

    public List<University> getAllUniversities() {
        return universityMapper.selectAllUniversities();
    }

    public void deleteUniversityById(Long id) {
        universityMapper.deleteUniversity(id);
    }
}
