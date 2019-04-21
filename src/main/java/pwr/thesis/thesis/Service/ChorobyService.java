package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.DTOmodel.ChorobyDTO;
import pwr.thesis.thesis.Model.Choroby;
import pwr.thesis.thesis.Repository.ChorobyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChorobyService {

    private final ChorobyRepository chorobyRepository;


    public ChorobyService(ChorobyRepository chorobyRepository) {
        this.chorobyRepository = chorobyRepository;
    }

    @Transactional
    public void addChoroba(ChorobyDTO chorobyDTO) {
        Choroby choroby = new Choroby(chorobyDTO.getNazwa(), chorobyDTO.getWagaChoroby(), chorobyDTO.getDlugoscOperacji());
        chorobyRepository.save(choroby);
    }

    @Transactional
    public List<Choroby> allChoroby() {
        return chorobyRepository.findAll();
    }

    @Transactional
    public ChorobyDTO findChoroba(String nazwa) {
        Optional<Choroby> choroby = chorobyRepository.findByNazwaIgnoreCase(nazwa);
        return new ChorobyDTO(choroby.get().getNazwa(), choroby.get().getWaga_choroby(), choroby.get().getDlugosc_operacji());
    }

    @Transactional
    public void update(ChorobyDTO chorobyDTO) {
        Optional<Choroby> byNazwaIgnoreCase = chorobyRepository.findByNazwaIgnoreCase(chorobyDTO.getNazwa());
        Choroby update = byNazwaIgnoreCase.get();
        update.setDlugosc_operacji(chorobyDTO.getDlugoscOperacji());
        update.setWaga_choroby(chorobyDTO.getWagaChoroby());
    }
}
