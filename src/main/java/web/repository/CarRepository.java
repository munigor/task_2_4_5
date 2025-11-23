package web.repository;

import web.model.Car;

import java.util.List;

public interface CarRepository {
    void add(Car car);
    List<Car> findAll(int limit);
}
