package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarProviderImpl implements CarProvider {
    private final List<Car> carsList = new ArrayList<>();

    public CarProviderImpl() {
        carsList.add(new Car("Mazda 6", "black", 2007));
        carsList.add(new Car("Honda civic", "white", 2017));
        carsList.add(new Car("Infinity QX70", "black", 2015));
        carsList.add(new Car("VolksWagen Passat CC", "white", 2014));
        carsList.add(new Car("Skoda Superb", "black", 2015));
    }

    @Override
    public List<Car> getCars(int limit) {
        return carsList.stream().limit(limit).collect(Collectors.toList());
    }
}
