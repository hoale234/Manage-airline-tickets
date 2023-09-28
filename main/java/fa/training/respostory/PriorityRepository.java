package fa.training.respostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Priority;
/**
 * Repository interface for managing Priority entities.
 * 
 * This interface extends JpaRepository and provides methods for interacting with the database for Priority entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
@Repository
public interface PriorityRepository extends JpaRepository<Priority, String> {
    /**
     * Retrieves a list of priorities sorted by priority name in ascending order.
     * 
     * @return A list of priorities sorted by name.
     */
    List<Priority> findAllByOrderByPriorityNameAsc();
}
