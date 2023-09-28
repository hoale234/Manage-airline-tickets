package fa.training.service;

import java.util.List;

import fa.training.entities.Priority;
/**
 * Service implementation for managing Priority entities.
 * 
 * This class provides methods to interact with the data layer for Priority entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
public interface PriorityService {
    List<Priority> findAll();
}
