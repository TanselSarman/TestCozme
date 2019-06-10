package com.example.tansel.tezcozme;

/**
 * Created by Tansel on 30.10.2018.
 */

public class Sozluk {
    int id;
    String turkce;
    String ingilizce;

    public Sozluk() {

    }

    public Sozluk(String turkce, String ingilizce) {
        this.turkce = turkce;
        this.ingilizce = ingilizce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        this.turkce = turkce;
    }

    public String getIngilizce() {
        return ingilizce;
    }

    public void setIngilizce(String ingilizce) {
        this.ingilizce = ingilizce;
    }
}
