package com.study.mvc.Repository;

import com.study.mvc.Entity.Study;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DBStudyRepository {
    public int save(Study study);
}
