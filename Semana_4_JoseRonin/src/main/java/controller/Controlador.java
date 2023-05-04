package controller;

import Model.Ctl;
import Model.Empleado;
import Model.Equipo;
import Model.Proyecto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Controlador {
    private static EntityManager em = null;
    public Controlador() {
        getEm("pu-pa");
    }
    public static void main(String[] args) throws Exception {

        try (Ctl ctl = Ctl.getInstance("pu-pa")) {

            addData();
            presentarData();

        }
    }
        private static void addData() throws Exception{
            List<Empleado> empleado1 = List.of(
                    new Empleado("Juan", "Pérez", "2435234545", "jp2124@example.com"),
                    new Empleado("María", "García", "2456456767", "mariagarcia@example.com"),
                    new Empleado("Pedro", "Sánchez", "1634737734", "pedrosanchez@example.com"));

            List<Empleado> empleado2 = List.of(
                    new Empleado("2354698734", "Ana", "Martínez", "anamartinez@example.com"),
            new Empleado("1029384065", "Luis", "González", "luisgonzalez@example.com"),
            new Empleado("11235uo276", "Laura", "Fernández", "laurafernandez@example.com"));

            Proyecto p1 = new Proyecto("ProyectoX", 1212154.3);
            Proyecto p2 = new Proyecto("Bresh", 1548854.3);


            for (var a : empleado1) {
                p1.getEquipos1().add(new Equipo("M", a, p1));
            }

            for (var a : empleado2) {
                p2.getEquipos1().add(new Equipo("D", a, p2));
            }


            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();


        }







    private void getEm(String puName) {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(puName);
            em = emf.createEntityManager();
        }
    }

    public List<Empleado> getAllData() {
        List<Empleado> output = null;

        TypedQuery<Empleado> qry =
                em.createQuery("SELECT r FROM Empleado r", Empleado.class);
        output = qry.getResultList();

        return output;
    }

    public boolean addEmpleado(Empleado empleado) {

        em.getTransaction().begin();
        em.persist(empleado);
        em.flush();
        em.getTransaction().commit();

        return true;
    }

    public boolean addProyecto(Proyecto proyecto) {
        em.getTransaction().begin();
        em.persist(proyecto);
        em.flush();
        em.getTransaction().commit();

        return true;
    }

    private static void presentarData() {
        TypedQuery<Proyecto> qryProyecto = em.createQuery("SELECT c FROM Proyecto c", Proyecto.class);
        for (var pj : qryProyecto.getResultList()) {
            System.out.println("====================================================================================");
            System.out.printf("Proyecto: %s%n", pj.getNombre());
            System.out.printf("Creditos: %d%n", pj.getPresupuesto());
            System.out.printf("%s\t%s\t%s\t%s\t%s%n",
                    "Cedula",
                    "Apellidos",
                    "Nombres",
                    "E-Mail",
                    "Rol");
            System.out.println("------------------------------------------------------------------------------------");
            for (var et : pj.getEquipos1()) {
                System.out.printf("%s\t%s\t%s\t%s\t%%n",
                        et.getEmpleado().getCedula(),
                        et.getEmpleado().getApellido(),
                        et.getEmpleado().getNombre(),
                        et.getEmpleado().getEmail(),
                        et.getEmpleado());
            }
        }
    }


    public void close() throws Exception {
        em.close();
    }
}
