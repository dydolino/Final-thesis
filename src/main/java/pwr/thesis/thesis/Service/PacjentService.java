package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.DTOmodel.PacjentDTO;
import pwr.thesis.thesis.Model.Pacjent;
import pwr.thesis.thesis.Repository.PacjentRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PacjentService {

    private PacjentRepository pacjentRepository;
    private Egz_chorobyService egz_chorobyService;

    public PacjentService(PacjentRepository pacjentRepository, Egz_chorobyService egz_chorobyService) {
        this.pacjentRepository = pacjentRepository;
        this.egz_chorobyService = egz_chorobyService;
    }

    @Transactional
    public void addPacjent(PacjentDTO pacjentDTO) {
        Pacjent pacjent = new Pacjent(pacjentDTO.getImie(), pacjentDTO.getNazwisko(), pacjentDTO.getPESEL());
        pacjentRepository.save(pacjent);
    }


    @Transactional
    public List<Pacjent> allPacjenci() {
        return pacjentRepository.findAll();
    }

    @Transactional
    public PacjentDTO findPacjent(String pesel) {
        Optional<Pacjent> pacjent = pacjentRepository.findBypeselIgnoreCase(pesel);
        return new PacjentDTO(pacjent.get().getImie(), pacjent.get().getNazwisko(), pacjent.get().getPESEL());
    }

    @Transactional
    public void update(PacjentDTO pacjentDTO) {
        Optional<Pacjent> bypeselIgnoreCase = pacjentRepository.findBypeselIgnoreCase(pacjentDTO.getPESEL());
        Pacjent update = bypeselIgnoreCase.get();
        update.setImie(pacjentDTO.getImie());
        update.setNazwisko(pacjentDTO.getNazwisko());

    }

    @Transactional
    public boolean delete(String pesel) {
        Optional<Pacjent> bypeselIgnoreCase = pacjentRepository.findBypeselIgnoreCase(pesel);
        if (egz_chorobyService.find(bypeselIgnoreCase.get())) {
            pacjentRepository.delete(bypeselIgnoreCase.get());
            return true;
        } else return false;
    }
}
