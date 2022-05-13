package mockito_test;

import hu.unideb.inf.model.Storage;
import hu.unideb.inf.model.StorageDataReader;
import hu.unideb.inf.model.Users;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class StorageTest {

    @Mock
    private StorageDataReader str;
    private Storage underTest1, underTest2;

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
        given(str.getId()).willReturn(1, 2);
        given(str.getName()).willReturn("Kifli", "Virsli");
        given(str.getPiece()).willReturn(10, 10);

        underTest1 = Storage.scannedMaterial(str);
        underTest2 = Storage.scannedMaterial(str);
        verify(str, times(2)).getId();
        verify(str, times(2)).getName();
        verify(str, times(2)).getPiece();
    }

    @AfterEach //@After
    public void tearDown() {
    }

    @Test
    public void scannedMaterialTest() {
        StorageDataReader str = mock(StorageDataReader.class);

        Storage pExpected = new Storage(1, "Kifli", 10);
        assertEquals(pExpected, underTest1);

        pExpected = new Storage(2, "Virsli", 10);
        assertEquals(pExpected, underTest2);
    }

    @Test
    public void toStringShouldReturnThisString()
    {
        String expected  = "Storage{" + "id=" + 2 + ", name=" + "Virsli" + ", piece=" + 10 + '}';
        Assertions.assertEquals(expected, underTest2.toString());
    }

    @Test
    public void StorageConstructorShouldThrowExceptionForWrongID() {
        Assertions.assertThrows(Exception.class, () -> {
            new Storage(-10, "Virsli", 10);
        });
    }

    @Test
    public void startWithCapitalLetterShouldReturnTrueForName()
    {
        String firstname = underTest2.getName();
        assertTrue(Character.isUpperCase(firstname.charAt(0)));
    }

    @Test
    public void getIdShouldReturnTrueForPositiveNumber()
    {
        assertTrue(underTest1.getPiece() > 0);
    }
}
