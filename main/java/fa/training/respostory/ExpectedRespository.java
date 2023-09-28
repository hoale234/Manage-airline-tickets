package fa.training.respostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Expected;
/**
 * Repository interface for managing Expected entities.
 * 
 * This interface extends JpaRepository and provides methods for interacting with the database for Expected entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
@Repository
public interface ExpectedRespository extends JpaRepository<Expected, String> {
    /**
     * Retrieves an Expected entity by its ID.
     * 
     * @param idExpected The ID of the expected entity.
     * @return The Expected entity with the specified ID, or null if not found.
     */
    Expected findByIdExpected(String idExpected);
}
