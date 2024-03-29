package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.User;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

}
