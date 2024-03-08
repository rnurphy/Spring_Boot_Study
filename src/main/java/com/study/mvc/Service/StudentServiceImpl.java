package com.study.mvc.Service;

import com.study.mvc.Entity.Student;
import com.study.mvc.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public List<?> getStudentList() {
        List<Map<String, String>> studentMapList = new ArrayList<>();
        List<String> studentList = studentRepository.getStudentListAll();

        for(String studentName : studentList) {
            studentMapList.add(Map.of("name", studentName));
        }

        return studentMapList;
    }

    @Override
    public Object getStudent(int index) {
        return Map.of("name", studentRepository.findStudentNameByIndex(index));
    }
}
