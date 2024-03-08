package com.study.mvc.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.Repository.CarRepository;
import com.study.mvc.Repository.CarRepositoryImpl2;
import com.study.mvc.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final String componentName = "a";

    @Autowired
    @Qualifier(componentName)
    private CarRepository carRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String getCarNames() {
        return String.join(", ", carRepository.getCarNames());
    }

    @Override
    public int addCar(String carName) {
        return 0;
    }
}
