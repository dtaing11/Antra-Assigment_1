package com.example.assignment2.assignment2.Students_Teachers;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="student_teacher")
@AllArgsConstructor
@Getter
@Setter
public class StudentTeachers {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "uuid", nullable = false)
    private long uuid;
    @Column(name= "student_uuid", nullable = false)
    private long studentUUID;
    @Column(name= "teacher_uuid", nullable = false)
    private long teacherUUID;
    
}
