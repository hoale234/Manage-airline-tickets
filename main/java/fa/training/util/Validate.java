package fa.training.util;

import java.text.SimpleDateFormat;
/**
 * A utility class for performing various validation tasks.
 * It provides methods for checking important dates and null or empty fields.
 * 
 * @author HoaLD6 03/04/2000
 * @since Aug 28, 2023
 */
public class Validate {
    /**
     * Checks if the given birth day string is a valid date in the format "dd/MM/yyyy".
     * 
     * @param birthDay The birth day string to be checked.
     * @return True if the birth day string is a valid date, false otherwise.
     */
    public static boolean checkImporthDay(String birthDay) {
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dFormat.format(DateUtils.convertStringToDate(birthDay));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     * Checks if the given field is null or empty.
     * 
     * @param field The field to be checked.
     * @return True if the field is null or empty, false otherwise.
     */
    public static boolean checkNull(String feild) {
        if (feild.equals(null) || feild.trim().equals("")) {
            return true;
        } else {
            return false;
        }
    }

}
