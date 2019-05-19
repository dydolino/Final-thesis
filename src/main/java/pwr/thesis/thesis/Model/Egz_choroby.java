package pwr.thesis.thesis.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "egz_choroby")
public class Egz_choroby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id_egz_choroby")
    private Integer idEgz_choroby;
    @ManyToOne
    private Choroby choroby;
    private LocalDateTime data_rozpoznania;
    @ManyToOne
    private Pacjent pacjent;

    public Integer getIdEgz_choroby() {
        return idEgz_choroby;
    }

    public void setIdEgz_choroby(Integer idEgz_choroby) {
        this.idEgz_choroby = idEgz_choroby;
    }

    public Choroby getChoroby() {
        return choroby;
    }

    public void setChoroby(Choroby choroby) {
        this.choroby = choroby;
    }

    public LocalDateTime getData_rozpoznania() {
        return data_rozpoznania;
    }

    public void setData_rozpoznania(LocalDateTime data_rozpoznania) {
        this.data_rozpoznania = data_rozpoznania;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }
}
