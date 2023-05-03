package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ctl implements AutoCloseable{

    public static EntityManager em;
    private static Ctl instance = null;

    private Ctl(String puName) {
        em = getEntityManager(puName);
    }

    public static Ctl getInstance(String puName) {
        if(instance == null) {
            instance = new Ctl(puName);
        }
        return instance;
    }

    private EntityManager getEntityManager(String puName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(puName);
        em = emf.createEntityManager();

        return em;
    }

    public EntityManager getEm() {
        return em;
    }


    @Override
    public void close() throws Exception {
        em.close();
    }
}