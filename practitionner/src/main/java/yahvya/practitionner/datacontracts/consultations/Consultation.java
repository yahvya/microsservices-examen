package yahvya.practitionner.datacontracts.consultations;

import jakarta.persistence.*;
import yahvya.practitionner.datacontracts.practitionner.Practitionner;

import java.time.LocalDate;

/**
 * @brief consultations
 */
@Entity
public class Consultation {
    /**
     * @brief id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    /**
     * @brief consultation reason
     */
    public String reason;

    /**
     * @brief consultation date
     */
    @Column
    public String date;

    /**
     * @brief consultation result
     */
    public String result;

    /**
     * @brief consulted user id
     */
    public String userId;

    /**
     * @brief linked practitionner
     */
    @ManyToOne
    @JoinColumn(name="practitionner_id")
    public Practitionner practitionner;

    @PrePersist
    public void beforePersist(){
        this.date = LocalDate.now().toString();
    }
}
