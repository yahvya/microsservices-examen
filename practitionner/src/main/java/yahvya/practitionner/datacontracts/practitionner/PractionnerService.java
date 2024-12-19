package yahvya.practitionner.datacontracts.practitionner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @brief practionner service
 */
@Service
public class PractionnerService {
    @Autowired
    private PractitionnerRepo practionnerRepo;
}
