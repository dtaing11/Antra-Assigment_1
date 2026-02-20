
DROP TABLE IF EXISTS student_teacher;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS teachers;

CREATE TABLE students (
    uuid BIGINT PRIMARY KEY,
    name TEXT not null
);

CREATE TABLE teachers(
    uuid BIGINT PRIMARY KEY,
    name TEXT not null
); 

CREATE TABLE student_teacher (
    uuid BIGINT PRIMARY KEY,
    student_uuid BIGINT, 
    teacher_uuid BIGINT,

    CONSTRAINT FK_student FOREIGN KEY (student_uuid)
    REFERENCES students(uuid),
    CONSTRAINT FK_teacher FOREIGN KEY (teacher_uuid)
    REFERENCES teachers(uuid)

);