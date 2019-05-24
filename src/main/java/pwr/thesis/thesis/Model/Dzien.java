package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
@Table(name = "dzien")
public class Dzien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idDzien;
    private Integer numerDnia;
    @ManyToOne
    private Miesiac miesiac;

    public Dzien() {
    }

    public Dzien(Integer numerDnia, Miesiac miesiac) {
        this.numerDnia = numerDnia;
        this.miesiac = miesiac;
    }

    public Integer getIdDzien() {
        return idDzien;
    }

    public void setIdDzien(Integer idDzien) {
        this.idDzien = idDzien;
    }

    public Miesiac getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(Miesiac miesiac) {
        this.miesiac = miesiac;
    }

    public Integer getNumerDnia() {
        return numerDnia;
    }

    public void setNumerDnia(Integer numerDnia) {
        this.numerDnia = numerDnia;
    }
}
