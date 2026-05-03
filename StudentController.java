package com.example.Studentmanagement.Controller;

import com.example.Studentmanagement.Entity.Student;
import com.example.Studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return service.saveStudent(s);
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteStudent(id);
        return "Deleted Successfully";
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student s) {
        return service.updateStudent(id, s);
    }
}