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
 * Entity class representing a priority.
 * 
 * This class is mapped to the "PRIORITY" table in the database and represents information about a priority.
 * It includes attributes such as priority code, priority name, and a list of associated contracts.
 * 
 * @Author HoaLD6
 * @since Aug 28, 2023
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PRIORITY")
public class Priority {
    /**
     * The code representing the priority.
     */
    @Id
    @Column(name = "PRIORITY_CODE", length = 1)
    private String priorityCode;

    /**
     * The name of the priority.
     */
    @Column(name = "PRIORITY_NAME", length = 100)
    private String priorityName;


    /**
     * List of contracts associated with the priority.
     */
    @OneToMany(mappedBy = "priority", cascade = CascadeType.ALL)
    private List<Contract> listContract;


    /**
     * Constructor to initialize a priority.
     * 
     * @param priorityCode The code representing the priority.
     * @param priorityName The name of the priority.
     */
    public Priority(String priorityCode, String priorityName) {
        super();
        this.priorityCode = priorityCode;
        this.priorityName = priorityName;
    }

    /**
     * Returns a string representation of the priority.
     * 
     * @return A string describing the priority object.
     */
    @Override
    public String toString() {
        return "Priority [priorityCode=" + priorityCode + ", priorityName=" + priorityName + "]";
    }

}
