package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.sound.sampled.DataLine;
import java.util.List;

public class JpaDailysaleDAO implements DailysaleDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveDailysale(Dailysale a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateDailysale(Dailysale a) {

        saveDailysale(a);

    }

    @Override
    public List<Dailysale> getDailysale() {
        TypedQuery<Dailysale> query = entityManager.createQuery( "SELECT a FROM Dailysale a", Dailysale.class);
        List<Dailysale> dailysales = query.getResultList(); return dailysales;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

}
