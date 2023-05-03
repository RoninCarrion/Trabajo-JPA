package Model;

import javax.persistence.Column;
import java.util.Date;

public class Equipo {
    @Column(length = 1, nullable = false, columnDefinition = "String default M")
    private String rol;
    @Column(name = "FECHA_INGRESO", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaIngreso;

    public Equipo() {;
    }
    public Equipo(String rol, Date fechaIngreso) {
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
}
