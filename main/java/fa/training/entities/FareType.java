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
 * Entity class representing a fare type.
 * 
 * This class is mapped to the "FARE_TYPE" table in the database and represents information about a fare type.
 * It includes attributes such as fare type code, fare type name, and a list of associated contracts.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FARE_TYPE")
public class FareType {
    /**
     * The code representing the fare type.
     */
    @Id
    @Column(name = "FARE_TYPE_CODE", length = 1)
    private String fareTypeCode;

    /**
     * The name of the fare type.
     */
    @Column(name = "FARE_TYPE_NAME", length = 100)
    private String fareTypeName;

    /**
     * List of contracts associated with the fare type.
     */
    @OneToMany(mappedBy = "fareType", cascade = CascadeType.ALL)
    private List<Contract> listContract;

    /**
     * Constructor to initialize a fare type.
     * 
     * @param fareTypeCode The code representing the fare type.
     * @param fareTypeName The name of the fare type.
     */
    public FareType(String fareTypeCode, String fareTypeName) {
        super();
        this.fareTypeCode = fareTypeCode;
        this.fareTypeName = fareTypeName;
    }

    /**
     * Returns a string representation of the fare type.
     * 
     * @return A string describing the fare type object.
     */
    @Override
    public String toString() {
        return "FareType [fareTypeCode=" + fareTypeCode + ", fareTypeName=" + fareTypeName + "]";
    }

}
