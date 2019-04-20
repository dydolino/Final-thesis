package pwr.thesis.thesis.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pwr.thesis.thesis.DTOmodel.LekarzDTO;
import pwr.thesis.thesis.Model.Lekarz;
import pwr.thesis.thesis.Repository.LekarzRepository;

@Component
public class LekarzValidator implements Validator {

    private LekarzRepository lekarzRepository;

    @Autowired
    public LekarzValidator(LekarzRepository lekarzRepository) {
        this.lekarzRepository = lekarzRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Lekarz.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        LekarzDTO lekarzDTO = (LekarzDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Imie", "NotEmpty");
        if (lekarzDTO.getImie().length() < 2) {
            errors.rejectValue("Imie", "Size.lekarzDTO.imie");
        }
        if (lekarzDTO.getNazwisko().length() < 2) {
            errors.rejectValue("Nazwisko", "Nazwisko.Length.Short");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "NumerLicencji", "NotEmptyOrDuplicated");
        if (lekarzRepository.findByNumerLicencjiIgnoreCase(lekarzDTO.getNumerLicencji()).isPresent()) {
            errors.rejectValue("NumerLicencji", "NumerLicencji.Duplicated");
        }

    }
}
