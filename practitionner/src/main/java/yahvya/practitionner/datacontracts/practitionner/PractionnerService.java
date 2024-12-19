package yahvya.practitionner.datacontracts.practitionner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @brief practionner service
 */
@Service
public class PractionnerService {
    @Autowired
    private PractitionnerRepo practionnerRepo;

    /**
     * @brief create practitionner
     * @param practitionner practionner instance
     * @return created one
     */
    public Practitionner createPractitionner(Practitionner practitionner) {
        return practionnerRepo.save(practitionner);
    }

    /**
     * @brief modify practitionner
     * @param practitionner practionner instance
     * @return modified one
     */
    public Practitionner modifyPractitionner(Practitionner practitionner) {
        return practionnerRepo.save(practitionner);
    }

    /**
     * @brief delete practitionner
     * @param practitionner practionner instance
     * @return deletion success
     */
    public boolean deletePractitionner(Practitionner practitionner) {
        try{
            practionnerRepo.delete(practitionner);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * @return all practitionners
     */
    public List<Practitionner> getAll() {
        return this.practionnerRepo.findAll();
    }

    /**
     * @brief find one by his id
     * @param id id
     * @return founded one or null
     */
    public Practitionner getById(String id) {
        return this.practionnerRepo.findById(id).orElse(null);
    }
}
