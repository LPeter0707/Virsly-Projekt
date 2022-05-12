package mockito_test;

import hu.unideb.inf.model.Users;
import hu.unideb.inf.model.UsersDataReader;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersTest {

    @Mock
    private UsersDataReader usr;
    private Users underTest1, underTest2;

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
        given(usr.getId()).willReturn(4, 6);
        given(usr.getFirstname()).willReturn("Balogh", "Lakatos");
        given(usr.getLastname()).willReturn("Pista", "Szotirisz");
        given(usr.getUsername()).willReturn("pistaba@gmail.com", "ciganyvagyokgmail.com");
        given(usr.getPassword()).willReturn("alma", "farhát");

        underTest1 = Users.scannedUser(usr);
        underTest2 = Users.scannedUser(usr);
        verify(usr, times(2)).getId();
        verify(usr, times(2)).getFirstname();
        verify(usr, times(2)).getLastname();
        verify(usr, times(2)).getUsername();
        verify(usr, times(2)).getPassword();

    }

    @AfterEach //@After
    public void tearDown() {
    }

    @Test
    public void scannedUserTest() {
        UsersDataReader usr = mock(UsersDataReader.class);

        Users pExpected = new Users(4, "Balogh", "Pista", "pistaba@gmail.com", "alma");
        assertEquals(pExpected, underTest1);

        pExpected = new Users(6, "Lakatos", "Szotirisz", "ciganyvagyokgmail.com", "farhát" );
        assertEquals(pExpected, underTest2);
    }

    @Test
    public void containAtShouldReturnTrueForEmail()
    {
        assertTrue(underTest1.getUsername().contains("@"), "email: " +underTest1.getUsername());
        //assertTrue(underTest2.getUsername().contains("@"), "email: " +underTest2.getUsername());
    }

    @Test
    public void toStringShouldReturnThisString()
    {
        String expected  = "User{" + "id=" + 6 + ", firstname=" + "Lakatos" + ", lastname=" + "Szotirisz" + ", username=" + "ciganyvagyokgmail.com" + ", password=" + "farhát" + '}';
        Assertions.assertEquals(expected, underTest2.toString());
    }

    @Test
    public void startWithCapitalLetterShouldReturnTrueForFirstname()
    {
        String firstname = underTest1.getFirstname();
        assertTrue(Character.isUpperCase(firstname.charAt(0)));
    }

    @Test
    public void startWithCapitalLetterShouldReturnTrueForLastname()
    {
        String firstname = underTest2.getFirstname();
        assertTrue(Character.isUpperCase(firstname.charAt(0)));
    }

    @Test
    public void UsersConstructorShouldThrowExceptionForWrongID() {
        Assertions.assertThrows(Exception.class, () -> {
            new Users(-10, "Jóska", "Pista", "jóskapista@gmail.com", "jóskavagyok");
        });
    }
}