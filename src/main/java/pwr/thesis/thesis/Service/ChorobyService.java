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
    private final ChorobyDTO chorobyDTO;

    public ChorobyService(ChorobyRepository chorobyRepository, ChorobyDTO chorobyDTO) {
        this.chorobyRepository = chorobyRepository;
        this.chorobyDTO = chorobyDTO;
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
        chorobyDTO.setNazwa(choroby.get().getNazwa());
        chorobyDTO.setDlugoscOperacji(choroby.get().getDlugosc_operacji());
        chorobyDTO.setWagaChoroby(choroby.get().getWaga_choroby());

        return chorobyDTO;
    }

    @Transactional
    public void update(ChorobyDTO chorobyDTO) {
        Optional<Choroby> byNazwaIgnoreCase = chorobyRepository.findByNazwaIgnoreCase(chorobyDTO.getNazwa());
        Choroby update = byNazwaIgnoreCase.get();
        update.setDlugosc_operacji(chorobyDTO.getDlugoscOperacji());
        update.setWaga_choroby(chorobyDTO.getWagaChoroby());
    }
}
