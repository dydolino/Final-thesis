package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.DTOmodel.OperacjaDTO;
import pwr.thesis.thesis.Model.*;
import pwr.thesis.thesis.Repository.*;

import java.util.*;

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


    public String lenghtSurgery(String[] parts, String timeFrom, double howLong) {
        int[] data = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        String[] arr = String.valueOf(howLong).split("\\.");
        Integer[] lenght = {Integer.valueOf(arr[0]), Integer.valueOf(arr[1])};
        String[] godzina = timeFrom.split(":");
        Integer[] time = {Integer.valueOf(godzina[0]), Integer.valueOf(godzina[1])};
        Calendar calendar = addTime(data, time, lenght);
        return String.join(":", String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)), String.valueOf(calendar.get(Calendar.MINUTE)));
    }


    private Calendar addTime(int[] data, Integer[] timeFrom, Integer[] length) {
        Calendar calendar = new GregorianCalendar(data[0], data[1] - 1, data[2], timeFrom[0], timeFrom[1]);
        calendar.add(Calendar.HOUR_OF_DAY, length[0]);
        calendar.add(Calendar.MINUTE, length[1]);

        return calendar;
    }

    @Transactional
    public void update(OperacjaDTO operacjaDTO) {
        Operacja operacja = operacjaRepository.findById(operacjaDTO.getIdOperacjii()).get();
        String[] parts = operacjaDTO.getData().split("-");
        operacja.setLekarz(lekarzRepository.findByNumerLicencji(operacjaDTO.getNumerLicencji()));
        operacja.setSala(salaRepository.findByNumerSali(operacjaDTO.getNumerSali()));
        operacja.getWydarzenia().setGodzina_od(operacjaDTO.getTimeFrom());
        operacja.getWydarzenia().setGodzina_do(lenghtSurgery(parts, operacjaDTO.getTimeFrom(), operacja.getEgz_choroby().getChoroby().getDlugosc_operacji()));
        operacja.getWydarzenia().getDzien().getMiesiac().setNumerMiesiaca(Integer.valueOf(parts[1]));
        operacja.getWydarzenia().getDzien().setNumerDnia(Integer.valueOf(parts[2]));

    }


    @Transactional
    public OperacjaDTO findOperacja(Integer id) {
        Optional<Operacja> operacja = operacjaRepository.findById(id);
        String month;
        String day;
        if (operacja.get().getWydarzenia().getDzien().getMiesiac().getNumerMiesiaca() < 10) {
            month = "0" + String.valueOf(operacja.get().getWydarzenia().getDzien().getMiesiac().getNumerMiesiaca());
        } else month = String.valueOf(operacja.get().getWydarzenia().getDzien().getMiesiac().getNumerMiesiaca());

        if (operacja.get().getWydarzenia().getDzien().getNumerDnia() < 10) {
            day = "0" + String.valueOf(operacja.get().getWydarzenia().getDzien().getNumerDnia());
        } else day = String.valueOf(operacja.get().getWydarzenia().getDzien().getNumerDnia());

        String join = String.join("-", "2019", month, day);
        return new OperacjaDTO(operacja.get().getPacjent().getPESEL(), operacja.get().getEgz_choroby().getIdEgz_choroby(), operacja.get().getLekarz().getNumerLicencji(), operacja.get().getSala().getNumer_sali(), join, operacja.get().getWydarzenia().getGodzina_od(), operacja.get().getIdOperacja());
    }

    @Transactional
    public void delete(Integer id) {
        operacjaRepository.deleteById(id);
    }
}
