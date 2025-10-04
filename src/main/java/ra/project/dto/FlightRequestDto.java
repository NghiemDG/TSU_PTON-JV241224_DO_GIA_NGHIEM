package ra.project.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class FlightRequestDto {
    private int id;
    @NotBlank(message = "Tên chuyến bay không được để trống")
    private String flightName;
    @NotBlank(message = "Điểm xuất phát không được để trống")
    private String starting_point;
    @NotBlank(message = "Điểm đến không được để trống")

    private String destination;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Ngày bay không được để trống")

    private LocalDate departure_date;
    @NotNull(message = "Thời giạn bay không được để trống")

    private int travel_time;
    @NotBlank(message = "Đơn vị thời gian không được để trống")

    private String time_unit;
    @NotNull(message = "Ảnh tuyến bay không được để trống")

    private MultipartFile travel_image;


    private Integer status;
}
