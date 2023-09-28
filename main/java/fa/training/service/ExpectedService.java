package fa.training.service;

import fa.training.entities.Expected;
/**
 * Service interface for managing Expected entities.
 * 
 * This interface defines methods to interact with the data layer for Expected entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
public interface ExpectedService {
    Expected findDate(String idExpected);
}
