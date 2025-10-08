package ar.com.cultivos.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Gasto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_plantacion", referencedColumnName = "id", nullable = false)
    private Plantaciones plantacion;

    @Column(nullable = false, length = 200)
    private String concepto;

    @Column(nullable = false)
    private Integer unidades;  // Se asume que es positivo (validar en otra capa)

    @Column(nullable = false)
    private Integer precio;    // Se asume que es no negativo (validar en otra capa)

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

    public Plantaciones getPlantacion() {
        return plantacion;
    }

    public void setPlantacion(Plantaciones plantacion) {
        this.plantacion = plantacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    // Getters y setters (generados normalmente)...
}