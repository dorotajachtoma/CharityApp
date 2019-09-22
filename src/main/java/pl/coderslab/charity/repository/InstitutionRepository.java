package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Institution;

import javax.transaction.Transactional;

@Transactional
public interface InstitutionRepository extends JpaRepository<Institution,Long> {
}
