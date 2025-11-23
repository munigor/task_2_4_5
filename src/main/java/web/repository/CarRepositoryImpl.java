package web.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Car;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(Car car) {
        entityManager.persist(car);
    }

    @Override
    @Transactional
    public List<Car> findAll(int limit) {
        return entityManager
            .createQuery("select c from Car c", Car.class)
            .setMaxResults(limit)
            .getResultList();
    }
}
