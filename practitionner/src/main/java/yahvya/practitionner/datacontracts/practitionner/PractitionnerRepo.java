package yahvya.practitionner.datacontracts.practitionner;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @brief practitionner repo
 */
public interface PractitionnerRepo extends JpaRepository<Practitionner, String> {
}
