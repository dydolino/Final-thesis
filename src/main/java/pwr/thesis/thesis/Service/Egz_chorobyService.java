package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.Model.Pacjent;
import pwr.thesis.thesis.Repository.Egz_ChorobyRepository;

@Service
public class Egz_chorobyService {

    private Egz_ChorobyRepository egz_chorobyRepository;

    public Egz_chorobyService(Egz_ChorobyRepository egz_chorobyRepository) {
        this.egz_chorobyRepository = egz_chorobyRepository;
    }

    @Transactional
    public boolean find(Pacjent pacjent) {
        return egz_chorobyRepository.findAllBypacjent(pacjent).isEmpty();
    }
}
