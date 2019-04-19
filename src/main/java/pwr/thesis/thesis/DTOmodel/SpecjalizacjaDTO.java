package pwr.thesis.thesis.DTOmodel;

import org.springframework.stereotype.Controller;

@Controller
public class SpecjalizacjaDTO {

    private String Nazwa;
    private String Opis;

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }
}
