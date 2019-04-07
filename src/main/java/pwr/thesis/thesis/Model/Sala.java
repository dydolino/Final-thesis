package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idSala;
    private Integer numer_sali;
    private Integer numer_pietra;

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public Integer getNumer_sali() {
        return numer_sali;
    }

    public void setNumer_sali(Integer numer_sali) {
        this.numer_sali = numer_sali;
    }

    public Integer getNumer_pietra() {
        return numer_pietra;
    }

    public void setNumer_pietra(Integer numer_pietra) {
        this.numer_pietra = numer_pietra;
    }
}
