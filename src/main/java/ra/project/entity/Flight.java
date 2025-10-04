package ra.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "flight_list")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(nullable = false)
    private String flightName;
    @Column(nullable = false)
    private String starting_point;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departure_date;
    @Column(nullable = false)
    private int travel_time;
    @Column(nullable = false)
    private String time_unit;
    @Column(nullable = false)
    private String travel_image;
    @Column(columnDefinition = "TINYINT")
    private Integer status =1;

    public Flight( String flightName, String starting_point, String destination, LocalDate departure_date, int travel_time, String time_unit, String travel_image, Integer status) {

        this.flightName = flightName;
        this.starting_point = starting_point;
        this.destination = destination;
        this.departure_date = departure_date;
        this.travel_time = travel_time;
        this.time_unit = time_unit;
        this.travel_image = travel_image;
        this.status = status;
    }
}
