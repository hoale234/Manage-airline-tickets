package fa.training.service;

import java.util.List;

import fa.training.entities.FareType;
/**
 * Service implementation for managing FareType entities.
 * 
 * This class provides methods to interact with the data layer for FareType entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
public interface FareTypeService {
    List<FareType> findAll();
}
