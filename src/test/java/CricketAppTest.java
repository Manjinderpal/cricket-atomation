import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketAppTest {
	WebDriver driver;
    String appUrl = "file:///C:/Users/manji/OneDrive/Desktop/cricket.html";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        driver.get(appUrl);
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals(title, "Cricket Score Tracker");
    }

    @Test(priority = 2)
    public void verifyAddRunsTeam1() {
        driver.get(appUrl);
        driver.findElement(By.id("add-runs-team1")).click();
        String score = driver.findElement(
            By.id("team1-score")).getText();
        System.out.println("Team 1 score: " + score);
        Assert.assertEquals(score, "Score: 4");
    }

    @Test(priority = 3)
    public void verifyAddWicketTeam1() {
        driver.get(appUrl);
        driver.findElement(By.id("add-wicket-team1")).click();
        String wickets = driver.findElement(
            By.id("team1-wickets")).getText();
        System.out.println("Wickets: " + wickets);
        Assert.assertEquals(wickets, "Wickets: 1");
    }

    @Test(priority = 4)
    public void verifyResetScores() {
        driver.get(appUrl);
        driver.findElement(By.id("add-runs-team1")).click();
        driver.findElement(By.id("reset-btn")).click();
        String score = driver.findElement(
            By.id("team1-score")).getText();
        System.out.println("Score after reset: " + score);
        Assert.assertEquals(score, "Score: 0");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
