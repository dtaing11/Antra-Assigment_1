package com.example.assignment2.assignment2.Teachers;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.assignment2.assignment2.Helper.GenerateID;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    public Teacher create (String name){
        Teacher teacher = new Teacher(GenerateID.generateLongID(), name);
        return teacherRepository.save(
            teacher
        );
    }
    public Teacher getTeacherById(Long uuid){
        return teacherRepository.getReferenceById(
                uuid
        );
    }
}
