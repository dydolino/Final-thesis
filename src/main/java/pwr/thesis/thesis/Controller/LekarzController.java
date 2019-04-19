package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.Model.Lekarz;
import pwr.thesis.thesis.Model.Specjalizacja;
import pwr.thesis.thesis.Repository.LekarzRepository;
import pwr.thesis.thesis.Repository.SpecjalizacjaRepository;

import java.util.List;

@Controller
public class LekarzController {

    private LekarzRepository lekarzRepository;
    private SpecjalizacjaRepository specjalizacjaRepository;

    @Autowired
    public LekarzController(LekarzRepository lekarzRepository, SpecjalizacjaRepository specjalizacjaRepository) {
        this.lekarzRepository = lekarzRepository;
        this.specjalizacjaRepository = specjalizacjaRepository;
    }

    //TODO refaktoryzacja - dodanie serwisu + DTO
    @GetMapping("/addLekarz")
    public String add(Model model){
        model.addAttribute("lekarz",new Lekarz());
        List<Specjalizacja> AllSpecjalzacje = specjalizacjaRepository.findAll();
        model.addAttribute("specjlaizacje",AllSpecjalzacje);
        return "addLekarz";
    }

    //TODO refaktoryzacja - dodanie serwisu  + DTO
    @PostMapping("saveLekarz")
    public String addChoroba(Lekarz lekarz) {

        lekarzRepository.save(lekarz);
        return "startPage";
    }
}
