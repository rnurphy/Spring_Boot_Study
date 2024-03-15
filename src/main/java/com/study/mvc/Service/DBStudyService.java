package com.study.mvc.Service;

import com.study.mvc.Entity.Study;
import com.study.mvc.Repository.DBStudyRepository;
import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.dto.DBStudyRespDto;
import com.study.mvc.dto.DBStudySelectRespDto;
import com.study.mvc.exception.DuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBStudyService {

    @Autowired
    private DBStudyRepository dbStudyRepository;

    public DBStudyRespDto createStudy(DBStudyReqDto dbStudyReqDto) {
        Study findStudy = dbStudyRepository.findStudyByName(dbStudyReqDto.getName());

        if (findStudy != null) {
            return DBStudyRespDto.builder()
                    .successStatus(false)
                    .build();
        }

        Study study = Study.builder()
                .name(dbStudyReqDto.getName())
                .age(dbStudyReqDto.getAge())
                .build();

        int successCount = dbStudyRepository.save(study);

        return DBStudyRespDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .successStatus(successCount > 0)
                .successCount(successCount)
                .build();
    }

    public DBStudySelectRespDto findStudyById(int id) {
        Study study = dbStudyRepository.findStudyById(id);
        System.out.println(study);

        return DBStudySelectRespDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .build();
    }

    public DBStudySelectRespDto findStudyByName(String name) {
        Study study = dbStudyRepository.findStudyByName(name);

        return study == null ? null : study.toDto();
    }

    public List<DBStudySelectRespDto> findAll() {
        List<DBStudySelectRespDto> respDtoList = new ArrayList<>();
        List<Study> studyList = dbStudyRepository.findAll();

        for(Study study : studyList) {
            respDtoList.add(study.toDto());
        }

        return respDtoList;
    }

    // 스트림 사용법
    public List<DBStudySelectRespDto> findAll2() {
        return dbStudyRepository.findAll().stream().map(Study::toDto).collect(Collectors.toList());
    }

    public int deleteById(int id) {
        return dbStudyRepository.deleteById(id);
    }

    public int putById(int id, DBStudyReqDto dbStudyReqDto) {
        return dbStudyRepository.putById(dbStudyReqDto.toEntity(id));
    }

    public int patchById(int id, DBStudyReqDto dbStudyReqDto) {
        return dbStudyRepository.patchById(dbStudyReqDto.toEntity(id));
    }

    public void CheckDuplicatedByName(String name) {
        if(dbStudyRepository.findStudyByName(name) != null) {
            throw new DuplicatedException("이름 중복 오류");
        }
    }
}
