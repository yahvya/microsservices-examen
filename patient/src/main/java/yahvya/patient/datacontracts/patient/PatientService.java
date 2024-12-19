package yahvya.patient.datacontracts.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @brief patient interactions service
 */
@Service
public class PatientService {
    /**
     * @brief patient repository
     */
    @Autowired
    private PatientRepo patientRepo;

    /**
     * @brief save the patient in database
     * @param patient the patient to create
     * @return the created patient data or null on failure
     */
    public Patient addPatient(Patient patient) {
        try{
            return this.patientRepo.save(patient);
        }
        catch(Exception e){
            return null;
        }
    }
}
