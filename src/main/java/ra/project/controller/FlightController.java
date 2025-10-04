package ra.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.project.dto.FlightRequestDto;
import ra.project.dto.FlightResponseDto;
import ra.project.entity.Flight;
import ra.project.service.CloudService;
import ra.project.service.impl.FlightServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;
    @Autowired
    private CloudService cloudService;

    @GetMapping
    public String getFlights(Model model,
                             @RequestParam(value = "search", defaultValue = "") String search,
                             @RequestParam(value = "starting", defaultValue = "") String starting,
                             @RequestParam(value = "destination", defaultValue = "") String destination,
                             @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "5") int size) {
        model.addAttribute("search", search);
        model.addAttribute("starting", starting);
        model.addAttribute("destination", destination);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", flightService.totalPages(size));
        List<Flight> flights = flightService.getFlights(search, starting, destination, page, size);
        List<FlightResponseDto> flightsList = flights.stream().map(flight ->
        {
            FlightResponseDto flightResponseDto = new FlightResponseDto();
            flightResponseDto.setId(flight.getId());
            flightResponseDto.setFlightName(flight.getFlightName());
            flightResponseDto.setDestination(flight.getDestination());
            flightResponseDto.setStatus(flight.getStatus());
            flightResponseDto.setTime_unit(flight.getTime_unit());
            flightResponseDto.setStarting_point(flight.getStarting_point());
            flightResponseDto.setDeparture_date(flight.getDeparture_date());
            flightResponseDto.setTravel_time(flight.getTravel_time());
            flightResponseDto.setTravel_image(flight.getTravel_image());
            return flightResponseDto;
        }).collect(Collectors.toList());
        model.addAttribute("flightsList", flightsList);
        return "listFlights";
    }

    @GetMapping("/init")
    public String initData() {
        flightService.initData();
        return "redirect:/flights";
    }

    @GetMapping("/add")
    public String addFlight(Model model) {
        model.addAttribute("flight", new FlightRequestDto());
        return "addFlight";
    }

    @PostMapping("/add")
    String addFlight(@Valid @ModelAttribute("flight") FlightRequestDto requestDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addFlight";
        }
        Flight flight = new Flight();
        flight.setFlightName(requestDto.getFlightName());
        flight.setDestination(requestDto.getDestination());
        flight.setDeparture_date(requestDto.getDeparture_date());
        flight.setTime_unit(requestDto.getTime_unit());
        flight.setStarting_point(requestDto.getStarting_point());
        flight.setTravel_time(requestDto.getTravel_time());
        flight.setStatus(requestDto.getStatus());
        if (requestDto.getTravel_image() != null && !requestDto.getTravel_image().isEmpty()) {
            String url = cloudService.uploadFileToCloudinary(requestDto.getTravel_image());
            flight.setTravel_image(url);
        }
        flightService.saveFlight(flight);
        return "redirect:/flights";
    }

    @GetMapping("/edit/{id}")
    public String editFlight(@PathVariable("id") int id, Model model) {
        FlightRequestDto requestDto = new FlightRequestDto();
        Flight flight = flightService.getFlightById(id);
        requestDto.setId(id);
        requestDto.setFlightName(flight.getFlightName());
        requestDto.setDestination(flight.getDestination());
        requestDto.setDeparture_date(flight.getDeparture_date());
        requestDto.setTime_unit(flight.getTime_unit());
        requestDto.setStarting_point(flight.getStarting_point());
        requestDto.setTravel_time(flight.getTravel_time());
        requestDto.setStatus(flight.getStatus());
        model.addAttribute("flight", requestDto );
        return "editFlight";
    }

    @PostMapping("/edit/{id}")
    public String updateFlight(@ModelAttribute("flight") @Valid FlightRequestDto flightDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editFlight";
        }
        Flight flight = new Flight();
        flight.setFlightName(flightDto.getFlightName());
        flight.setDestination(flightDto.getDestination());
        flight.setDeparture_date(flightDto.getDeparture_date());
        flight.setTime_unit(flightDto.getTime_unit());
        flight.setStarting_point(flightDto.getStarting_point());
        flight.setTravel_time(flightDto.getTravel_time());
        flight.setStatus(flight.getStatus());
        if (flightDto.getTravel_image() != null && !flightDto.getTravel_image().isEmpty()) {
            String url = cloudService.uploadFileToCloudinary(flightDto.getTravel_image());
            flight.setTravel_image(url);
        }
        flightService.saveFlight(flight);
        return "redirect:/flights";

    }

}
