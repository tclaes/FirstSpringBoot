package be.vdab.FirstSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lens;
    private int aantalMpx;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public int getAantalMpx() {
        return aantalMpx;
    }

    public void setAantalMpx(int aantalMpx) {
        this.aantalMpx = aantalMpx;
    }
}
