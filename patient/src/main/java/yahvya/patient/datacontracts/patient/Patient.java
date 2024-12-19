package yahvya.patient.datacontracts.patient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @brief a patient data contract
 */
@Entity
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
    public String name;

    /**
     * @brief patient firstname
     */
    public String firstname;

    /**
     * @brief patient birthdate
     */
    public String birthdate;

    /**
     * @brief phone number
     */
    public String phoneNumber;

    public Patient(){}

    public Patient(String id, String name, String firstname, String birthdate, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
    }
}
