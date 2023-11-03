import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class MainTest {
    @Test
    public void TC_01(){
        //WebDriver
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.guru99.com");
        webDriver.manage().window().maximize();

        String[] subMenuNames = {"JUnit", "Agile Testing", "Quality Center(ALM)","Bugzilla",
                "HP Loadrunner","RPA","Cucumber","Software Testing",
                "SAP Testing","Database Testing","Mobile Testing",
                "Selenium","ETL Testing","Mantis",
                "SoapUI","JMeter","Postman",
                "TEST Management","JIRA","QTP","TestLink"
        };
        String[] subMenuTitles = {
                "JUnit Tutorial for Beginners: Learn in 3 Days",
                "Agile Methodology Tutorial – Guru99",
                "HP ALM /Quality Center Tutorial",
                "Bugzilla Tutorial – Defect Tracking Tool",
                "HP Loadrunner Tutorial for Beginners",
                "RPA Tutorial for Beginners: Learn Robotic Process Automation",
                "Cucumber Testing Tutorials for Beginners",
                "Software Testing Tutorial",
                "SAP Testing – Tools, Scenarios & Test Case Example",
                "Database (Data) Testing Tutorial",
                "Free Mobile App Testing Tutorial",
                "Selenium Tutorial",
                "ETL Testing Tutorial",
                "MANTIS Bug Tracker Tutorial",
                "SoapUI Tutorials for Beginners",
                "JMeter Tutorial for Beginners: Learn in 7 Days",
                "Postman Tutorial – How to use for API Testing?",
                "TEST Management Tutorials: Complete Training Course",
                "What is JIRA Testing Tool? Tutorial for Beginners",
                "UFT/QTP Tutorial for Beginners: Learn in 7 Days",
                "TestLink Tutorial: A Complete Guide"
                };
        int randomIndex = new Random().nextInt(subMenuNames.length);

        String randomName = subMenuNames[randomIndex];
        String randomTitle = subMenuTitles[randomIndex];

        //Xpath
        String menuHeaderXpathByText = "//ul[@id = 'primary-menu']//span[text() = '%s']";
        String subMenuHeaderXpathByText = "//ul[@id = 'primary-menu']//a[text() = '%s']";
        String postTitleXpath = "//h1[@class = 'entry-title']";

        //Location
        By menuHeaderByText = By.xpath(String.format(menuHeaderXpathByText, "Testing"));
        By submenuHeaderByText = By.xpath(String.format(subMenuHeaderXpathByText, randomName));
        By postTitle = By.xpath(postTitleXpath);

        //WebElements
        WebElement menuHeaderElement = webDriver.findElement(menuHeaderByText);
        WebElement subMenuHeaderElement = webDriver.findElement(submenuHeaderByText);

        //Actions
        menuHeaderElement.click();//click vào submenu

        WebDriverWait wait = new WebDriverWait(webDriver,1);
        wait.until(ExpectedConditions.visibilityOf(subMenuHeaderElement));

        subMenuHeaderElement.click();// click vào title

        WebElement postTileElement = webDriver.findElement(postTitle);
        String actualPostTitle = postTileElement.getText();

        //Assertion
        String expectedPostTitle = randomTitle;
        Assert.assertEquals(actualPostTitle,expectedPostTitle);

        webDriver.quit();
    }

}


