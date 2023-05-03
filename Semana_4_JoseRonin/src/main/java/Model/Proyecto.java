package Model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 128)
    private String nombre;
    @Column(nullable = false, columnDefinition = "Double default 1000.00")
    private Double presupuesto;

    public Proyecto() {
    }

    public Proyecto(Integer id, String nombre, Double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
