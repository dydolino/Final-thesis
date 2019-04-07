package pwr.thesis.thesis.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "choroby")
public class Choroby {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long idChoroby;
    private String nazwa;
    private int Waga_choroby;
    private double Dlugosc_operacji;

    public Long getIdChoroby() {
        return idChoroby;
    }

    public void setIdChoroby(Long idChoroby) {
        this.idChoroby = idChoroby;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
