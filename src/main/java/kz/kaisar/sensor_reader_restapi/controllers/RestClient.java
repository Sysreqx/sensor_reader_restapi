package kz.kaisar.sensor_reader_restapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.kaisar.sensor_reader_restapi.models.Sensor;
import org.assertj.core.util.Maps;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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
    public static void main(String[] args) throws JsonProcessingException {
        callGetMeasurementsAPI();
        callSensorRegistrationAPI("Sensor from restClienteeesee");
    }

    public static void callGetMeasurementsAPI() {
        ResponseEntity<String> response = restTemplate.getForEntity(GET_MEASUREMENTS_API, String.class);
        System.out.println(response);
    }

    public static void callSensorRegistrationAPI(String sensorName) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> params = Maps.newHashMap("name", sensorName);
        String value = mapper.writeValueAsString(params);
        HttpEntity<String> requestEntity = new HttpEntity<String>(value, headers);
        restTemplate.postForEntity(SENSORS_REGISTRATION_API, requestEntity, String.class);
    }

}
