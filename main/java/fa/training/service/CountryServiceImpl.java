package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Country;
import fa.training.respostory.CountryRepository;
/**
 * Service implementation for managing Country entities.
 * 
 * This class provides methods to interact with the data layer for Country entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    /**
     * Retrieve a list of all countries ordered by their names in ascending order.
     * 
     * @return List of Country entities.
     * @since Aug 28, 2023
     */
    @Override
    public List<Country> findAll() {
        return countryRepository.findAllByOrderByCountryNameAsc();
    }

}
