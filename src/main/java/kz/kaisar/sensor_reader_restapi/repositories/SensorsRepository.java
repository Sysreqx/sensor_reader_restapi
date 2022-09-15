package kz.kaisar.sensor_reader_restapi.repositories;

import kz.kaisar.sensor_reader_restapi.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, Integer> {

    Sensor findByNameIgnoreCase(String name);
}
