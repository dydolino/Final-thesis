package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Egz_choroby;
import pwr.thesis.thesis.Model.Pacjent;

import java.util.List;
import java.util.Optional;

public interface Egz_ChorobyRepository extends JpaRepository<Egz_choroby, Integer> {


    List<Egz_choroby> findAllBypacjent(Pacjent pacjent);

    List<Egz_choroby> findAllBypacjent(Optional<Pacjent> bypeselIgnoreCase);


    Optional<Egz_choroby> findById(Integer integer);

}
