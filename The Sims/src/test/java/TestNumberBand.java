import org.Arcade.NumberBand.RunNumberBand;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNumberBand {
    @BeforeMethod
    public void BeforeNumberBand(){
        System.out.println("This is the test for NumberBand");
    }
    @Test
    public void NumberBand(){
        RunNumberBand numberBand = new RunNumberBand();
        numberBand.numberBand();
    }
    @AfterMethod
    public void AfterNumberBand(){
        System.out.println("The test for NumberBand has ended.");
    }
}
