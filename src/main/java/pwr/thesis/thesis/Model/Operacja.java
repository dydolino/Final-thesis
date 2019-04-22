package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
@Table(name = "operacja")
public class Operacja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idOperacja;
    @ManyToOne
    private Pacjent pacjent;
    @OneToOne
    private Egz_choroby egz_choroby;
    @ManyToOne
    private Lekarz lekarz;
    @ManyToOne
    private Sala sala;
    @OneToOne
    private Wydarzenia wydarzenia;

    public Wydarzenia getWydarzenia() {
        return wydarzenia;
    }

    public void setWydarzenia(Wydarzenia wydarzenia) {
        this.wydarzenia = wydarzenia;
    }

    public Integer getIdOperacja() {
        return idOperacja;
    }

    public void setIdOperacja(Integer idOperacja) {
        this.idOperacja = idOperacja;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Egz_choroby getEgz_choroby() {
        return egz_choroby;
    }

    public void setEgz_choroby(Egz_choroby egz_choroby) {
        this.egz_choroby = egz_choroby;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
