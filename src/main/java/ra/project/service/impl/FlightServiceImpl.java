package ra.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.project.entity.Flight;
import ra.project.repository.impl.FlightRepositoryImpl;
import ra.project.service.IFlightService;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {
    @Autowired
    private FlightRepositoryImpl flightRepo;

    @Override
    public List<Flight> getFlights(String name, String starting, String destination, int page, int size) {
        return flightRepo.getFlights(name, starting, destination, page, size);
    }

    @Override
    public void saveFlight(Flight flight) {
        flightRepo.saveFlight(flight);
    }

    @Override
    public void delete(int id) {
        flightRepo.deleteFlight(id);
    }

    @Override
    public Flight getFlightById(int id) {
        return flightRepo.fingById(id);
    }

    @Override
    public void initData() {
        flightRepo.saveFlight(new Flight("A001","Hà Nội","HCM", LocalDate.of(2025,10,1),2,"Giờ","",1));
        flightRepo.saveFlight(new Flight("B0012","Cao Bằng","Đồng Nai", LocalDate.of(2025,11,3),4,"Giờ","",1));
        flightRepo.saveFlight(new Flight("C0013","Hà Nội","Nha Trang", LocalDate.of(2025,12,5),2,"Giờ","",1));
        flightRepo.saveFlight(new Flight("D001","Hà Nội","Đà Nẵng", LocalDate.of(2025,10,14),6,"Giờ","",1));
        flightRepo.saveFlight(new Flight("E001","HCM","Hà Nội", LocalDate.of(2025,1,3),2,"Giờ","",1));
        flightRepo.saveFlight(new Flight("F001","Hà Nội","Phú Quốc", LocalDate.of(2025,3,5),2,"Giờ","",1));
        flightRepo.saveFlight(new Flight("G001","Hà Nội","Seoul", LocalDate.of(2025,5,2),7,"Giờ","",1));
        flightRepo.saveFlight(new Flight("H001","Đà Nẵng","New York", LocalDate.of(2025,6,6),8,"Giờ","",1));
        flightRepo.saveFlight(new Flight("I001","HCM","Đà Nẵng", LocalDate.of(2025,11,20),3,"Giờ","",1));
        flightRepo.saveFlight(new Flight("J001","HCM","Tokyo", LocalDate.of(2025,10,21),4,"Giờ","",1));
        flightRepo.saveFlight(new Flight("K001","Đà Nẵng","Thiên Trúc", LocalDate.of(2025,3,13),2,"Giờ","",1));
    }

    @Override
    public int totalPages(int size) {
        size = 5;
        return (int) Math.ceil((double) flightRepo.countFlights() /size);
    }


}
