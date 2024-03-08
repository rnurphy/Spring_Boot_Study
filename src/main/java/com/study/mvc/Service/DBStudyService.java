package com.study.mvc.Service;

import com.study.mvc.Entity.Study;
import com.study.mvc.Repository.DBStudyRepository;
import com.study.mvc.dto.DBStudyReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBStudyService {

    @Autowired
    private DBStudyRepository dbStudyRepository;

    public int createStudy(DBStudyReqDto dbStudyReqDto) {
        Study study = Study.builder()
                .name(dbStudyReqDto.getName())
                .age(dbStudyReqDto.getAge())
                .build();

        return dbStudyRepository.save(study);
    }
}
