package fa.training.service;

import java.util.List;

import fa.training.entities.Country;
/**
 * Service implementation for managing Country entities.
 * 
 * This class provides methods to interact with the data layer for Country entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
public interface CountryService {
    List<Country> findAll();
}
