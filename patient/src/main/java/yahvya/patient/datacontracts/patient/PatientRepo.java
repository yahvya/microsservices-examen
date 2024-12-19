package yahvya.patient.datacontracts.patient;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @brief patient repository
 */
public interface PatientRepo extends JpaRepository<Patient, String> {
}
