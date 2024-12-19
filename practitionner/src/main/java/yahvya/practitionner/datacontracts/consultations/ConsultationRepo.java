package yahvya.practitionner.datacontracts.consultations;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @brief consultation repo
 */
public interface ConsultationRepo extends JpaRepository<Consultation, String> {
}
