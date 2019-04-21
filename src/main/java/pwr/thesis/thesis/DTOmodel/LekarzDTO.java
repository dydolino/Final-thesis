package pwr.thesis.thesis.DTOmodel;

import org.springframework.stereotype.Controller;
import pwr.thesis.thesis.Model.Specjalizacja;

@Controller
public class LekarzDTO {

    private String Imie;
    private String Nazwisko;
    private String numerLicencji;
    private Specjalizacja specjalizacja;
    private String NazwaSpecjalizacji;
    private String OpisSpecjalizacji;

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

    public String getNumerLicencji() {
        return numerLicencji;
    }

    public void setNumerLicencji(String numerLicencji) {
        this.numerLicencji = numerLicencji;
    }

    public String getNazwaSpecjalizacji() {
        return NazwaSpecjalizacji;
    }

    public void setNazwaSpecjalizacji(String nazwaSpecjalizacji) {
        NazwaSpecjalizacji = nazwaSpecjalizacji;
    }

    public String getOpisSpecjalizacji() {
        return OpisSpecjalizacji;
    }

    public void setOpisSpecjalizacji(String opisSpecjalizacji) {
        OpisSpecjalizacji = opisSpecjalizacji;
    }

    public Specjalizacja getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(Specjalizacja specjalizacja) {
        this.specjalizacja = specjalizacja;
    }
}
