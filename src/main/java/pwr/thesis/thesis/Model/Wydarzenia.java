package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
@Table(name = "wydarzenia")
public class Wydarzenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idWydarzenia;
    private String godzina_od;
    private String godzina_do;
    @ManyToOne
    private Dzien dzien;
    @OneToOne
    private Operacja operacja;

    public Integer getIdWydarzenia() {
        return idWydarzenia;
    }

    public void setIdWydarzenia(Integer idWydarzenia) {
        this.idWydarzenia = idWydarzenia;
    }

    public String getGodzina_od() {
        return godzina_od;
    }

    public void setGodzina_od(String godzina_od) {
        this.godzina_od = godzina_od;
    }

    public String getGodzina_do() {
        return godzina_do;
    }

    public void setGodzina_do(String godzina_do) {
        this.godzina_do = godzina_do;
    }

    public Dzien getDzien() {
        return dzien;
    }

    public void setDzien(Dzien dzien) {
        this.dzien = dzien;
    }

    public Operacja getOperacja() {
        return operacja;
    }

    public void setOperacja(Operacja operacja) {
        this.operacja = operacja;
    }
}
