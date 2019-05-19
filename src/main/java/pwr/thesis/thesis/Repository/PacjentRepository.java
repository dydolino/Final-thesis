package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Pacjent;

import java.util.Optional;

public interface PacjentRepository extends JpaRepository<Pacjent, Long> {
    Optional<Pacjent> findBypeselIgnoreCase(String pesel);

    Pacjent findBypesel(String pesel);
}
