package com.study.mvc.controller;

import com.study.mvc.Service.DBStudyService;
import com.study.mvc.dto.DBStudyReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {

    @Autowired
    private DBStudyService dbStudyService;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody DBStudyReqDto dbStudyReqDto) {
        return ResponseEntity.ok(dbStudyService.createStudy(dbStudyReqDto));
    }


}
