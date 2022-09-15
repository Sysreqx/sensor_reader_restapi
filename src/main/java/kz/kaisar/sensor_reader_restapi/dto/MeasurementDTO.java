package kz.kaisar.sensor_reader_restapi.dto;

import kz.kaisar.sensor_reader_restapi.models.Sensor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MeasurementDTO {
    @NotEmpty(message = "Temperature shouldn't be empty")
    @Size(min = -100, max = 100, message = "Temperature should be between -100 and 100")
    private int temperature;

    @NotEmpty(message = "Temperature shouldn't be true or false")
    @Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private boolean isRaining;

    @NotEmpty(message = "Sensor should have a name")
    private Sensor sensor;

    public MeasurementDTO() {
    }

    public MeasurementDTO(int temperature, boolean isRaining, Sensor sensor) {
        this.temperature = temperature;
        this.isRaining = isRaining;
        this.sensor = sensor;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean getIsRaining() {
        return isRaining;
    }

    public void setIsRaining(boolean raining) {
        this.isRaining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
