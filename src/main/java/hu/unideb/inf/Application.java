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
                kifli.setName("Hot Dog kifli");
                kifli.setPiece(2);
                sDao.saveItems(kifli);

                Storage virsli = new Storage();
                virsli.setName("Virsli");
                virsli.setPiece(5);
                sDao.saveItems(virsli);

                Storage grill_kolbasz = new Storage();
                grill_kolbasz.setName("Grill kolbász");
                grill_kolbasz.setPiece(5);
                sDao.saveItems(grill_kolbasz);

                Storage debreceni_paros = new Storage();
                debreceni_paros.setName("Debreceni páros");
                debreceni_paros.setPiece(5);
                sDao.saveItems(debreceni_paros);

                Storage kacsa_kolbasz = new Storage();
                kacsa_kolbasz.setName("Kacsa kolbász");
                kacsa_kolbasz.setPiece(5);
                sDao.saveItems(kacsa_kolbasz);

                Storage mangalica_hurka = new Storage();
                mangalica_hurka.setName("Mangalica hurka");
                mangalica_hurka.setPiece(5);
                sDao.saveItems(mangalica_hurka);

                Storage barany_marha_kolbasz = new Storage();
                barany_marha_kolbasz.setName("Bárány-marha kolbász");
                barany_marha_kolbasz.setPiece(5);
                sDao.saveItems(barany_marha_kolbasz);

                Storage cheddar_szosz = new Storage();
                cheddar_szosz.setName("Cheddar szósz");
                cheddar_szosz.setPiece(5);
                sDao.saveItems(cheddar_szosz);

                Storage piritott_hagyma = new Storage();
                piritott_hagyma.setName("Piritott hagyma");
                piritott_hagyma.setPiece(5);
                sDao.saveItems(piritott_hagyma);

                Storage torilla_chips = new Storage();
                torilla_chips.setName("Tortilla chips");
                torilla_chips.setPiece(5);
                sDao.saveItems(torilla_chips);

                Storage bacon = new Storage();
                bacon.setName("Bacon");
                bacon.setPiece(5);
                sDao.saveItems(bacon);

                Storage uborka = new Storage();
                uborka.setName("Uborka");
                uborka.setPiece(5);
                sDao.saveItems(uborka);

                Storage sushi_gyomber = new Storage();
                sushi_gyomber.setName("Sushi gyömbér");
                sushi_gyomber.setPiece(5);
                sDao.saveItems(sushi_gyomber);

                Storage jalapeno = new Storage();
                jalapeno.setName("Jalapeno");
                jalapeno.setPiece(5);
                sDao.saveItems(jalapeno);

                Storage paradicsom = new Storage();
                paradicsom.setName("Paradicsom");
                paradicsom.setPiece(5);
                sDao.saveItems(paradicsom);

                Storage feta = new Storage();
                feta.setName("Feta");
                feta.setPiece(5);
                sDao.saveItems(feta);

                Storage hagyma = new Storage();
                hagyma.setName("Hagyma");
                hagyma.setPiece(5);
                sDao.saveItems(hagyma);

                Storage kukorica = new Storage();
                kukorica.setName("Kukorica");
                kukorica.setPiece(5);
                sDao.saveItems(kukorica);

                Storage bab = new Storage();
                bab.setName("Bab");
                bab.setPiece(5);
                sDao.saveItems(bab);

                Storage mexikoi_salsa = new Storage();
                mexikoi_salsa.setName("Mexikói salsa");
                mexikoi_salsa.setPiece(5);
                sDao.saveItems(mexikoi_salsa);

                Storage zolsegmix = new Storage();
                zolsegmix.setName("Házi zöldség mix");
                zolsegmix.setPiece(5);
                sDao.saveItems(zolsegmix);

                Storage ketchup = new Storage();
                ketchup.setName("Ketchup");
                ketchup.setPiece(5);
                sDao.saveItems(ketchup);

                Storage majonez = new Storage();
                majonez.setName("Majonéz");
                majonez.setPiece(5);
                sDao.saveItems(majonez);

                Storage mustar = new Storage();
                mustar.setName("Mustár");
                mustar.setPiece(5);
                sDao.saveItems(mustar);

                Storage szoja_szosz = new Storage();
                szoja_szosz.setName("Szója szósz");
                szoja_szosz.setPiece(5);
                sDao.saveItems(szoja_szosz);

                Storage magyaroskrem = new Storage();
                magyaroskrem.setName("Magyaroskrém");
                magyaroskrem.setPiece(5);
                sDao.saveItems(magyaroskrem);

                Storage padlizsankrem = new Storage();
                padlizsankrem.setName("Padlizsánkrém");
                padlizsankrem.setPiece(5);
                sDao.saveItems(padlizsankrem);

                Storage wasabi = new Storage();
                wasabi.setName("Wasabi");
                wasabi.setPiece(5);
                sDao.saveItems(wasabi);
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
