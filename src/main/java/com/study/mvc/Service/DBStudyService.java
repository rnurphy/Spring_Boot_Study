package com.study.mvc.Service;

import com.study.mvc.Entity.Study;
import com.study.mvc.Repository.DBStudyRepository;
import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.dto.DBStudyRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBStudyService {

    @Autowired
    private DBStudyRepository dbStudyRepository;

    public DBStudyRespDto createStudy(DBStudyReqDto dbStudyReqDto) {

        Study study = Study.builder()
                .name(dbStudyReqDto.getName())
                .age(dbStudyReqDto.getAge())
                .build();

        int successCount = dbStudyRepository.save(study);

        DBStudyRespDto dbStudyRespDto = DBStudyRespDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .successStatus(successCount > 0)
                .successCount(successCount)
                .build();

        return dbStudyRespDto;
    }
}
