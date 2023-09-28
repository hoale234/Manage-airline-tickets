package fa.training.respostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.FareType;
/**
 * Repository interface for managing FareType entities.
 * 
 * This interface extends JpaRepository and provides methods for interacting with the database for FareType entities.
 * 
 * @Author leduyhoa
 * @since Aug 28, 2023
 * @version 1.0
 */
@Repository
public interface FareTypeRepository extends JpaRepository<FareType, String> {
    /**
     * Retrieves a list of fare types sorted by fare type name in ascending order.
     * 
     * @return A list of fare types sorted by name.
     */
    List<FareType> findAllByOrderByFareTypeNameAsc();
}
