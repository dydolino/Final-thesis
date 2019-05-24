package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Dzien;

public interface DzienRepository extends JpaRepository<Dzien, Long> {
}
