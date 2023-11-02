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

        String[] names = {"JUnit", "Agile Testing", "Quality Center(ALM)"};
        String[] titles = {
                "JUnit Tutorial for Beginners: Learn in 3 Days",
                "Agile Methodology Tutorial – Guru99",
                "HP ALM /Quality Center Tutorial"
                };
        int randomIndex = new Random().nextInt(names.length);

        String randomName = names[randomIndex];
        String randomTitle = titles[randomIndex];

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
        menuHeaderElement.click();//click vào TEsting

        WebDriverWait wait = new WebDriverWait(webDriver,1);
        wait.until(ExpectedConditions.visibilityOf(subMenuHeaderElement));

        subMenuHeaderElement.click();// click vào JUnit

        WebElement postTileElement = webDriver.findElement(postTitle);
        String actualPostTitle = postTileElement.getText();

        //Assertion
        String expectedPostTitle = randomTitle;
        Assert.assertEquals(actualPostTitle,expectedPostTitle);

        webDriver.quit();
    }

}


