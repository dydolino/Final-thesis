package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.Model.Choroby;
import pwr.thesis.thesis.Repository.ChorobyRepository;

import java.util.Optional;

@Service
public class ChorobyService {

    private ChorobyRepository chorobyRepository;

    public ChorobyService(ChorobyRepository chorobyRepository) {
        this.chorobyRepository = chorobyRepository;
    }

    @Transactional
    public void update(Long id){
        Optional<Choroby> byId = chorobyRepository.findByIdChoroby(id);
        Choroby jedynka = byId.get();
        jedynka.setNazwa("Tetnica");
    }
}
