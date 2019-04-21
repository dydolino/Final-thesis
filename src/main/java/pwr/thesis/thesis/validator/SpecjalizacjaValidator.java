package pwr.thesis.thesis.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pwr.thesis.thesis.DTOmodel.SpecjalizacjaDTO;
import pwr.thesis.thesis.Model.Lekarz;
import pwr.thesis.thesis.Repository.SpecjalizacjaRepository;

@Component
public class SpecjalizacjaValidator implements Validator {

    private SpecjalizacjaRepository specjalizacjaRepository;

    @Autowired
    public SpecjalizacjaValidator(SpecjalizacjaRepository specjalizacjaRepository) {
        this.specjalizacjaRepository = specjalizacjaRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Lekarz.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        SpecjalizacjaDTO specjalizacjaDTO = (SpecjalizacjaDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nazwa", "NotEmpty");
        if (specjalizacjaDTO.getNazwa().length() < 2) {
            errors.rejectValue("nazwa", "Size.specjalizacjaDTO.Nazwa");
        }
        if (specjalizacjaDTO.getOpis().length() < 2) {
            errors.rejectValue("Opis", "Opis.Length.Short");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nazwa", "NotEmptyOrDuplicated");
        if (specjalizacjaRepository.findBynazwaIgnoreCase(specjalizacjaDTO.getNazwa()).isPresent()) {
            errors.rejectValue("Nazwa", "NazwaSpecjalizacji.Duplicated");
        }

    }
}
