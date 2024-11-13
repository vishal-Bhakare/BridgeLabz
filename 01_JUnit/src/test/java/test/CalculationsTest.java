package test;

import logics.Calculations;
import org.junit.*;

import java.util.Date;

public class CalculationsTest {

    @BeforeClass
    public static void init() {
        System.out.println("Before Test Cases : " + new Date());
    }

    @Before
    public void beforeEach() {

        System.out.println("Before Each Test Cases " + new Date());
    }

    @Test
    public void addTwoNoTest() {

        int acutalResult = Calculations.addTwoNo(5, 5);
        int expectedResult = 10;

        Assert.assertEquals(expectedResult, acutalResult);
    }

    @Test
    public void mutiplyTwoNoTest() {

        int acutalResult = Calculations.multiTwoNo(5, 5);
        int expectedResult = 25;

        Assert.assertEquals(expectedResult, acutalResult);
    }


    @Test
    public void addNumbersTest() {

        int actualResult = Calculations.addNumbers(2, 3, 4, 5, 4);
        int expectedResult = 18;
        Assert.assertEquals(expectedResult, actualResult);

    }


    @Test
    public void CheckForIsogramTest() {

        Assert.assertEquals(false, Calculations.checkIsogram("GeekForGeek"));
        Assert.assertEquals(true, Calculations.checkIsogram("algorithm"));
        Assert.assertEquals(false, Calculations.checkIsogram("datastructures"));
        Assert.assertEquals(false, Calculations.checkIsogram("machinelearning"));
        Assert.assertEquals(true, Calculations.checkIsogram("importance"));
    }


    @After
    public void afterEach() {
        System.out.println("After Each Test Cases " + new Date());
    }

    @AfterClass
    public static void destroy() {
        System.out.println("After Test Cases  : " + new Date());
    }


}
