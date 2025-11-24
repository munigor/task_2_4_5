package web.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;
import web.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(Car car) {
        carRepository.add(car);
    }

    @Override
    public List<Car> getAll(int limit) {
        return carRepository.findAll(limit);
    }

    @PostConstruct
    private void initDB() {
        add(new Car("Hyundai", "PALISADE", 2025));
        add(new Car("Hyundai", "IONIQ5", 2025));
        add(new Car("Hyundai", "GRANDEUR", 2025));
        add(new Car("Hyundai", "SONATA", 2025));
        add(new Car("KIA", "K5", 2025));
    }
}
