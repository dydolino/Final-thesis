package pwr.thesis.thesis.DTOmodel;

import org.springframework.stereotype.Controller;

@Controller
public class OperacjaDTO {

    private String pacjentPESEL;
    private Integer egz_chorobyID;
    private String numerLicencji;
    private Integer numerSali;
    private String Data;
    private String TimeFrom;

    public String getTimeFrom() {
        return TimeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        TimeFrom = timeFrom;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public Integer getNumerSali() {
        return numerSali;
    }

    public void setNumerSali(Integer numerSali) {
        this.numerSali = numerSali;
    }

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
}
