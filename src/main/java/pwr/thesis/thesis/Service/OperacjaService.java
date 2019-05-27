package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.DTOmodel.OperacjaDTO;
import pwr.thesis.thesis.Model.*;
import pwr.thesis.thesis.Repository.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    public OperacjaService(OperacjaRepository operacjaRepository, Egz_chorobyService egz_chorobyService, PacjentRepository pacjentRepository, LekarzRepository lekarzRepository, SalaRepository salaRepository, MiesiacRepository miesiacRepository, DzienRepository dzienRepository, WydarzeniaRepository wydarzeniaRepository) {
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
        Wydarzenia wydarzenia = wydarzeniaRepository.save(new Wydarzenia(operacja.getTimeFrom(), lenghtSurgery(parts, operacja.getTimeFrom(), egz_choroby.getChoroby().getDlugosc_operacji()), dzien));
        operacjaRepository.save(new Operacja(egz_choroby, pacjent, lekarz, sala, wydarzenia));
    }


    private String lenghtSurgery(String[] parts, String timeFrom, double howLong) {
        int[] data = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        String[] arr = String.valueOf(howLong).split("\\.");
        Integer[] lenght = {Integer.valueOf(arr[0]), Integer.valueOf(arr[1])};
        String[] godzina = timeFrom.split(":");
        Integer[] time = {Integer.valueOf(godzina[0]), Integer.valueOf(godzina[1])};
        Calendar calendar = addTime(data, time, lenght);
        return String.join(":", String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)), String.valueOf(calendar.get(Calendar.MINUTE)));
    }


    private Calendar addTime(int[] data, Integer[] timeFrom, Integer[] lenght) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm");
        Calendar calendar = new GregorianCalendar(data[0], data[1] - 1, data[2], timeFrom[0], timeFrom[1]);
        calendar.add(Calendar.HOUR_OF_DAY, lenght[0]);
        calendar.add(Calendar.MINUTE, lenght[1]);

        return calendar;
    }
}
