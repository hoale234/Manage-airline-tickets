package fa.training.respostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Airline;
/**
 * Repository interface for managing Airline entities.
 * 
 * This interface extends JpaRepository and provides methods for interacting with the database for Airline entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
@Repository
public interface AirlineRepository extends JpaRepository<Airline, String> {
    /**
     * Retrieves a list of airlines sorted by airline name in ascending order.
     * 
     * @return A list of airlines sorted by name.
     */
    List<Airline> findAllByOrderByAirlineNameAsc();
}
