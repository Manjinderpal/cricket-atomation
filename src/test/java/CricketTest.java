import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CricketTest {

	 WebDriver driver;

	    @BeforeTest
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @Test(priority = 1)
	    public void verifyHomePageTitle() {
	        driver.get("https://www.espncricinfo.com");
	        String title = driver.getTitle();
	        System.out.println("Title: " + title);
	        Assert.assertTrue(title.contains("ESPNcricinfo"));
	    }

	    @Test(priority = 2)
	    public void verifyPageURL() {
	        driver.get("https://www.espncricinfo.com");
	        String url = driver.getCurrentUrl();
	        System.out.println("URL: " + url);
	        Assert.assertTrue(url.contains("espncricinfo"));
	    }

	    @Test(priority = 3)
	    public void verifyScoresPage() {
	        driver.get("https://www.espncricinfo.com/cricket-match/live-cricket-score");
	        String title = driver.getTitle();
	        System.out.println("Scores page title: " + title);
	        Assert.assertNotNull(title);
	    }

	    @AfterTest
	    public void teardown() {
	        driver.quit();
	    }
	}
	