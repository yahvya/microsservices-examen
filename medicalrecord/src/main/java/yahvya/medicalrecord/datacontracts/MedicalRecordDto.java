package yahvya.medicalrecord.datacontracts;

import jakarta.persistence.*;

import java.util.List;

/**
 * @brief medical record database dto
 */
@Entity(name="medical_record")
public class MedicalRecordDto {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    public String id;

    @Column(name = "patient_id")
    public String patientId;

    @OneToMany(mappedBy = "medicalRecord")
    public List<MedicalRecordAppointmentDto> appointments;
}
