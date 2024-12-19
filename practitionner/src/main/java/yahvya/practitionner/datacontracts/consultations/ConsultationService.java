package yahvya.practitionner.datacontracts.consultations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @brief consultation service
 */
@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepo consultationRepo;
}
