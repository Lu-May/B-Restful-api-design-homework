package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    List<Student> studentList = new ArrayList<>();

    public Integer count() {
        return studentList.size() + 1;
    }

    public Student addStudent(Student student) {
        studentList.add(student);
        return student;
    }

    public void deleteStudent(int id) {
        studentList.remove(id - 1);
    }
}
