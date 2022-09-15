package kz.kaisar.sensor_reader_restapi.services;

import kz.kaisar.sensor_reader_restapi.dto.SensorDTO;
import kz.kaisar.sensor_reader_restapi.models.Sensor;
import kz.kaisar.sensor_reader_restapi.repositories.SensorsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public Sensor findByName(String name) {
        return sensorsRepository.findByNameIgnoreCase(name);
    }

    @Transactional
    public void save(SensorDTO sensorDTO) {

        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.getName());

        sensorsRepository.save(sensor);
    }
}
