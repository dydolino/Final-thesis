package pwr.thesis.thesis.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Choroby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idChoroby;
    private String nazwa_choroby;
    private int Waga_choroby;
    private double Dlugosc_operacji;

    public int getIdChoroby() {
        return idChoroby;
    }

    public void setIdChoroby(int idChoroby) {
        this.idChoroby = idChoroby;
    }

    public String getNazwa_choroby() {
        return nazwa_choroby;
    }

    public void setNazwa_choroby(String nazwa_choroby) {
        this.nazwa_choroby = nazwa_choroby;
    }

    public int getWaga_choroby() {
        return Waga_choroby;
    }

    public void setWaga_choroby(int waga_choroby) {
        Waga_choroby = waga_choroby;
    }

    public double getDlugosc_operacji() {
        return Dlugosc_operacji;
    }

    public void setDlugosc_operacji(double dlugosc_operacji) {
        Dlugosc_operacji = dlugosc_operacji;
    }


}
