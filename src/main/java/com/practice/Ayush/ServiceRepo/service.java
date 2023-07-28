package com.practice.Ayush.ServiceRepo;


import com.practice.Ayush.model.Student;
import com.practice.Ayush.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {

    @Autowired
    private StudentRepo studentRepo;
    public Student addStudent(Student student)
    {
        return studentRepo.save(student);
    }
    public Optional<Student> getStudentById(int id)
    {
        return studentRepo.findById(id);
    }
    public List<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }
    public void deleteStudent(int id)
    {
        if(getStudentById(id)!=null)
        {
           Optional<Student> student = getStudentById(id);

        }
    }
    public void updateStudent(int id,Student updateStudent) throws Exception {
       Student student = studentRepo.findById(id).orElseThrow(()-> new Exception("Student Not found with id:"+id));
       student.setName(updateStudent.getName());
       student.setSchool(updateStudent.getSchool());
       return;
    }
    private List<Student> getStudentBySchool(String school)
    {
        List<Student> result = studentRepo.getStudentBySchool(school);
        return result;
    }

}
