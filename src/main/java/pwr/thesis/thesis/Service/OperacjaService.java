package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.DTOmodel.OperacjaDTO;
import pwr.thesis.thesis.Model.Egz_choroby;
import pwr.thesis.thesis.Model.Lekarz;
import pwr.thesis.thesis.Model.Operacja;
import pwr.thesis.thesis.Model.Pacjent;
import pwr.thesis.thesis.Repository.LekarzRepository;
import pwr.thesis.thesis.Repository.OperacjaRepository;
import pwr.thesis.thesis.Repository.PacjentRepository;

import java.util.List;

@Service
public class OperacjaService {

    private OperacjaRepository operacjaRepository;
    private Egz_chorobyService egz_chorobyService;
    private PacjentService pacjentService;
    private PacjentRepository pacjentRepository;
    private LekarzRepository lekarzRepository;

    public OperacjaService(OperacjaRepository operacjaRepository, Egz_chorobyService egz_chorobyService, PacjentService pacjentService, PacjentRepository pacjentRepository, LekarzRepository lekarzRepository) {
        this.operacjaRepository = operacjaRepository;
        this.egz_chorobyService = egz_chorobyService;
        this.pacjentService = pacjentService;
        this.pacjentRepository = pacjentRepository;
        this.lekarzRepository = lekarzRepository;
    }

    @Transactional
    public List<Operacja> findAll() {
        return operacjaRepository.findAll();
    }

    @Transactional
    public void addOperacja(OperacjaDTO operacja) {
        Egz_choroby egz_choroby = egz_chorobyService.findById(operacja.getEgz_chorobyID());
        Pacjent pacjent = pacjentRepository.findBypesel(egz_choroby.getPacjent().getPESEL());
        Lekarz lekarz = lekarzRepository.findByNumerLicencji(operacja.getNumerLicencji());
        operacjaRepository.save(new Operacja(egz_choroby, pacjent, lekarz));
    }
}
