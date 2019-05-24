package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idSala;
    private Integer numerSali;
    private Integer numerPietra;

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public Integer getNumer_sali() {
        return numerSali;
    }

    public void setNumer_sali(Integer numer_sali) {
        this.numerSali = numer_sali;
    }

    public Integer getNumer_pietra() {
        return numerPietra;
    }

    public void setNumer_pietra(Integer numer_pietra) {
        this.numerPietra = numer_pietra;
    }
}
