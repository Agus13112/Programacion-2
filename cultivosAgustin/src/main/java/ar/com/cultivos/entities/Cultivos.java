package ar.com.cultivos.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cultivos")  // Opcional: si el nombre de tabla difiere de la clase
public class Cultivos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String descrip;

    // Constructores
    public Cultivos() {
    }

    public Cultivos(String descrip) {
        this.descrip = descrip;
    }

    // Getters y Setters
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

    // Método toString()
    @Override
    public String toString() {
        return "Cultivo [id=" + id + ", descrip=" + descrip + "]";
    }
}