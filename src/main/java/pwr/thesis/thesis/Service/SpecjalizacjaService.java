package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.DTOmodel.SpecjalizacjaDTO;
import pwr.thesis.thesis.Model.Specjalizacja;
import pwr.thesis.thesis.Repository.SpecjalizacjaRepository;

import java.util.List;

@Service
public class SpecjalizacjaService {


    private SpecjalizacjaRepository specjalizacjaRepository;

    public SpecjalizacjaService(SpecjalizacjaRepository specjalizacjaRepository) {
        this.specjalizacjaRepository = specjalizacjaRepository;
    }

    @Transactional
    public List<Specjalizacja> findAll() {
        return specjalizacjaRepository.findAll();
    }

    @Transactional
    public void saveSpecjalizacja(SpecjalizacjaDTO specjalizacjaDTO) {
        Specjalizacja specjalizacja = new Specjalizacja(specjalizacjaDTO.getNazwa(), specjalizacjaDTO.getOpis());
        specjalizacjaRepository.save(specjalizacja);
    }
}
