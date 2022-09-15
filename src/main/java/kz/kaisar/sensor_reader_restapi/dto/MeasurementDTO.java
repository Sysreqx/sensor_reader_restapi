package kz.kaisar.sensor_reader_restapi.dto;

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

    public MeasurementDTO() {
    }

    public MeasurementDTO(int temperature, boolean isRaining) {
        this.temperature = temperature;
        this.isRaining = isRaining;
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
        isRaining = raining;
    }
}
