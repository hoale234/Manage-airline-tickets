package fa.training.respostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Contract;
/**
 * Repository interface for managing Contract entities.
 * 
 * This interface extends JpaRepository and provides methods for interacting with the database for Contract entities.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
@Repository
public interface UpdateContractRepository extends JpaRepository<Contract, Long> {

}
