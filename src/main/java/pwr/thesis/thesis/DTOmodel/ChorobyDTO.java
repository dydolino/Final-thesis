package pwr.thesis.thesis.DTOmodel;


public class ChorobyDTO {
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
