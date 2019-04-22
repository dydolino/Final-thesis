package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.Model.Operacja;
import pwr.thesis.thesis.Repository.OperacjaRepository;

import java.util.List;

@Service
public class OperacjaService {

    private OperacjaRepository operacjaRepository;

    public OperacjaService(OperacjaRepository operacjaRepository) {
        this.operacjaRepository = operacjaRepository;
    }

    @Transactional
    public List<Operacja> findAll() {
        return operacjaRepository.findAll();
    }
}
