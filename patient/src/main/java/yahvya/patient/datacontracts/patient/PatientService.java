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
}
