package hu.unideb.inf;

import java.sql.SQLException;
import java.util.List;

import hu.unideb.inf.model.*;
import org.h2.tools.Server;

public class Application {


    public static void main() throws SQLException {
        startDatabase();


        try(StorageDao sDao = new JpaStorageDAO();){
            if (sDao.getStorage().size() == 0) {
                Storage kifli = new Storage();
                kifli.setName("kifli");
                kifli.setPiece(2);
                sDao.saveItems(kifli);


                Storage virsli = new Storage();
                virsli.setName("Virsli");
                virsli.setPiece(5);
                sDao.saveItems(virsli);
            }



        }catch (Exception e) {
            e.printStackTrace();
        }




        try (AdminsDAO aDAO = new JpaAdminsDao();) {
            if (aDAO.getAdmin().size() == 0)
            {
                Admins admin1 = new Admins();
                admin1.setUsername("Csabi");
                admin1.setPassword("Agora123");
                aDAO.saveAdmin(admin1);

                Admins admin2 = new Admins();
                admin2.setUsername("Nándi");
                admin2.setPassword("Faszaaprojekt");
                aDAO.saveAdmin(admin2);


                Admins admin3 = new Admins();
                admin3.setUsername("Sanyi");
                admin3.setPassword("Sanko0910");
                aDAO.saveAdmin(admin3);



                Admins admin4 = new Admins();
                admin4.setUsername("Peti");
                admin4.setPassword("BEdina0702");
                aDAO.saveAdmin(admin4);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
