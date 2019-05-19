package pwr.thesis.thesis.DTOmodel;

import org.springframework.stereotype.Controller;
import pwr.thesis.thesis.Model.*;

@Controller
public class OperacjaDTO {


    private Pacjent pacjent;
    private Egz_choroby egz_choroby;
    private Lekarz lekarz;
    private Sala sala;
    private Wydarzenia wydarzenia;

    private String pacjentPESEL;
    private Integer egz_chorobyID;
    private String numerLicencji;

    public String getNumerLicencji() {
        return numerLicencji;
    }

    public void setNumerLicencji(String numerLicencji) {
        this.numerLicencji = numerLicencji;
    }

    public Integer getEgz_chorobyID() {
        return egz_chorobyID;
    }

    public void setEgz_chorobyID(Integer egz_chorobyID) {
        this.egz_chorobyID = egz_chorobyID;
    }

    public String getPacjentPESEL() {
        return pacjentPESEL;
    }

    public void setPacjentPESEL(String pacjentPESEL) {
        this.pacjentPESEL = pacjentPESEL;
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

    public Wydarzenia getWydarzenia() {
        return wydarzenia;
    }

    public void setWydarzenia(Wydarzenia wydarzenia) {
        this.wydarzenia = wydarzenia;
    }
}
