package fa.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.entities.Airline;
import fa.training.entities.Contract;
import fa.training.entities.Country;
import fa.training.entities.Expected;
import fa.training.entities.FareType;
import fa.training.entities.Priority;
import fa.training.entities.Region;
import fa.training.service.AirlineService;
import fa.training.service.CountryService;
import fa.training.service.ExpectedService;
import fa.training.service.FareTypeService;
import fa.training.service.PriorityService;
import fa.training.service.RegionService;
import fa.training.service.UpdateContractService;
import fa.training.util.ScheduleValidator;

/**
 * Controller class for handling contract updates.
 * 
 * @author HoaLD6
 * @date August 28, 2023
 */
@Controller
public class UpdateController {

    @Autowired
    UpdateContractService contractService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    CountryService countryService;

    @Autowired
    RegionService regionSevice;

    @Autowired
    PriorityService priorityService;

    @Autowired
    FareTypeService fareTypeService;

    @Autowired
    ExpectedService expectedService;

    @Autowired
    ScheduleValidator scheduleValidator;

    // Other Autowired services...

    /**
     * Displays the update page for a specific contract.
     * 
     * @param model    The model used for adding attributes to the view.
     * @param contract The Contract object.
     * @param id       The ID of the contract to be updated.
     * @return The view name "update" or "listData" if the contract is not found.
     * @since August 28, 2023
     */
    @GetMapping("/updateContract")
    public String getupdate(Model model, Contract contract, @RequestParam("id") int id) {
        Contract ct = contractService.findById(id);
        if(ct == null) {
            model.addAttribute("message", "Record has been deleted in data");
            List<Contract> show = contractService.findAll();
            model.addAttribute("listContract", show);
            return "listData";
        }
        List<Airline> listAir = airlineService.findAll();
        List<Country> listCon = countryService.findAll();
        List<Region> listRegi = regionSevice.findAll();
        List<Priority> listPri = priorityService.findAll();
        List<FareType> listFare = fareTypeService.findAll();
        Expected exp = expectedService.findDate("dt1");

        model.addAttribute("getListAir", listAir);
        model.addAttribute("getListCon", listCon);
        model.addAttribute("getListRegi", listRegi);
        model.addAttribute("getListPri", listPri);
        model.addAttribute("getListFare", listFare);

        model.addAttribute("exp", exp);
        model.addAttribute("getUpdate", ct);

        return "update";

    }

    /**
     * Handles the submission of updated contract data.
     * 
     * @param model    The model used for adding attributes to the view.
     * @param id       The ID of the contract to be updated.
     * @param contract The Contract object containing updated data.
     * @param result   The BindingResult object for validation.
     * @return The view name "listData" or "update" if there are validation errors.
     * @since August 28, 2023
     */
    @PostMapping("/updateSubContract")
    public String doupdate(Model model, @RequestParam("id") Long id,
            @ModelAttribute(name = "getUpdate") @Valid Contract contract, BindingResult result) {

        Contract ct = contractService.findByIdCt(id);
        contract.setContractId(id);

        scheduleValidator.validate(contract, result);

        if (result.hasErrors()) {
            List<Airline> listAirline = airlineService.findAll();
            List<Country> listCountry = countryService.findAll();
            List<Region> listRegion = regionSevice.findAll();
            List<Priority> listPriority = priorityService.findAll();
            List<FareType> listFareType = fareTypeService.findAll();
            Expected exp = expectedService.findDate("dt1");
            model.addAttribute("getListAir", listAirline);
            model.addAttribute("getListCon", listCountry);
            model.addAttribute("getListRegi", listRegion);
            model.addAttribute("getListPri", listPriority);
            model.addAttribute("getListFare", listFareType);
            model.addAttribute("exp", exp);
            return "update";
        }
        contract.setImportantLevel(ct.getImportantLevel());
        Expected exp = expectedService.findDate("dt1");
        contract.setQueuingStartDate(contract.getDateClarificationCleared());
        contract.setQueuingEndDate(exp.getDateExpected());
        double calcuTotal = contract.getNumberOfFares() + contract.getRtgsRecords() + contract.getNumberOfRules();
        contract.setTotalRecords(calcuTotal);
        contractService.updateService(contract);
        List<Contract> show = contractService.findAll();
        model.addAttribute("listContract", show);
        return "listData";

    }
}
