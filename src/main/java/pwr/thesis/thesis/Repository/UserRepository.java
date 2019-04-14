package pwr.thesis.thesis.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
