package yahvya.medicalrecord.datacontracts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @brief medical record repository
 */
public interface MedicalRecordDtoRepo extends JpaRepository<MedicalRecordDto, String> {
    MedicalRecordDto findByPatientId(String patientId);
}
