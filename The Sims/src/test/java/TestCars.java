import org.CarShop.Cars;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCars {
    @BeforeTest
    public void BeforeTest(){
        System.out.println("Here we are verifying the accuracy of each car's price.");
    }
    Cars cars = new Cars();
    @Test
    public void TestO(){
        int value = cars.getValue(3);
        Assert.assertEquals(value,400000);
    }
    @Test
    public void TestT(){
        int value = cars.getValue(4);
        Assert.assertEquals(value,500000);
    }
    @Test
    public void TestV(){
        int value = cars.getValue(2);
        Assert.assertEquals(value,300000);
    }
    @Test
    public void TestM(){
        int value = cars.getValue(1);
        Assert.assertEquals(value,200000);
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("Test completed.");
    }
}
