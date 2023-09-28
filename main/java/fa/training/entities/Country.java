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
 * Entity class representing a country.
 * 
 * This class is mapped to the "COUNTRY" table in the database and represents information about a country.
 * It includes attributes such as country code, country name, and a list of associated contracts.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "COUNTRY")
public class Country {
    /**
     * The unique code of the country.
     */
    @Id
    @Column(name = "COUNTRY_CODE", length = 50)
    private String countryCode;

    /**
     * The name of the country.
     */
    @Column(name = "COUNTRY_NAME", length = 100)
    private String countryName;


    /**
     * List of contracts associated with the country.
     */
    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    private List<Contract> listContract;


    /**
     * Constructor to initialize a country.
     * 
     * @param countryCode The code of the country.
     * @param countryName The name of the country.
     */
    public Country(String countryCode, String countryName) {
        super();
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    /**
     * Returns a string representation of the country.
     * 
     * @return A string describing the country object.
     */
    @Override
    public String toString() {
        return "Country [countryCode=" + countryCode + ", countryName=" + countryName + "]";
    }

}