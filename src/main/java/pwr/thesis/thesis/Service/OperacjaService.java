package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.DTOmodel.OperacjaDTO;
import pwr.thesis.thesis.Model.*;
import pwr.thesis.thesis.Repository.*;

import java.util.List;

@Service
public class OperacjaService {

    private OperacjaRepository operacjaRepository;
    private Egz_chorobyService egz_chorobyService;
    private PacjentRepository pacjentRepository;
    private LekarzRepository lekarzRepository;
    private SalaRepository salaRepository;
    private MiesiacRepository miesiacRepository;
    private DzienRepository dzienRepository;
    private WydarzeniaRepository wydarzeniaRepository;

    public OperacjaService(OperacjaRepository operacjaRepository, Egz_chorobyService egz_chorobyService, PacjentService pacjentService, PacjentRepository pacjentRepository, LekarzRepository lekarzRepository, SalaRepository salaRepository, MiesiacRepository miesiacRepository, DzienRepository dzienRepository, WydarzeniaRepository wydarzeniaRepository) {
        this.operacjaRepository = operacjaRepository;
        this.egz_chorobyService = egz_chorobyService;
        this.pacjentRepository = pacjentRepository;
        this.lekarzRepository = lekarzRepository;
        this.salaRepository = salaRepository;
        this.miesiacRepository = miesiacRepository;
        this.dzienRepository = dzienRepository;
        this.wydarzeniaRepository = wydarzeniaRepository;
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
        Sala sala = salaRepository.findByNumerSali(operacja.getNumerSali());
        String[] parts = operacja.getData().split("-");
        Miesiac miesiac = miesiacRepository.save(new Miesiac(Integer.valueOf(parts[1]), sala));
        Dzien dzien = dzienRepository.save(new Dzien(Integer.valueOf(parts[2]), miesiac));
        Wydarzenia wydarzenia = wydarzeniaRepository.save(new Wydarzenia(operacja.getTimeFrom(), addHours(operacja.getTimeFrom(), egz_choroby.getChoroby().getDlugosc_operacji()), dzien));
        operacjaRepository.save(new Operacja(egz_choroby, pacjent, lekarz, sala, wydarzenia));
    }

    private String addHours(String timeFrom, double howLong) {
        String[] godzina = timeFrom.split(":");
        String[] arr = String.valueOf(howLong).split("\\.");
        Integer h = Integer.valueOf(godzina[0]) + Integer.parseInt(arr[0]);
        Integer m = Integer.valueOf(godzina[1]) + Integer.parseInt(arr[1]);
        return String.join(":", String.valueOf(h), String.valueOf(m));
    }
}
