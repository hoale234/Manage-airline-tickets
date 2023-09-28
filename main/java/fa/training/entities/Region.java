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
 * Entity class representing a region.
 * 
 * This class is mapped to the "REGION" table in the database and represents information about a region.
 * It includes attributes such as region code, region name, and a list of associated contracts.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "REGION")
public class Region {
    /**
     * The code representing the region.
     */
    @Id
    @Column(name = "REGION_CODE", length = 10)
    private String regionCode;

    /**
     * The name of the region.
     */
    @Column(name = "REGION_NAME", length = 100)
    private String regionName;

    /**
     * List of contracts associated with the region.
     */
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Contract> listContract;

    /**
     * Constructor to initialize a region.
     * 
     * @param regionCode The code representing the region.
     * @param regionName The name of the region.
     */
    public Region(String regionCode, String regionName) {
        super();
        this.regionCode = regionCode;
        this.regionName = regionName;
    }

    /**
     * Returns a string representation of the region.
     * 
     * @return A string describing the region object.
     */
    @Override
    public String toString() {
        return "Region [regionCode=" + regionCode + ", regionName=" + regionName + "]";
    }

}
