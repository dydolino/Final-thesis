package pwr.thesis.thesis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.thesis.thesis.Model.Choroby;

public interface ChorobyRepository extends JpaRepository<Choroby,Integer> {
}
