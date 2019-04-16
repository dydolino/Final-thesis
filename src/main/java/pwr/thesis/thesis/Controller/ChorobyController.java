package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pwr.thesis.thesis.DTOmodel.ChorobyDTO;
import pwr.thesis.thesis.Model.Choroby;
import pwr.thesis.thesis.Repository.ChorobyRepository;
import pwr.thesis.thesis.Service.ChorobyService;
import pwr.thesis.thesis.validator.ChorobyValidator;

import java.util.Optional;

@Controller
public class ChorobyController {

    private ChorobyRepository chorobyRepository;
    private ChorobyService chorobyService;
    private ChorobyValidator chorobyValidator;


    @Autowired
    public ChorobyController(ChorobyRepository chorobyRepository, ChorobyService chorobyService, ChorobyValidator chorobyValidator) {
        this.chorobyRepository = chorobyRepository;
        this.chorobyService = chorobyService;
        this.chorobyValidator = chorobyValidator;
    }


    @GetMapping("/addChoroby")
    public String choroba(Model model) {
        model.addAttribute("choroby", new ChorobyDTO());
        return "addChoroba";
    }

    @PostMapping("save")
    public String addChoroba(ChorobyDTO choroby, BindingResult bindingResult) {
        chorobyValidator.validate(choroby, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/addChoroby";
        } else {
            chorobyService.addChoroba(choroby);
            return "startPage";
        }

    }

    @GetMapping("/allChoroby")
    public String allChoroby(Model model) {
        model.addAttribute("choroby", chorobyService.allChoroby());
        return "allChoroby";
    }

    @GetMapping("/choroba/{nazwa}")
    public String getChoroba(Model model, @PathVariable String nazwa) {
        Optional<Choroby> chrobaByNazwa = chorobyRepository.findByNazwaIgnoreCase(nazwa);
        chrobaByNazwa.ifPresent(choroby -> model.addAttribute("choroba", choroby));
        return chrobaByNazwa.map(choroby -> "singleChoroba").orElse("noChoroba");
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteChoroba(@PathVariable Long id) {
        chorobyRepository.deleteById(id);
        return "Usunieto chorobe o id " + id;
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        chorobyService.update(id);
        return "Zaktualizowano obiekt o id " + id;
    }
}
