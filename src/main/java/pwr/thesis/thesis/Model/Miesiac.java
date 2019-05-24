package pwr.thesis.thesis.Model;

import javax.persistence.*;

@Entity
@Table(name = "miesiac")
public class Miesiac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer idMiesiac;
    private Integer numerMiesiaca;
    @ManyToOne
    private Sala sala;

    public Miesiac() {
    }

    public Miesiac(Integer numerMiesiaca, Sala sala) {
        this.numerMiesiaca = numerMiesiaca;
        this.sala = sala;
    }

    public Integer getIdMiesiac() {
        return idMiesiac;
    }

    public void setIdMiesiac(Integer idMiesiac) {
        this.idMiesiac = idMiesiac;
    }

    public Integer getNumerMiesiaca() {
        return numerMiesiaca;
    }

    public void setNumerMiesiaca(Integer numerMiesiaca) {
        this.numerMiesiaca = numerMiesiaca;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
