package com.example.assignment2.assignment2.Students_Teachers;

import com.example.assignment2.assignment2.Helper.GenerateID;
import com.example.assignment2.assignment2.Students.Student;
import com.example.assignment2.assignment2.Students.StudentService;
import com.example.assignment2.assignment2.Teachers.Teacher;
import com.example.assignment2.assignment2.Teachers.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTeacherService {
    private final StudentTeachersRepository studentTeachersRepository;
    private final TeacherService teacherService;
    private final StudentService studentService;
    public StudentTeacherService(StudentTeachersRepository studentTeachersRepository, TeacherService teacherService, StudentService studentService) {
        this.studentTeachersRepository = studentTeachersRepository;
        this.teacherService = teacherService;
        this.studentService = studentService;

    }
    @Transactional
    public StudentTeachers create (Long studentUUid, Long teacherUUid) {
       if(teacherUUid == null || studentUUid == null) {
          throw new IllegalArgumentException("Teacher and student uuid cannot be empty");
       }
       if(teacherService.getTeacherById(teacherUUid) == null || studentService.getStudentByID(studentUUid) == null) {
           throw new IllegalArgumentException("Teacher or Student not found");
       }
        StudentTeachers studentTeachers = new StudentTeachers(
                GenerateID.generateLongID(),
                studentUUid,
                teacherUUid
        );
        return studentTeachersRepository.save(studentTeachers);
    }

    @Transactional
    public List<Teacher> getAllTeacherRelateToStudent(Long uuid) {
        if(studentService.getStudentByID(uuid) == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return studentTeachersRepository.getTeacherByStudentUuid(String.valueOf(uuid));
    }

}
