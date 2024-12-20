package yahvya.medicalrecord.datacontracts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @brief medical appointment record repository
 */
public interface MedicalRecordAppointmentDtoRepo extends JpaRepository<MedicalRecordAppointmentDto, String> {
    List<MedicalRecordAppointmentDto> findByPractitionnerId(String practitionnerId);
}
