package kz.kaisar.sensor_reader_restapi.services;

import kz.kaisar.sensor_reader_restapi.dto.MeasurementDTO;
import kz.kaisar.sensor_reader_restapi.models.Measurement;
import kz.kaisar.sensor_reader_restapi.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

    public List<MeasurementDTO> findAll() {
        List<Measurement> measurements = measurementsRepository.findAll();

        List<MeasurementDTO> ml = new ArrayList<>();

        for (Measurement measurement : measurements) {
            MeasurementDTO m = new MeasurementDTO(measurement.getTemperature(), measurement.getIsRaining());
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

        measurementsRepository.save(measurement);
    }


}
