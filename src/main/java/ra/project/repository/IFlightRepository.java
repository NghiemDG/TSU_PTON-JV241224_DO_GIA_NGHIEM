package ra.project.repository;

import org.springframework.stereotype.Repository;
import ra.project.entity.Flight;

import java.util.List;

@Repository
public interface IFlightRepository {
    List<Flight> getFlights(String name, String starting, String destination, int page, int size);
    void saveFlight(Flight flight);
    void deleteFlight(int id);
    Flight fingById(int id);
    Long countFlights();

}
