package fa.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Contract;
import fa.training.respostory.UpdateContractRepository;
/**
 * Implementation of the {@link UpdateContractService} interface.
 * Handles updating contract information in the database.
 * 
 * @author leduyhoa 03/04/2000
 * @since Aug 28, 2023
 */
@Service
public class UpdateContractServiceImpl implements UpdateContractService {

    @Autowired
    UpdateContractRepository contractRepository;

    /**
     * Updates the contract details in the database.
     * If the contract with the given ID exists, it updates the existing contract.
     * If the contract with the given ID doesn't exist, it adds the new contract.
     * 
     * @param contract The contract object containing updated data.
     * @since Aug 28, 2023
     */
    @Override
    public void updateService(Contract contract) {
        // Trước hết, bạn cần truy vấn đối tượng từ cơ sở dữ liệu
        Optional<Contract> existingContract = contractRepository.findById((long) contract.getContractId());

        if (existingContract.isPresent()) {
            // Cập nhật các thuộc tính của đối tượng đã truy vấn với các giá trị từ đối
            // tượng contract
            Contract updatedContract = existingContract.get();
            updatedContract.setContractName(contract.getContractName());
            updatedContract.setContractNumber(contract.getContractNumber());
            updatedContract.setAirline(contract.getAirline());
            updatedContract.setMarket(contract.getMarket());
            updatedContract.setPriority(contract.getPriority());
            updatedContract.setRegion(contract.getRegion());
            updatedContract.setFareType(contract.getFareType());
            updatedContract.setImportantLevel(contract.getImportantLevel());
            updatedContract.setDateReceived(contract.getDateReceived());
            updatedContract.setEffectiveDate(contract.getEffectiveDate());
            updatedContract.setDiscontinueDate(contract.getDiscontinueDate());
            updatedContract.setNumberOfFareSheets(contract.getNumberOfFareSheets());
            updatedContract.setNumberOfFares(contract.getNumberOfFares());
            updatedContract.setDateClarificationCleared(contract.getDateClarificationCleared());
            updatedContract.setRtgsActual(contract.getRtgsActual());
            updatedContract.setRtgsRecords(contract.getRtgsRecords());
            updatedContract.setNumberOfRules(contract.getNumberOfRules());
            updatedContract.setTotalRecords(
                    contract.getNumberOfFares() + contract.getRtgsRecords() + contract.getNumberOfRules());
            updatedContract.setQueuingStartDate(contract.getQueuingStartDate());
            updatedContract.setQueuingEndDate(contract.getQueuingEndDate());

            // Lưu đối tượng đã cập nhật vào cơ sở dữ liệu
            contractRepository.save(updatedContract);
        } else {
            // Thêm mới đối tượng đã cập nhật vào cơ sở dữ liệu
            System.out.println("Invalid ID, new data will be added to DataBase");
            contractRepository.save(existingContract.get());
        }
    }

    /**
     * Updates the properties of an existing contract with the data from the provided contract.
     * 
     * @param existingContract The existing contract to be updated.
     * @param newContract The contract containing updated data.
     * @since Aug 28, 2023
     */
    @Override
    public Contract findById(int id) {
        Optional<Contract> ct = contractRepository.findById((long) id);
        try {
            if (ct.get() != null) {
                return ct.get();
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * Calculates and updates the total number of records for the contract.
     * 
     * @param contract The contract object.
     * @since Aug 28, 2023
     */
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    /**
     * Saves the contract to the database.
     * 
     * @param contract The contract object to be saved.
     * @since Aug 28, 2023
     */
    @Override
    public Contract findByIdCt(long id) {
        Optional<Contract> findCt = contractRepository.findById((long) id);
        try {
            if (findCt.get() != null) {
                return findCt.get();
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
