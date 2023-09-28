package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Priority;
import fa.training.respostory.PriorityRepository;
/**
 * Service implementation for managing Priority entities.
 * 
 * This class provides methods to interact with the data layer for Priority entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Service
public class PriorityServiceIpml implements PriorityService {
    @Autowired
    PriorityRepository priorityRepository;

    /**
     * Retrieve a list of all Priority entities ordered by priorityName.
     * 
     * @return A list of all Priority entities.
     * @since Aug 28, 2023
     */
    @Override
    public List<Priority> findAll() {
        return priorityRepository.findAllByOrderByPriorityNameAsc();
    }

}
