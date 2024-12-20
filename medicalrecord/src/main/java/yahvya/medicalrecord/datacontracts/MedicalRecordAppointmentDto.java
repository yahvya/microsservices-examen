package yahvya.medicalrecord.datacontracts;

import jakarta.persistence.*;

/**
 * @brief medical record appointments
 */
@Entity(name="appointments")
public class MedicalRecordAppointmentDto {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    public String id;

    @Column(name="start_date")
    public String startDate;

    @Column(name="end_date")
    public String endDate;

    @Column(name="practitionner_id")
    public String practitionnerId;

    public String reason;

    @Column(name="_result")
    public String result;

    @ManyToOne
    @JoinColumn(name="medical_record_id")
    public MedicalRecordDto medicalRecord;
}
