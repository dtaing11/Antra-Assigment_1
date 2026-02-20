package com.example.assignment2.assignment2.Students_Teachers;

import com.example.assignment2.assignment2.Teachers.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/studentteacher")
public class StudentTeacherController {
    @Autowired
    private StudentTeacherService studentTeacherService;
    public StudentTeacherController(StudentTeacherService studentTeacherService) {
        this.studentTeacherService = studentTeacherService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateStudentTeacherRequest createStudentTeacherRequest) {
        studentTeacherService.create(
                createStudentTeacherRequest.studentID(),
                createStudentTeacherRequest.teacherID()
        );
        return ResponseEntity.ok().build();

    }
    @GetMapping("/findAllTeacherRelatedToStudent")
    public ResponseEntity<?> findAllTeacherRelatedToStudent(@RequestParam(required = true) Long studentUUID) {
        List<Teacher> listTeacher = studentTeacherService.getAllTeacherRelateToStudent(studentUUID);
        return ResponseEntity.ok().body(listTeacher);
    }

}

