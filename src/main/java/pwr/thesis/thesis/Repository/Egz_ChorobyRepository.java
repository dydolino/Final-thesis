package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Egz_choroby;
import pwr.thesis.thesis.Model.Pacjent;

import java.util.List;

public interface Egz_ChorobyRepository extends JpaRepository<Egz_choroby, Long> {


    List<Egz_choroby> findAllBypacjent(Pacjent pacjent);
}
