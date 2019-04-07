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
    private Sala sala;

    public Integer getIdDzien() {
        return idDzien;
    }

    public void setIdDzien(Integer idDzien) {
        this.idDzien = idDzien;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Integer getNumerDnia() {
        return numerDnia;
    }

    public void setNumerDnia(Integer numerDnia) {
        this.numerDnia = numerDnia;
    }
}
