package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

import java.time.Duration;

/*
   DON'T FORGET TO EXTEND FROM THIS CLASS
   All Test classes should extend this class to obtain the common configurations
 */
public class TestBase {

    @BeforeMethod (alwaysRun = true)
    public void setup(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){

      Driver.quitDriver();
    }
}
