package hu.unideb.inf.model;



import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JpaUsersDao implements UsersDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void saveUser(Users a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Users> getUser() {
        TypedQuery<Users> query = entityManager.createQuery( "SELECT a FROM Users a", Users.class);
        List<Users> users = query.getResultList(); return users;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
