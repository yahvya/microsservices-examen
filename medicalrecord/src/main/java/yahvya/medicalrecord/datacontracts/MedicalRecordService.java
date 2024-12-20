package yahvya.medicalrecord.datacontracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief medical record service
 */
@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordAppointmentDtoRepo appointmentsRepo;

    @Autowired
    private MedicalRecordDtoRepo medicalRecordRepo;

    /**
     * @brief get patient medical record
     * @param patientId patient id
     * @return patient id
     */
    public MedicalRecordDto getPatientMedicalRecord(String patientId) {
        MedicalRecordDto medicalRecordDto = medicalRecordRepo.findByPatientId(patientId);

        if(medicalRecordDto == null) {
            medicalRecordDto = new MedicalRecordDto();
            medicalRecordDto.patientId = patientId;
            medicalRecordDto = this.createMedicalRecord(medicalRecordDto);
        }
        return medicalRecordDto;
    }

    /**
     * @brief get practitionner patients medical record
     * @param practitionnerId practitionner id
     * @return patient id
     */
    public List<MedicalRecordDto> getPractitionnerPatientsMedicalRecord(String practitionnerId) {
        List<String> medicalRecordId = this.appointmentsRepo.findByPractitionnerId(practitionnerId).stream().map(e -> e.medicalRecord.id).distinct().toList();

        ArrayList<MedicalRecordDto> result = new ArrayList<MedicalRecordDto>();

        medicalRecordId.stream().map(id -> this.medicalRecordRepo.findById(id)).forEach(e -> {
            e.ifPresent(result::add);
        });

        return result;
    }

    /**
     * @brief create a medical record
     * @param medicalRecordDto medical record
     * @return for patient
     */
    public MedicalRecordDto createMedicalRecord(MedicalRecordDto medicalRecordDto) {
        return this.medicalRecordRepo.save(medicalRecordDto);
    }

    /**
     * @brief save an appointment in the patient dto
     * @param patientId patient id
     * @param medicalRecordAppointmentDto appointment
     * @return created one
     */
    public MedicalRecordAppointmentDto createMedicalRecordAppointment(String patientId, MedicalRecordAppointmentDto medicalRecordAppointmentDto) {
        medicalRecordAppointmentDto.medicalRecord = this.getPatientMedicalRecord(patientId);

        return this.appointmentsRepo.save(medicalRecordAppointmentDto);
    }
}
