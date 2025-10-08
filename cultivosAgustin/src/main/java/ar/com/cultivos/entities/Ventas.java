package ar.com.cultivos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Ventas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private Double cantvendida;
    private Double precio;

    @JoinColumn(name = "fk_plantaciones", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Plantaciones plantacion;

    @JoinColumn(name = "fk_compradores", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Compradores comprador;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCantvendida() {
        return cantvendida;
    }
    public void setCantvendida(Double cantvendida) {
        this.cantvendida = cantvendida;
    }

    public Plantaciones getPlantacion() {
        return plantacion;
    }
    public void setPlantacion(Plantaciones plantacion) {
        this.plantacion = plantacion;
    }

    public Compradores getComprador() {
        return comprador;
    }
    public void setComprador(Compradores comprador) {
        this.comprador = comprador;
    }
}
