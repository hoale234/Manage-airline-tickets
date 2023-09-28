package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.FareType;
import fa.training.respostory.FareTypeRepository;
/**
 * Service implementation for managing FareType entities.
 * 
 * This class provides methods to interact with the data layer for FareType entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Service
public class FareTypeServiceImpl implements FareTypeService {

    @Autowired
    FareTypeRepository fareTypeRepository;

    /**
     * Retrieve a list of all FareType entities ordered by fareTypeName.
     * 
     * @return A list of all FareType entities.
     * @since Aug 28, 2023
     */

    @Override
    public List<FareType> findAll() {
        return fareTypeRepository.findAllByOrderByFareTypeNameAsc();
    }

}
