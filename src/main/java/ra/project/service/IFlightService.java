package ra.project.service;

import org.springframework.stereotype.Service;
import ra.project.entity.Flight;

import java.util.List;

@Service
public interface IFlightService {
    List<Flight> getFlights(String name, String starting, String destination, int page, int size);
    void saveFlight(Flight flight);
    void delete(int id);
    Flight getFlightById(int id);
    void initData();
    int totalPages(int size);
    void updateFlight(Flight flight);
}
