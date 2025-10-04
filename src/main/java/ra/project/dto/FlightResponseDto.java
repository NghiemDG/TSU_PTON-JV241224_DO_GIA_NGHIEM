package ra.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FlightResponseDto {
    private int id;
    private String flightName;
    private String starting_point;
    private String destination;
    private LocalDate departure_date;
    private int travel_time;
    private String time_unit;
    private String travel_image;
    private Integer status = 1;
}
