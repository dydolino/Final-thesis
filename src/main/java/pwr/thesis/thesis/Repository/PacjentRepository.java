package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Pacjent;

public interface PacjentRepository extends JpaRepository<Pacjent, Long> {
}
