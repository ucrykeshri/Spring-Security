package com.practice.Ayush.repo;

import com.practice.Ayush.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    List<Student> getStudentBySchool(String school);

}
