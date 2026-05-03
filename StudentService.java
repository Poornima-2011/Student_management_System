package com.example.Studentmanagement.Service;

import com.example.Studentmanagement.Entity.Student;
import com.example.Studentmanagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }
    public Student updateStudent(int id, Student s) {
        Student existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(s.getName());
            existing.setEmail(s.getEmail());
            existing.setCourse(s.getCourse());
            return repo.save(existing);
        }

        throw new RuntimeException("Student not found");

    }
}