package pwr.thesis.thesis.DTOmodel;

import org.springframework.stereotype.Controller;

@Controller
public class ChorobyDTO {

    public ChorobyDTO() {
    }

    public ChorobyDTO(String nazwa, int wagaChoroby, double dlugoscOperacji) {
        this.nazwa = nazwa;
        this.wagaChoroby = wagaChoroby;
        this.dlugoscOperacji = dlugoscOperacji;
    }

    private String nazwa;
    private  int wagaChoroby;
    private double dlugoscOperacji;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getWagaChoroby() {
        return wagaChoroby;
    }

    public void setWagaChoroby(int wagaChoroby) {
        this.wagaChoroby = wagaChoroby;
    }

    public double getDlugoscOperacji() {
        return dlugoscOperacji;
    }

    public void setDlugoscOperacji(double dlugoscOperacji) {
        this.dlugoscOperacji = dlugoscOperacji;
    }
}
