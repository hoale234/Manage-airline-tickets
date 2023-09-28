package fa.training.service;

import java.util.List;

import fa.training.entities.Airline;
/**
 * Service implementation for managing Airline entities.
 * 
 * This class provides methods to interact with the data layer for Airline entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
public interface AirlineService {

    List<Airline> findAll();

}
