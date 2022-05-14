package mockito_test;

import hu.unideb.inf.model.Admins;
import hu.unideb.inf.model.AdminsDataReader;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class AdminsTest {

    @Mock
    private AdminsDataReader admin;
    private Admins underTest1, underTest2;

    @BeforeAll //@BeforeClass
    public static void setUpClass() {
    }

    @AfterAll //@AfterClass
    public static void tearDownClass() {
    }

    @BeforeEach //@Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        //PersonDataReader pdr = mock(PersonDataReader.class);
        given(admin.getId()).willReturn(4, 6);
        given(admin.getUsername()).willReturn("admin123@gmail.com", "admingmail.com");
        given(admin.getPassword()).willReturn("admin@", "123456789$");

        underTest1 = Admins.scannedAdmin(admin);
        underTest2 = Admins.scannedAdmin(admin);
        verify(admin, times(2)).getId();
        verify(admin, times(2)).getUsername();
        verify(admin, times(2)).getPassword();

    }

    @AfterEach //@After
    public void tearDown() {
    }

    @Test
    public void scannedAdminTest() {
        AdminsDataReader admin = mock(AdminsDataReader.class);

        Admins pExpected = new Admins(4,"admin123@gmail.com", "admin@");
        assertEquals(pExpected, underTest1);

        pExpected = new Admins(6, "admingmail.com", "123456789$" );
        assertEquals(pExpected, underTest2);
    }

    @Test
    public void containAtShouldReturnTrueForAdminEmail()
    {
        assertTrue(underTest1.getUsername().contains("@"), "email: " +underTest1.getUsername());
        //assertTrue(underTest2.getUsername().contains("@"), "email: " +underTest2.getUsername());
    }

    @Test
    public void AdminsConstructorShouldThrowExceptionForWrongID() {
        Assertions.assertThrows(Exception.class, () -> {
            new Admins(-2, "admin123@gmail.com", "admin");
        });
    }

    @Test
    public void toStringShouldReturnThisString()
    {
        String expected  = "Admin{" + "id=" + 6 + ", username=" + "admingmail.com" + ", password=" + "123456789$" + '}';
        Assertions.assertEquals(expected, underTest2.toString());
    }

    @Test
    public void PasswordShouldContainSpecialCharacter()
    {
        String[] spec = {"!", "%", "@", "#", "$", "*"};
        boolean contains = false;
        for (String s : spec) {
            if (underTest1.getPassword().contains(s)) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);
    }
}
