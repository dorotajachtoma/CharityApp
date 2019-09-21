package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRepository extends JpaRepository<Donation,Long>{

    @Query(value = "select sum(quantity) from donation;",nativeQuery = true)
    int sumQuantityFromDonation();

    @Query(value = "SELECT COUNT(DISTINCT institution_id) AS donations FROM donation;",nativeQuery = true)
    int sumUniqueInsitutions();

}