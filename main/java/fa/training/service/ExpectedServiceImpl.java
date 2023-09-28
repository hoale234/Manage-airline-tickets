package fa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Expected;
import fa.training.respostory.ExpectedRespository;
/**
 * Service implementation for managing Expected entities.
 * 
 * This class provides methods to interact with the data layer for Expected entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Service
public class ExpectedServiceImpl implements ExpectedService {

    @Autowired
    ExpectedRespository expectedRespository;
    
    /**
     * Find an Expected entity by its idExpected.
     * 
     * @param idExpected The id of the Expected entity to be retrieved.
     * @return The Expected entity with the specified idExpected.
     * @since Aug 28, 2023
     */
    @Override
    public Expected findDate(String idExpected) {
        return expectedRespository.findByIdExpected(idExpected);
    }

}
