package kz.kaisar.sensor_reader_restapi.controllers;

import kz.kaisar.sensor_reader_restapi.dto.MeasurementDTO;
import kz.kaisar.sensor_reader_restapi.dto.SensorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    @PostMapping("/registration")
    public ResponseEntity add(@RequestBody SensorDTO sensorDTO) {

        try {
//            measurementsService.save(measurementDTO);
            return ResponseEntity.ok("Measurement added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has ocured");
        }

    }
}
