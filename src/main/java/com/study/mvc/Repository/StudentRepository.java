package com.study.mvc.Repository;

import java.util.List;

public interface StudentRepository {
    List<String> getStudentListAll();
    String findStudentNameByIndex(int index);
}
