package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.Model.Sala;
import pwr.thesis.thesis.Repository.SalaRepository;

import java.util.List;

@Service
public class SalaService {

    private SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }


    @Transactional
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }
}
