package yahvya.patient.datacontracts.patient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

/**
 * @brief a patient database data contract
 */
@Entity(name="patients")
public class Patient {
    /**
     * @brief patient guid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    /**
     * @brief patient name
     */
    @NotEmpty(message= "Please provide name")
    public String name;

    /**
     * @brief patient firstname
     */
    @NotEmpty(message= "Please provide firstname")
    public String firstname;

    /**
     * @brief patient birthdate
     */
    @NotEmpty(message= "Please provide birthdate")
    public String birthdate;

    /**
     * @brief phone number
     */
    @NotEmpty(message= "Please provide phone number")
    public String phoneNumber;

    public Patient(){}

    public Patient(String id, String name, String firstname, String birthdate, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
    }

    public Patient(String name, String firstname, String birthdate, String phoneNumber) {
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
    }
}
