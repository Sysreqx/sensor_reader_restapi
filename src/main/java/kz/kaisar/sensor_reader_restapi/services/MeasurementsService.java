package kz.kaisar.sensor_reader_restapi.services;

import kz.kaisar.sensor_reader_restapi.dto.MeasurementDTO;
import kz.kaisar.sensor_reader_restapi.models.Measurement;
import kz.kaisar.sensor_reader_restapi.models.Sensor;
import kz.kaisar.sensor_reader_restapi.repositories.MeasurementsRepository;
import kz.kaisar.sensor_reader_restapi.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;

    private final SensorsRepository sensorsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository,
                               SensorsRepository sensorsRepository) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsRepository = sensorsRepository;
    }

    public List<MeasurementDTO> findAll() {
        List<Measurement> measurements = measurementsRepository.findAll();

        List<MeasurementDTO> ml = new ArrayList<>();

        for (Measurement measurement : measurements) {
            MeasurementDTO m = new MeasurementDTO(
                    measurement.getTemperature(),
                    measurement.getIsRaining(),
                    measurement.getSensor()
            );
            ml.add(m);
        }

        return ml;
    }

    public Measurement findOne(int id) {
        Optional<Measurement> foundMeasurement = measurementsRepository.findById(id);
        return foundMeasurement.orElse(null);
    }

    @Transactional
    public void save(MeasurementDTO measurementDTO) {
        Measurement measurement = new Measurement();

        measurement.setCreatedAt(new Date());
        measurement.setTemperature(measurementDTO.getTemperature());
        measurement.setIsRaining(measurementDTO.getIsRaining());

        String sensorName = measurementDTO.getSensor().getName();
        Sensor sensor = sensorsRepository.findByNameIgnoreCase(sensorName);

        measurement.setSensor(sensor);

        measurementsRepository.save(measurement);
    }


    public Integer getRainyDaysCount() {

        int cnt = 0;

        List<Measurement> ml = measurementsRepository.findAll();

        for (Measurement measurement : ml) {
            if (measurement.getIsRaining())
                cnt++;
        }

        return cnt;
    }
}
