package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class GroupRepository {
    List<Group> groupList = new ArrayList<>();
    private final StudentRepository studentRepository;

    public GroupRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        for (int i = 0; i < 6; i++) {
            Group group = new Group();
            group.setId(i + 1);
            group.setName("Group" + (i + 1));
            group.setStudentList(new ArrayList<>());
            groupList.add(group);
        }
    }

    public List<Group> getGroups() {
        List<Student> studentList = studentRepository.getAllStudents();
        Collections.shuffle(studentList);

        for (Group group : groupList) {
            group.clear();
        }

        int index = 0;
        for (Student student : studentList) {
            groupList.get(index).addStudent(student);
            index = (index + 1) % 6;
        }
        return groupList;
    }

    public Group updateGroupName(int id, String groupName) {
        groupList.get(id - 1).setName(groupName);
        return getGroupById(id);
    }

    private Group getGroupById(int id) {
        return groupList.get(id - 1);
    }
}
