package pwr.thesis.thesis.DTOmodel;

import org.springframework.stereotype.Controller;

@Controller
public class SalaDTO {

    private Integer numer_sali;
    private Integer numer_pietra;

    public Integer getNumer_sali() {
        return numer_sali;
    }

    public void setNumer_sali(Integer numer_sali) {
        this.numer_sali = numer_sali;
    }

    public Integer getNumer_pietra() {
        return numer_pietra;
    }

    public void setNumer_pietra(Integer numer_pietra) {
        this.numer_pietra = numer_pietra;
    }
}
