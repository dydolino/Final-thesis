package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
public class Lekarz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idLekarz;
    private String Imie;
    private String Nazwisko;
    private String numerLicencji;
    @ManyToOne
    private Specjalizacja specjalizacja;

    public Integer getIdLekarz() {
        return idLekarz;
    }

    public void setIdLekarz(Integer idLekarz) {
        this.idLekarz = idLekarz;
    }

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

    public Specjalizacja getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(Specjalizacja specjalizacja) {
        this.specjalizacja = specjalizacja;
    }
}
