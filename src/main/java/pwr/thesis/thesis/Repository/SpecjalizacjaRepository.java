package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Specjalizacja;

import java.util.Optional;

public interface SpecjalizacjaRepository extends JpaRepository<Specjalizacja, Long> {


    Optional<Specjalizacja> findBynazwaIgnoreCase(String string);
}
