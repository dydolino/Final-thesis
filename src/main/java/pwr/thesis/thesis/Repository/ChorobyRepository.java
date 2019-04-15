package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Choroby;

import java.util.List;
import java.util.Optional;

public interface ChorobyRepository extends JpaRepository<Choroby,Long> {


    Optional<Choroby> findByNazwaIgnoreCase(String nazwa);

    Optional<Choroby> findByIdChoroby(Long id);
}
