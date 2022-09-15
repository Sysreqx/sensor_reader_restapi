package kz.kaisar.sensor_reader_restapi.controllers;

import kz.kaisar.sensor_reader_restapi.dto.MeasurementDTO;
import kz.kaisar.sensor_reader_restapi.services.MeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }

    @GetMapping()
    public List<MeasurementDTO> getMeasurements() {
        return measurementsService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody MeasurementDTO measurementDTO) {

        try {
            measurementsService.save(measurementDTO);
            return ResponseEntity.ok("Measurement added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has ocured");
        }

    }



}
