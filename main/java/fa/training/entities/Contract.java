package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * Entity class representing a contract.
 * 
 * This class is mapped to the "CONTRACT" table in the database and represents information about a contract.
 * It includes various attributes such as contract ID, contract number, contract name, associated entities (airline,
 * market, priority, region, fare type), and dates related to the contract.
 * 
 * @Author HoaLD6
 * Date of Birth: 03/04/2000 
 * @since Aug 28, 2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CONTRACT")
public class Contract {
    /**
     * The unique ID of the contract.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTRACT_ID")
    private Long contractId;

    /**
     * The contract number.
     */
    @Column(name = "CONTRACT_NUMBER", length = 20)
    @Size(max = 20, message = "Contract number cannot exceed 20 characters.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Only letters and numbers can be entered.")
    @NotBlank(message = "Contract Number must be entered.")
    private String contractNumber;

    /**
     * The name of the contract.
     */
    @Column(name = "CONTRACT_NAME", length = 100)
    @Size(max = 100, message = "Contract number cannot exceed 100 characters.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Only letters and numbers can be entered.")
    @NotBlank(message = "Contract Name must be entered.")
    private String contractName;

    /**
     * The airline code of the contract.
     */
    @ManyToOne
    @JoinColumn(name = "AIRLINE_CODE", referencedColumnName = "AIRLINE_CODE")
    private Airline airline;

    /**
     * The country code of the contract.
     */
    @ManyToOne
    @JoinColumn(name = "COUNTRY_CODE", referencedColumnName = "COUNTRY_CODE")
    private Country market;

    /**
     * The priority code of the contract.
     */
    @ManyToOne
    @JoinColumn(name = "PRIORITY_CODE", referencedColumnName = "PRIORITY_CODE")
    private Priority priority;

    /**
     * The region code of the contract.
     */
    @ManyToOne
    @JoinColumn(name = "REGION_CODE", referencedColumnName = "REGION_CODE")
    private Region region;

    /**
     * The fare type code of the contract.
     */
    @ManyToOne
    @JoinColumn(name = "FARE_TYPE_CODE", referencedColumnName = "FARE_TYPE_CODE")
    private FareType fareType;

    /**
     * The important level of the contract.
     */
    @Column(name = "IMPORTANT_LEVEL")
    private String importantLevel;

    /**
     * The date received of the contract.
     */
    @Column(name = "DATE_RECEIVED")
    @NotNull(message = "Date Received must be entered.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateReceived;

    /**
     * The effective date of the contract.
     */
    @Column(name = "EFFECTIVE_DATE")
    @NotNull(message = "Effective Date must be entered.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate effectiveDate;

    /**
     * The discontinue date of the contract.
     */
    @Column(name = "DISCONTINUE_DATE")
    @NotNull(message = "Discontinue Date must be entered.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate discontinueDate;

    /**
     * The fare sheets of the contract.
     */
    @Column(name = "FARE_SHEETS")
    @Max(value = 999, message = "Cannot enter more than 3 numbers.")
    @NotNull(message = "Number of Fare Sheets must be entered.")
    private int numberOfFareSheets;

    /**
     * The number of fares of the contract.
     */
    @Column(name = "NUMBER_OF_FARES")
    @Max(value = 99999, message = "Cannot enter more than 5 numbers.")
    @NotNull(message = "Number of Fares must be entered.")
    private int numberOfFares;

    /**
     * The date clarification cleared of the contract.
     */
    @Column(name = "DATE_CLARIFICATION_CLEARED")
    @NotNull(message = "Date Clarification Cleared must be entered.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateClarificationCleared;

    /**
     * The rtgs actual of the contract.
     */
    @Column(name = "RTGS_ACTUAL")
    @Max(value = 99999, message = "Cannot enter more than 5 numbers.")
    @NotNull(message = "Rtgs Actual must be entered.")
    private int rtgsActual;

    /**
     * The rtgs records of the contract.
     */
    @Column(name = "RTGS_RECORDS")
    @Max(value = 99999, message = "Cannot enter more than 5 numbers.")
    @NotNull(message = "Rtgs Records must be entered.")
    private int rtgsRecords;

    /**
     * The rules of the contract.
     */
    @Column(name = "RULES")
    @Max(value = 999, message = "Cannot enter more than 3 numbers.")
    @NotNull(message = "Number of Rules must be entered.")
    private int numberOfRules;

    /**
     * The total records of the contract.
     */
    @Column(name = "TOTAL_RECORDS")
    private double totalRecords;

    /**
     * The queuing start date of the contract.
     */
    @Column(name = "QUEUING_START_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate queuingStartDate;

    /**
     * The queuing end date of the contract.
     */
    @Column(name = "QUEUING_END_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate queuingEndDate;

}
