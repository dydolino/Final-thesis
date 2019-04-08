package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Lekarz;

public interface LekarzRepository extends JpaRepository<Lekarz,Long> {
}
