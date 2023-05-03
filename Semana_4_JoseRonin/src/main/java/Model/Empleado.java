package Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLEADO_PA")
public class Empleado {
@Column(length = 64, nullable = false)
private String nombre;
    @Column(length = 64, nullable = false)
private String apellido;
@Id @Column(length = 11, nullable = false)
private String cedula;
    @Column(length = 128, nullable = false)
private String email;

    @OneToMany(mappedBy = "empleado")
    private List<Equipo>equipos;

    public Empleado() {
        equipos =new ArrayList<>();
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

    public List<Equipo> getEquipos() {
        if (equipos == null){
            equipos =new ArrayList<>();
        }
        return equipos;
    }
}

