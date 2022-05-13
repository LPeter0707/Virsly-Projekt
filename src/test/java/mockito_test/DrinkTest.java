package mockito_test;

import hu.unideb.inf.model.Drink;
import hu.unideb.inf.model.DrinkDataReader;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class DrinkTest {

    @Mock
    private DrinkDataReader drink;
    private Drink underTest1, underTest2;

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
        given(drink.getName()).willReturn("Vizecske mizecske", "Húgy");
        given(drink.getPrice()).willReturn(1, 9999);


        underTest1 = Drink.scannedDrink(drink);
        underTest2 = Drink.scannedDrink(drink);
        verify(drink, times(2)).getName();
        verify(drink, times(2)).getPrice();
    }

    @AfterEach //@After
    public void tearDown() {
    }

    @Test
    public void scannedDrinkTest() {
        DrinkDataReader usr = mock(DrinkDataReader.class);

        Drink pExpected = new Drink("Vizecske mizecske", 1);
        assertEquals(pExpected, underTest1);

        pExpected = new Drink("Húgy", 9999);
        assertEquals(pExpected, underTest2);
    }

    @Test
    public void toStringShouldReturnThisString()
    {
        String expected  = "Drink{" + "name=" + "Vizecske mizecske" + ", price=" + 1 + '}';
        Assertions.assertEquals(expected, underTest1.toString());
    }

    @Test
    public void getPriceShouldReturnTrueForPositiveNumber()
    {
        assertTrue(underTest1.getPrice() > 0);
    }
}