package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.Model.Egz_choroby;
import pwr.thesis.thesis.Model.Pacjent;
import pwr.thesis.thesis.Repository.Egz_ChorobyRepository;
import pwr.thesis.thesis.Repository.PacjentRepository;

import java.util.List;

@Service
public class Egz_chorobyService {

    private Egz_ChorobyRepository egz_chorobyRepository;
    private PacjentRepository pacjentRepository;

    public Egz_chorobyService(Egz_ChorobyRepository egz_chorobyRepository, PacjentRepository pacjentRepository) {
        this.egz_chorobyRepository = egz_chorobyRepository;
        this.pacjentRepository = pacjentRepository;
    }

    @Transactional
    public boolean find(Pacjent pacjent) {
        return egz_chorobyRepository.findAllBypacjent(pacjent).isEmpty();
    }

    @Transactional
    public boolean findByPesel(String pesel) {
        return egz_chorobyRepository.findAllBypacjent(pacjentRepository.findBypeselIgnoreCase(pesel)).isEmpty();
    }

    @Transactional
    public List<Egz_choroby> findAll(String pesel) {
        return egz_chorobyRepository.findAllBypacjent(pacjentRepository.findBypeselIgnoreCase(pesel));
    }
}
