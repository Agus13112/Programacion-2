package ar.com.cultivos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Cosechas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Date fecha;
    private Double rendimiento;

    @JoinColumn(name = "fk_plantaciones", referencedColumnName = "id", nullable = true)
    @ManyToOne
    private Plantaciones plantacion;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Plantaciones getPlantacion() {
        return plantacion;
    }
    public void setPlantacion(Plantaciones plantacion) {
        this.plantacion = plantacion;
    }

    public Double getRendimiento() {
        return rendimiento;
    }
    public void setRendimiento(Double rendimiento) {
        this.rendimiento = rendimiento;
    }

}
