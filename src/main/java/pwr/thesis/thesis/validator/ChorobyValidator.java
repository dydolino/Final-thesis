package pwr.thesis.thesis.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pwr.thesis.thesis.DTOmodel.ChorobyDTO;
import pwr.thesis.thesis.Model.Choroby;
import pwr.thesis.thesis.Repository.ChorobyRepository;

@Component
public class ChorobyValidator implements Validator {


    private ChorobyRepository chorobyRepository;

    @Autowired
    public ChorobyValidator(ChorobyRepository chorobyRepository) {
        this.chorobyRepository = chorobyRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Choroby.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ChorobyDTO chorobyDTO = (ChorobyDTO) o;

        ValidationUtils.rejectIfEmpty(errors, "nazwa", "NotEmpty");
        if (chorobyDTO.getNazwa().length() < 2) {
            errors.rejectValue("nazwa", "Size.chorobyDTO.name");
        }
        if (chorobyRepository.findByNazwaIgnoreCase(chorobyDTO.getNazwa()).isPresent()) {
            errors.rejectValue("nazwa", "Duplicate.chorobyDTO.name");
        }
    }
}
