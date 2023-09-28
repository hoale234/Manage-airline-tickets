package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Region;
import fa.training.respostory.RegionRepository;
/**
 * Service implementation for managing Region entities.
 * 
 * This class provides methods to interact with the data layer for Region entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Service
public class RegionServiceIpm implements RegionService {
    @Autowired
    RegionRepository regionRepository;

    /**
     * Retrieve a list of all Region entities ordered by regionName.
     * 
     * @return A list of all Region entities.
     * @since Aug 28, 2023
     */
    @Override
    public List<Region> findAll() {
        return regionRepository.findAllByOrderByRegionNameAsc();
    }

}
