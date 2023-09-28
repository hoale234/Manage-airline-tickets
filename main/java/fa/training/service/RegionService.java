package fa.training.service;

import java.util.List;

import fa.training.entities.Region;
/**
 * Service implementation for managing Region entities.
 * 
 * This class provides methods to interact with the data layer for Region entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
public interface RegionService {
    List<Region> findAll();
}
