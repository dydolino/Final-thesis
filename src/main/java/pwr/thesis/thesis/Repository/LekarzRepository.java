package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Lekarz;

import java.util.Optional;

public interface LekarzRepository extends JpaRepository<Lekarz,Long> {


    Optional<Lekarz> findByNumerLicencjiIgnoreCase(String string);
}
