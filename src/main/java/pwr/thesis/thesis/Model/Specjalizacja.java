package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
public class Specjalizacja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idSpecjalizacja;
    private String Nazwa;
    private String Opis;

    public Integer getIdSpecjalizacja() {
        return idSpecjalizacja;
    }

    public void setIdSpecjalizacja(Integer idSpecjalizacja) {
        this.idSpecjalizacja = idSpecjalizacja;
    }

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
