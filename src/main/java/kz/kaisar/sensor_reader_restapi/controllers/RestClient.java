package kz.kaisar.sensor_reader_restapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

    /*{
        "temperature": 22,
            "isRaining": false,
            "sensor": {
        "name": "Sensor #1"
    }*/
    private static final String MEASUREMENTS_ADD_API = "http://localhost:8080/measurements/add";

    /*{
        "name": "Sensor test"
    }*/
    private static final String SENSORS_REGISTRATION_API = "http://localhost:8080/sensors/registration";

    private static final String GET_MEASUREMENTS_API = "http://localhost:8080/measurements";

    static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        callGetMeasurementsAPI();
    }

    public static void callGetMeasurementsAPI() {
        ResponseEntity<String> response = restTemplate.getForEntity(GET_MEASUREMENTS_API, String.class);
        System.out.println(response);
    }


}
