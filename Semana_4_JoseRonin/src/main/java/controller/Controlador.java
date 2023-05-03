package controller;

import Model.Empleado;
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


    public void close() {
        em.close();
    }
}
