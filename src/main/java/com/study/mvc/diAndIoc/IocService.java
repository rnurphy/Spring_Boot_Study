package com.study.mvc.diAndIoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

//@RequiredArgsConstructor
@Component
public class IocService {

    @Autowired
    private IocRepository iocRepository;

    public String getJson() throws JsonProcessingException {
        Map<String, String> nameMap = iocRepository.convertNameMap();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString((nameMap));
    }
}
