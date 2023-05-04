package Model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "EQUIPO")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula")
    private Empleado empleado;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLEADO_CEDULA")
    private Proyecto proyecto;

    @Column(length = 1, nullable = false, columnDefinition = "String default M")
    private String rol;

    @Column(name = "FECHA_INGRESO", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaIngreso;

    public Equipo() {

    }
    public Equipo(String rol, Empleado empleado, Proyecto proyecto) {
        this.rol = rol;
        this.proyecto = proyecto;
        this.empleado = empleado;
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

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
