package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pwr.thesis.thesis.Model.Choroby;
import pwr.thesis.thesis.Repository.ChorobyRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ChorobyController {

    private ChorobyRepository chorobyRepository;

    @Autowired
    public ChorobyController(ChorobyRepository chorobyRepository) {
        this.chorobyRepository = chorobyRepository;
    }

    @GetMapping("/")
    public String choroba(Model model) {
        model.addAttribute("choroby", new Choroby());
        return "dodajChorobe";
    }

    @PostMapping("save")
    public String addChoroba(Choroby choroby) {

        chorobyRepository.save(choroby);
        return "success";
    }

    @GetMapping("/allChoroby")
    public String allChoroby(Model model) {
        List<Choroby> allChorobys=chorobyRepository.findAll();
        model.addAttribute("choroby", allChorobys);
        return "allChoroby";
    }

    @GetMapping("/choroba/{nazwa}")
    public String getChoroba(Model model, @PathVariable String nazwa){
        Optional<Choroby> chrobaByNazwa = chorobyRepository.findByNazwaIgnoreCase(nazwa);
        chrobaByNazwa.ifPresent(choroby -> model.addAttribute("choroba",choroby));
        return chrobaByNazwa.map(choroby -> "singleChoroba").orElse("noChoroba");
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteChoroba(@PathVariable Long id){
        chorobyRepository.deleteById(id);
        return "Usunieto chorobe o id "+id;
    }
}
