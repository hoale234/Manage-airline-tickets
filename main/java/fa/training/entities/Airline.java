package fa.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing an airline.
 * 
 * This class is mapped to the "AIRLINE" table in the database and represents information about an airline.
 * It includes attributes such as airline code, airline name, and a list of associated contracts.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "AIRLINE")
public class Airline {
    /**
     * The unique code of the airline.
     */
    @Id
    @Column(name = "AIRLINE_CODE", length = 5)
    private String airlineCode;

    /**
     * The name of the airline.
     */
    @Column(name = "AIRLINE_NAME", length = 100)
    private String airlineName;

    /**
     * List of contracts associated with the airline.
     */
    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    private List<Contract> listContract;

    /**
     * Constructor to initialize an airline.
     * 
     * @param airlineCode The code of the airline.
     * @param airlineName The name of the airline.
     */
    public Airline(String airlineCode, String airlineName) {
        super();
        this.airlineCode = airlineCode;
        this.airlineName = airlineName;
    }

    /**
     * Returns a string representation of the airline.
     * 
     * @return A string describing the airline object.
     */
    @Override
    public String toString() {
        return "Airline [airlineCode=" + airlineCode + ", airlineName=" + airlineName + "]";
    }

}
