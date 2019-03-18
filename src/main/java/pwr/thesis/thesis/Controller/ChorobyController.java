package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.thesis.thesis.Model.Choroby;
import pwr.thesis.thesis.Repository.ChorobyRepository;

@Controller
public class ChorobyController {

    private ChorobyRepository chorobyRepository;

    @Autowired
    public ChorobyController(ChorobyRepository chorobyRepository) {
        this.chorobyRepository = chorobyRepository;
    }

    @GetMapping("/")
    public String choroba(Model model){
        model.addAttribute("choroby",new Choroby());
        return "dodajChorobe";
    }

    @PostMapping("save")
    public String addChoroba(Choroby choroby){
        chorobyRepository.save(choroby);
        return "success";
    }

}
