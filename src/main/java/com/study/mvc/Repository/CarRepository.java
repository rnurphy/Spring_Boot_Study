package com.study.mvc.Repository;

import java.util.List;

public interface CarRepository {
    public List<String> getCarNames();
    public int insertCar(String carName);
}
