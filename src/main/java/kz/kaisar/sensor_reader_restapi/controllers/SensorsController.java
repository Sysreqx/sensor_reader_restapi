package kz.kaisar.sensor_reader_restapi.controllers;

import kz.kaisar.sensor_reader_restapi.dto.SensorDTO;
import kz.kaisar.sensor_reader_restapi.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorsService sensorsService;

    @Autowired
    public SensorsController(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @PostMapping("/registration")
    public ResponseEntity add(@RequestBody SensorDTO sensorDTO) {

        try {
            sensorsService.save(sensorDTO);
            return ResponseEntity.ok("Measurement added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has ocured");
        }

    }
}
