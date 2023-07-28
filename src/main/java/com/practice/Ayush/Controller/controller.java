package com.practice.Ayush.Controller;

import com.practice.Ayush.ServiceRepo.service;
import com.practice.Ayush.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value ="api/students")
public class controller {

    @Autowired
    private service service1;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student)
    {
      return service1.addStudent(student);
    }
    @PatchMapping
    @PutMapping("/getStudent/{id}")
    public Optional<Student> getStudentById(@PathVariable int id)
    {
        return service1.getStudentById(id);
    }
    @GetMapping("/All")
    public List<Student> getAllStudents() throws Exception
    {
        return service1.getAllStudents();
    }
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudentById(@PathVariable int id)
    {
        service1.deleteStudent(id);
        System.out.println("Deletion Successful");
    }
    @PatchMapping("/updateStudent/{id}")
    public void updateStudentById(@PathVariable int id,@RequestBody Student newStudent) throws Exception {
    service1.updateStudent(id,newStudent);
    System.out.println("Updation Successful");
    }

    @GetMapping("/admin")
    public String getadmin()
    {
        return ("<h1>Welcome admin</h1>");
    }


}
