package fa.training.service;

import java.util.List;

import fa.training.entities.Contract;
/**
 * Service implementation for managing Contract updates.
 * 
 * This class provides methods to interact with the data layer for Contract entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
public interface UpdateContractService {

    List<Contract> findAll();

    Contract findById(int id);

    Contract findByIdCt(long id);

    void updateService(Contract contract);

}
