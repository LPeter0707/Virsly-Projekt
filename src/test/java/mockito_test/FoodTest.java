package mockito_test;

import hu.unideb.inf.model.Food;
import hu.unideb.inf.model.FoodDataReader;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class FoodTest {

    @Mock
    private FoodDataReader food;
    private Food underTest1, underTest2;

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
        given(food.getName()).willReturn("Hot Dog", "Virslis tutaj");
        given(food.getList()).willReturn(List.of("virsli, kifli, ketchup, mustár"), List.of("virsli, kifli, sajt, ketchup"));
        given(food.getPrice()).willReturn(700, 400);


        underTest1 = Food.scannedFood(food);
        underTest2 = Food.scannedFood(food);
        verify(food, times(2)).getName();
        verify(food, times(2)).getList();
        verify(food, times(2)).getPrice();
    }

    @AfterEach //@After
    public void tearDown() {
    }

    @Test
    public void scannedFoodTest() {
        FoodDataReader usr = mock(FoodDataReader.class);

        Food pExpected = new Food("Hot Dog", List.of("virsli, kifli, ketchup, mustár"), 700);
        assertEquals(pExpected, underTest1);

        pExpected = new Food("Virslis tutaj", List.of("virsli, kifli, sajt, ketchup"), 400);
        assertEquals(pExpected, underTest2);
    }

    @Test
    public void toStringShouldReturnThisString()
    {
        String expected  = "Food{" + "name=" + "Virslis tutaj" + ", list=" + List.of("virsli, kifli, sajt, ketchup") + ", price=" + 400 + '}';
        Assertions.assertEquals(expected, underTest2.toString());
    }

    @Test
    public void getPriceShouldReturnTrueForPositiveNumber()
    {
        assertTrue(underTest1.getPrice() > 0);
    }

    @Test
    public void getListElemsShouldReturnTrueForThisList()
    {
        List<String> testlist = new ArrayList<>(List.of("virsli, kifli, ketchup, mustár"));
        for (int i = 0; i < testlist.size(); i++)
        {
            String listelem = underTest1.getList().get(i);
            String testlistelem = testlist.get(i);
            assertTrue(listelem.equals(testlistelem));
        }
    }
}
