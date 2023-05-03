package Model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula")
    private Empleado empleado;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Proyecto proyecto;

    @Column(length = 1, nullable = false, columnDefinition = "String default M")
    private String rol;

    @Column(name = "FECHA_INGRESO", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaIngreso;

    public Equipo() {;
    }
    public Equipo(String rol, Date fechaIngreso ) {
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
    }

    public Equipo(Long id, Empleado empleado, Proyecto proyecto, String rol, Date fechaIngreso) {
        Id = id;
        this.empleado = empleado;
        this.proyecto = proyecto;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public Proyecto getProyecto() {
        return proyecto;
    }
}
