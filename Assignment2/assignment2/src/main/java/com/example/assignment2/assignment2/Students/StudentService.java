package com.example.assignment2.assignment2.Students;

import com.example.assignment2.assignment2.Helper.GenerateID;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(String name ) {
        Student student = new Student(
                GenerateID.generateLongID(),
                name
        );
        return studentRepository.save(student);
    }
    public Student getStudentByID(long studentID) {
        return studentRepository.getReferenceById(studentID);
    }
}
