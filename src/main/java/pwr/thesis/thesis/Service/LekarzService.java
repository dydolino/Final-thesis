package pwr.thesis.thesis.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pwr.thesis.thesis.DTOmodel.LekarzDTO;
import pwr.thesis.thesis.Model.Lekarz;
import pwr.thesis.thesis.Repository.LekarzRepository;

@Service
public class LekarzService {

    private LekarzRepository lekarzRepository;

    public LekarzService(LekarzRepository lekarzRepository) {
        this.lekarzRepository = lekarzRepository;
    }

    @Transactional
    public void addLekarz(LekarzDTO lekarzDTO) {
        Lekarz lekarz = new Lekarz(lekarzDTO.getImie(), lekarzDTO.getNazwisko(), lekarzDTO.getNumerLicencji(), lekarzDTO.getSpecjalizacja());
        lekarzRepository.save(lekarz);
    }
}
