package yahvya.practitionner.datacontracts.practitionner;

import jakarta.persistence.*;

/**
 * @brief practitionner database data contract
 */
@Entity(name="practitionner")
public class Practitionner {
    /**
     * @brief practitionner id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    public String id;

    /**
     * @brief name
     */
    public String name;

    /**
     * @brief first name
     */
    public String firstname;

    /**
     * @brief practicer practice field
     */
    @Column(name="practice_field")
    public String practiceField;
}
