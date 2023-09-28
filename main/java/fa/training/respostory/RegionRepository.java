package fa.training.respostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Region;
/**
 * Repository interface for managing Region entities.
 * 
 * This interface extends JpaRepository and provides methods for interacting with the database for Region entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, String> {
    /**
     * Retrieves a list of regions sorted by region name in ascending order.
     * 
     * @return A list of regions sorted by name.
     */
    List<Region> findAllByOrderByRegionNameAsc();
}
