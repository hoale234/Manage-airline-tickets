package fa.training.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fa.training.entities.Contract;
/**
 * A validator class for validating contract scheduling.
 * This class implements the Spring Validator interface to provide custom validation logic for Contract objects.
 * It checks various scheduling rules related to the contract's dates.
 * 
 * @author HoaLD6
 * @since Aug 28, 2023
 */
@Component
public class ScheduleValidator implements Validator {
    /**
     * Determines whether the validator supports the given class.
     * In this case, it supports classes that are assignable from Contract.
     * 
     * @param clazz The class to be checked for support.
     * @return True if the class is assignable from Contract, false otherwise.
     */
    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return Contract.class.isAssignableFrom(clazz);
    }
    
    /**
     * Performs custom validation on the target object.
     * Validates the contract's date scheduling rules and adds validation errors if necessary.
     * 
     * @param target The object to be validated (expected to be a Contract).
     * @param errors The errors object to which validation errors can be added.
     */
    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Contract)) {
            return;
        }

        Contract contract = (Contract) target;

        if (contract.getDiscontinueDate().isBefore(contract.getDateClarificationCleared())) {
            errors.rejectValue("discontinueDate", null,
                    "Discontinue Date must be later than or equals to Date Clarification");
        }

        if (contract.getDiscontinueDate().isBefore(contract.getEffectiveDate())) {
            errors.rejectValue("discontinueDate", null,
                    "Discontinue Date must be later than or equals to Effective date");
        }

        if (contract.getDateClarificationCleared().isBefore(contract.getDateReceived())) {
            errors.rejectValue("discontinueDate", null, "Date Clarification must be later or equals to Date Received");
        }
    }
}
