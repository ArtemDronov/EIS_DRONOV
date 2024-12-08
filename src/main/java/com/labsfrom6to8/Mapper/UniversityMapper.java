package com.labsfrom6to8.Mapper;

import com.labsfrom6to8.Model.University;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UniversityMapper {

    @Insert("INSERT INTO universities (name, location, student_count, is_public) VALUES (#{name}, #{location}, #{studentCount}, #{isPublic})")
    void insertUniversity(University university);

    @Update("UPDATE universities SET name = #{name}, location = #{location}, student_count = #{studentCount}, is_public = #{isPublic} WHERE id = #{id}")
    void updateUniversity(University university);

    @Select("SELECT * FROM universities")
    @Results({
            @Result(property = "studentCount", column = "student_count"),
            @Result(property = "isPublic", column = "is_public")
    })
    List<University> selectAllUniversities();

    @Delete("DELETE FROM universities WHERE id = #{id}")
    void deleteUniversity(Long id);
}