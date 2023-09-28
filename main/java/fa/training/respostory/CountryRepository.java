package fa.training.respostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Country;
/**
 * Repository interface for managing Country entities.
 * 
 * This interface extends JpaRepository and provides methods for interacting with the database for Country entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    /**
     * Retrieves a list of countries sorted by country name in ascending order.
     * 
     * @return A list of countries sorted by name.
     */
    List<Country> findAllByOrderByCountryNameAsc();
}
