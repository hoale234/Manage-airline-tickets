package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Entity class representing an expected date.
 * 
 * This class is mapped to the "EXPECTED" table in the database and represents information about an expected date.
 * It includes attributes such as the expected date's ID and the date value itself.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EXPECTED")
public class Expected {
    /**
     * The unique ID of the expected date.
     */
    @Id
    @Column(name = "ID_EXPECTED")
    private String idExpected;

    /**
     * The date value representing the expected date.
     */
    @Column(name = "EXPECTED_START_DATE")
    private LocalDate dateExpected;

    /**
     * Constructor to initialize an expected date.
     * 
     * @param idExpected The ID of the expected date.
     * @param dateExpected The date value representing the expected date.
     */
    public Expected(String idExpected, LocalDate dateExpected) {
        super();
        this.idExpected = idExpected;
        this.dateExpected = dateExpected;
    }

    /**
     * Returns a string representation of the expected date.
     * 
     * @return A string describing the expected date object.
     */
    @Override
    public String toString() {
        return "Expected [idExpected=" + idExpected + ", dateExpected=" + dateExpected + "]";
    }

}
