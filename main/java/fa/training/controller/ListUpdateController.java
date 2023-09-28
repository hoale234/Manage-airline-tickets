package fa.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fa.training.entities.Contract;
import fa.training.service.UpdateContractService;

/**
 * Controller class to handle retrieving and displaying data information.
 * 
 * This class manages operations related to fetching data and updating rows in the data table.
 * 
 * @Author HoaLD6
 * Date of Birth: 03/04/2000 
 * @since Aug 28, 2023
 */
@Controller
public class ListUpdateController {

    @Autowired
    UpdateContractService contractService;

    /**
     * Displays the information contained in the contract data table.
     * 
     * @param model    The model to provide attributes to the view.
     * @param contract The Contract object.
     * @return The view "listData" containing a table with information from the data fields.
     * @Author HoaLD6
     * Date of Birth: 03/04/2000 
     * @since Aug 28, 2023
     */
    @GetMapping("/")
    public String displayContract(Model model, Contract contract) {
        List<Contract> show = contractService.findAll();
        model.addAttribute("listContract", show);
        return "listData";
    }
}
