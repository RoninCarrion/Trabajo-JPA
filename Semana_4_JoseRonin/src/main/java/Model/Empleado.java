package Model;
import javax.persistence.*;
@Entity
public class Empleado {
@Column(length = 64, nullable = false)
private String nombre;
    @Column(length = 64, nullable = false)
private String apellido;
@Id @Column(length = 11, nullable = false)
private String cedula;
    @Column(length = 128, nullable = false)
private String email;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String cedula, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

