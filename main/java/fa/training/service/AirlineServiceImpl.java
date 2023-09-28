package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Airline;
import fa.training.respostory.AirlineRepository;
/**
 * Service implementation for managing Airline entities.
 * 
 * This class provides methods to interact with the data layer for Airline entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
@Service
public class AirlineServiceImpl implements AirlineService{

    @Autowired
    AirlineRepository airlineRepository;

    /**
     * Retrieve a list of all airlines ordered by their names in ascending order.
     * 
     * @return List of Airline entities.
     * @since Aug 28, 2023
     */
    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAllByOrderByAirlineNameAsc();
    }
}
