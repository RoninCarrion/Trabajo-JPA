package controller;

import Model.Ctl;
import Model.Empleado;
import Model.Proyecto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Controlador {
    public static void main(String[] args) throws Exception{

        try(Ctl ctl = Ctl.getInstance("pu-pa")) {

            addData();
            presentarData();

        }

    }
    private static EntityManager em = null;

    public Controlador() {
        getEm("pu-pa");
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
        for(var pj : qryProyecto.getResultList()) {
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
            for(var et: pj.getEquipos1()) {
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
