package yahvya.patient.datacontracts.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * @brief modify the patient in database
     * @param patient the patient to create
     * @return the created patient data or null on failure
     */
    public Patient modifyPatient(Patient patient) {
        try{
            return this.patientRepo.save(patient);
        }
        catch(Exception e){
            return null;
        }
    }

    /**
     * @return all patient
     */
    public List<Patient> getAll() {
        return this.patientRepo.findAll();
    }

    /**
     * @brief get a patient data by id
     * @param id id
     * @return patient data
     */
    public Patient getPatient(String id) {
        return this.patientRepo.findById(id).orElse(null);
    }

    /**
     * @brief delete a patient data by id
     * @param id id
     * @return patient data
     */
    public boolean deletePatient(String id) {
        try{
            this.patientRepo.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
