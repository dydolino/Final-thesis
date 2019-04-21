package pwr.thesis.thesis.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pwr.thesis.thesis.DTOmodel.PacjentDTO;
import pwr.thesis.thesis.Model.Pacjent;
import pwr.thesis.thesis.Repository.PacjentRepository;

@Component
public class PacjentValidator implements Validator {

    private PacjentRepository pacjentRepository;

    @Autowired
    public PacjentValidator(PacjentRepository pacjentRepository) {
        this.pacjentRepository = pacjentRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Pacjent.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        PacjentDTO pacjentDTO = (PacjentDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Imie", "Empty");
        if (pacjentDTO.getImie().length() < 2) {
            errors.rejectValue("Imie", "Size.pacjentDTO.imie");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nazwisko", "Empty");
        if (pacjentDTO.getNazwisko().length() < 2) {
            errors.rejectValue("Nazwisko", "Nazwisko.Length.Short");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "PESEL", "EmptyOrDuplicated");
        if (pacjentRepository.findBypeselIgnoreCase(pacjentDTO.getPESEL()).isPresent()) {
            errors.rejectValue("PESEL", "PESEL.Duplicated");
        }

    }
}
