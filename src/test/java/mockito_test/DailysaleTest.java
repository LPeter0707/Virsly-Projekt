package mockito_test;

import hu.unideb.inf.model.Dailysale;
import hu.unideb.inf.model.DailysaleDataReader;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class DailysaleTest {

    @Mock
    private DailysaleDataReader dailysale;
    private Dailysale underTest1, underTest2;

    @BeforeAll //@BeforeClass
    public static void setUpClass() {
    }

    @AfterAll //@AfterClass
    public static void tearDownClass() {
    }

    @BeforeEach //@Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        given(dailysale.getId()).willReturn(12, 120);
        given(dailysale.getName()).willReturn("Kaga", "Húgy");
        given(dailysale.getCount()).willReturn(69, 420);


        underTest1 = Dailysale.scannedDailysale(dailysale);
        underTest2 = Dailysale.scannedDailysale(dailysale);
        verify(dailysale, times(2)).getId();
        verify(dailysale, times(2)).getName();
        verify(dailysale, times(2)).getCount();
    }

    @AfterEach //@After
    public void tearDown() {
    }

    @Test
    public void scannedDailysaleTest() {
        Dailysale pExpected = new Dailysale(12, "Kaga", 69);
        assertEquals(pExpected, underTest1);

        pExpected = new Dailysale(120, "Húgy", 420);
        assertEquals(pExpected, underTest2);
    }

    @Test
    public void toStringShouldReturnThisString() {
        String expected = "Dailysale{" + "id=" + 12 + ", name=" + "Kaga" + ", count=" + 69 + '}';
        Assertions.assertEquals(expected, underTest1.toString());
    }

    @Test
    public void getCountShouldReturnTrueForPositiveNumber() {
        assertTrue(underTest1.getCount() >= 0);
    }

    @Test
    public void getIdShouldReturnTrueForPositiveNumber()
    {
        assertTrue(underTest1.getId() > 0);
    }
}