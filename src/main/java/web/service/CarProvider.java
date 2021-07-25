package web.service;

import web.model.Car;

import java.util.List;

public interface CarProvider {
    public List<Car> getCars(int limit);
}
