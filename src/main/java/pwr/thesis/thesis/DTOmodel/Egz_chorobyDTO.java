package pwr.thesis.thesis.DTOmodel;

import org.springframework.stereotype.Controller;
import pwr.thesis.thesis.Model.Choroby;
import pwr.thesis.thesis.Model.Pacjent;

import java.time.LocalDateTime;

@Controller
public class Egz_chorobyDTO {

    public Egz_chorobyDTO() {
    }

    public Egz_chorobyDTO(Choroby choroby, LocalDateTime data_rozpoznania, Pacjent pacjent) {
        this.choroby = choroby;
        this.data_rozpoznania = data_rozpoznania;
        this.pacjent = pacjent;
    }

    private Choroby choroby;
    private LocalDateTime data_rozpoznania;
    private Pacjent pacjent;

    public Choroby getChoroby() {
        return choroby;
    }

    public void setChoroby(Choroby choroby) {
        this.choroby = choroby;
    }

    public LocalDateTime getData_rozpoznania() {
        return data_rozpoznania;
    }

    public void setData_rozpoznania(LocalDateTime data_rozpoznania) {
        this.data_rozpoznania = data_rozpoznania;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }
}
