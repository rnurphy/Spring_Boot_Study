package com.study.mvc.Service;

import com.study.mvc.Repository.CarRepository;

import java.util.List;

public interface CarService {
    public String getCarNames();
    public int addCar(String carName);
}
