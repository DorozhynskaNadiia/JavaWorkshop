import com.test.pages.CourseRegForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by ndorozhynska on 2/13/2017.
 */
public class SimpleTest {

    static WebDriver driver = null;
    CourseRegForm courseRegForm;

    @BeforeClass
    public void beforeAllClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeEachMethod(){
        driver.get("http://old.qalight.com/zapisatsya-na-kurs/");
        courseRegForm = new CourseRegForm(driver);

        //driver.manage().deleteAllCookies();
    }

    @Test
    public void firstTest(){
        String name = "Ivan";
        String lastName = "Smith";

        courseRegForm.enterNameAndLastName(name, lastName);

        Assert.assertEquals(courseRegForm.getName(), name);
        Assert.assertEquals(courseRegForm.getLastName(), lastName);
    }

    @AfterClass
    public void afterAllClass(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
