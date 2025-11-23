package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;
import web.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void add(Car car) {
        carRepository.add(car);
    }

    @Override
    public List<Car> getAll(int limit) {
        return carRepository.findAll(limit);
    }
}
