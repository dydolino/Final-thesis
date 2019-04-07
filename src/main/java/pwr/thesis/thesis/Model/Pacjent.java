package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
@Table(name = "pacjent")
public class Pacjent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idPacjent;
    private String Imie;
    private String Nazwisko;
    private String PESEL;

    public Integer getIdPacjent() {
        return idPacjent;
    }

    public void setIdPacjent(Integer idPacjent) {
        this.idPacjent = idPacjent;
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

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
}
