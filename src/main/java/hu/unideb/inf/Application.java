package hu.unideb.inf;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hu.unideb.inf.model.*;
import org.h2.tools.Server;

public class Application {


    public static void main() throws SQLException {
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
