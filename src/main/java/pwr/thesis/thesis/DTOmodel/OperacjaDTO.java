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
    private Integer idOperacjii;

    public OperacjaDTO() {
    }

    public OperacjaDTO(String pacjentPESEL, Integer egz_chorobyID, String numerLicencji, Integer numerSali, String data, String timeFrom) {
        this.pacjentPESEL = pacjentPESEL;
        this.egz_chorobyID = egz_chorobyID;
        this.numerLicencji = numerLicencji;
        this.numerSali = numerSali;
        this.Data = data;
        TimeFrom = timeFrom;
    }

    public OperacjaDTO(String pacjentPESEL, Integer egz_chorobyID, String numerLicencji, Integer numerSali, String data, String timeFrom, Integer idOperacjii) {
        this.pacjentPESEL = pacjentPESEL;
        this.egz_chorobyID = egz_chorobyID;
        this.numerLicencji = numerLicencji;
        this.numerSali = numerSali;
        this.Data = data;
        TimeFrom = timeFrom;
        this.idOperacjii = idOperacjii;
    }

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
        this.Data = data;
    }

    public Integer getIdOperacjii() {
        return idOperacjii;
    }

    public void setIdOperacjii(Integer idOperacjii) {
        this.idOperacjii = idOperacjii;
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
