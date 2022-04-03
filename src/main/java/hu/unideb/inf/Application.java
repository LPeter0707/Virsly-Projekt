package hu.unideb.inf;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hu.unideb.inf.model.Users;
import hu.unideb.inf.model.JpaUsersDao;
import hu.unideb.inf.model.Users;
import hu.unideb.inf.model.UsersDAO;
import org.h2.tools.Server;

public class Application {


    public static void main() throws SQLException {
        startDatabase();

        //try-with-resources

   /*   Exercise 1
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer = new Customer();
        customer.setFirstName("Dennys");
        customer.setLastName("Fredericci");

        Animal elephant = new Animal();
        elephant.setName("Nelly");
        elephant.setAge(10);
        elephant.setGender(Animal.GenderType.FEMALE);

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.persist(elephant);
        entityManager.getTransaction().commit();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");
*/
    }

    public static void handleData(UsersDAO aDAO){
        Users a = new Users();
        a.setUsername("Szabosandor");
        a.setPassword("Sanko0910");
        aDAO.saveUser(a);

        Users b = new Users();
        b.setUsername("Nagycsacsa");
        b.setPassword("Agora12345");
        aDAO.saveUser(b);


    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
