package fa.training.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * A utility class for handling date conversions.
 * This class provides methods to convert between different date formats and types.
 * 
 * @author HoaLD6 03/04/2000
 * @since Aug 28, 2023
 */
public class DateUtils {
    /**
     * Converts a string representation of a date in the format "yyyy-MM-dd" to a SQL date.
     * 
     * @param dt The string representation of the date.
     * @return A SQL date representation of the input string date.
     * @since Aug 28, 2023
     */
    public static java.sql.Date convertStringToDate(String dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            return new java.sql.Date(sdf.parse(dt).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Converts a util Date object to a string representation in the format "dd/MM/yyyy".
     * 
     * @param date The util Date object to be converted.
     * @return A string representation of the input date in the specified format.
     * @since Aug 28, 2023
     */
    public static String convertDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    /**
     * Converts a util Date object to a SQL Date object.
     * 
     * @param date The util Date object to be converted.
     * @return A SQL Date representation of the input util Date.
     * @since Aug 28, 2023
     */
    public static java.sql.Date convertUtilToSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * Converts a SQL Date object to a util Date object.
     * 
     * @param date The SQL Date object to be converted.
     * @return A util Date representation of the input SQL Date.
     * @since Aug 28, 2023
     */
    public static Date convertSqlToUtilDate(java.sql.Date date) {
        return new Date(date.getTime());
    }
}
