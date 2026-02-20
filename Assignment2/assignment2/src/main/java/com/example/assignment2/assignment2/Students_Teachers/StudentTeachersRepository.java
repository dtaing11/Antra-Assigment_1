package com.example.assignment2.assignment2.Students_Teachers;

import com.example.assignment2.assignment2.Teachers.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentTeachersRepository extends JpaRepository<StudentTeachers, Long> {
    @NativeQuery(value = "SELECT t.* FROM teachers t " + "JOIN student_teacher st ON t.uuid = st.teacher_uuid " + "WHERE st.student_uuid = :studentUuid")
    List<Teacher> getTeacherByStudentUuid(@Param("studentUuid") String studentUuid);
}
