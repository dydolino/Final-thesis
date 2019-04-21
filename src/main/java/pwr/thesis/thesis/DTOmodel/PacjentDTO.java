package pwr.thesis.thesis.DTOmodel;

import org.springframework.stereotype.Controller;

@Controller
public class PacjentDTO {

    public PacjentDTO() {
    }

    public PacjentDTO(String imie, String nazwisko, String PESEL) {
        Imie = imie;
        Nazwisko = nazwisko;
        this.PESEL = PESEL;
    }

    private String Imie;
    private String Nazwisko;
    private String PESEL;

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
}
