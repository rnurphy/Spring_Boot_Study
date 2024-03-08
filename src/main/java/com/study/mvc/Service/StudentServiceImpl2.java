package com.study.mvc.Service;

import com.study.mvc.Repository.StudentRepository;
import com.study.mvc.dto.StudentExDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl2 implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Override
    public List<?> getStudentList() {
        List<StudentExDto> studentDtoList = new ArrayList<>();
        List<String> studentList = studentRepository.getStudentListAll();

        for(String studentName : studentList) {
            studentDtoList.add(new StudentExDto(studentName));
        }

        return studentDtoList;
    }

    @Override
    public Object getStudent(int index) {
        String result = studentRepository.findStudentNameByIndex(index);

        return new StudentExDto(result);
    }
}
