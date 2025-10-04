package ra.project.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.project.entity.Flight;
import ra.project.repository.IFlightRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepositoryImpl implements IFlightRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Flight> getFlights(String name, String starting, String destination, int page, int size) {
        Session ss = sessionFactory.openSession();
        StringBuilder hql = new StringBuilder("Select f from Flight f where 1=1 ");
        if (name != null && !name.trim().isEmpty()) {
            hql.append("and f.flightName like :name ");
        }
        if (starting != null && !starting.trim().isEmpty()) {
            hql.append("and f.starting_point like :starting ");
        }
        if (destination != null && !destination.trim().isEmpty()) {
            hql.append("and f.destination like :destination ");
        }
        TypedQuery<Flight> query = ss.createQuery(hql.toString(), Flight.class);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", "%" + name + "%");
        }
        if (starting != null && !starting.trim().isEmpty()) {
            query.setParameter("starting", starting);
        }
        if (destination != null && !destination.trim().isEmpty()) {
            query.setParameter("destination", destination);
        }
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        List<Flight> flights = query.getResultList();
        ss.close();
        return flights;
    }

    @Override
    public void saveFlight(Flight flight) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(flight);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
        }
    }
    @Override
    public void updateFlight(Flight flight) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(flight);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteFlight(int id) {
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        try {
            Flight flight = ss.get(Flight.class, id);
            ss.delete(flight);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            ss.close();
        }
    }

    @Override
    public Flight fingById(int id) {
        Session ss = sessionFactory.openSession();
        Flight flight = ss.get(Flight.class, id);
        ss.close();
        return flight;

    }

    @Override
    public Long countFlights() {
        Session session = sessionFactory.openSession();
        TypedQuery<Long> query = session.createQuery("select count(f.id) from Flight f", Long.class);
        return query.getSingleResult();
    }


}
