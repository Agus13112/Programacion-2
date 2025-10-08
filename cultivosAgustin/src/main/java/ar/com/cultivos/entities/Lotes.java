package ar.com.cultivos.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Lotes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descrip;
    private Double sup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Double getSup() {
        return sup;
    }

    public void setSup(Double sup) {
        this.sup = sup;
    }
}
