package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    Sala findByNumerSali(Integer numer);
}
