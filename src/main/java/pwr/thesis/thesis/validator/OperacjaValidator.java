package pwr.thesis.thesis.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pwr.thesis.thesis.DTOmodel.OperacjaDTO;
import pwr.thesis.thesis.Model.Egz_choroby;
import pwr.thesis.thesis.Model.Operacja;
import pwr.thesis.thesis.Repository.OperacjaRepository;
import pwr.thesis.thesis.Service.Egz_chorobyService;
import pwr.thesis.thesis.Service.OperacjaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class OperacjaValidator implements Validator {

    private OperacjaRepository operacjaRepository;
    private OperacjaService operacjaService;
    private Egz_chorobyService egz_chorobyService;

    @Autowired
    public OperacjaValidator(OperacjaRepository operacjaRepository, OperacjaService operacjaService, Egz_chorobyService egz_chorobyService) {
        this.operacjaRepository = operacjaRepository;
        this.operacjaService = operacjaService;
        this.egz_chorobyService = egz_chorobyService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Operacja.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        OperacjaDTO operacja = (OperacjaDTO) o;
        String[] parts = operacja.getData().split("-");
        Egz_choroby egz_choroby = egz_chorobyService.findById(operacja.getEgz_chorobyID());
        String timeTo = operacjaService.lenghtSurgery(parts, operacja.getTimeFrom(), egz_choroby.getChoroby().getDlugosc_operacji());


        ValidationUtils.rejectIfEmpty(errors, "Data", "Duplicated");
        for (int i = 0; i < operacjaRepository.findAll().size(); i++) {
            if (operacjaRepository.findAll().get(i).getSala().getNumer_sali().equals(operacja.getNumerSali())) {
                if (operacjaRepository.findAll().get(i).getWydarzenia().getDzien().getMiesiac().getNumerMiesiaca().equals(Integer.valueOf(parts[1])) && operacjaRepository.findAll().get(i).getWydarzenia().getDzien().getNumerDnia().equals(Integer.valueOf(parts[2]))) {

                    try {
                        Date time1 = new SimpleDateFormat("HH:mm").parse(operacjaRepository.findAll().get(i).getWydarzenia().getGodzina_od());
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.setTime(time1);

                        Date time2 = new SimpleDateFormat("HH:mm").parse(operacjaRepository.findAll().get(i).getWydarzenia().getGodzina_do());
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTime(time2);

                        Date start = new SimpleDateFormat("HH:mm").parse(operacja.getTimeFrom());
                        Calendar calendar3 = Calendar.getInstance();
                        calendar3.setTime(start);

                        Date stop = new SimpleDateFormat("HH:mm").parse(timeTo);
                        Calendar calendar4 = Calendar.getInstance();
                        calendar4.setTime(stop);

                        Date x = calendar3.getTime();
                        if (x.compareTo(calendar1.getTime()) == 0 || (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) || x.compareTo(calendar2.getTime()) == 0) {

                            errors.rejectValue("Data", "Sala.Day.Duplicated");
                        }

                        Date y = calendar4.getTime();
                        if (y.compareTo(calendar1.getTime()) == 0 || (y.after(calendar1.getTime()) && y.before(calendar2.getTime())) || y.compareTo(calendar2.getTime()) == 0) {

                            errors.rejectValue("Data", "Sala.Day.Duplicated");
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }
}
