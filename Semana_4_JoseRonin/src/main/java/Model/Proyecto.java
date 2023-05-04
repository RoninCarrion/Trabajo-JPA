package Model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROYECTO_PA")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 128)
    private String nombre;
    @Column(nullable = false, columnDefinition = "Double default 1000.00")
    private Double presupuesto;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    public List<Equipo> equipos1;

    public Proyecto() {
        equipos1 = new ArrayList<>();
    }

    public Proyecto(String nombre, Double presupuesto) {
        this();
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

    public List<Equipo> getEquipos1() {
        return equipos1;
    }
}
