package web.service;

import web.model.Car;

import java.util.List;

public interface CarsProviderInterface {
    public List<Car> getCars(int limit);
}
