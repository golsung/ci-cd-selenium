package acceptanceTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcPage {
    @FindBy(id="operand1")
    private WebElement operand1;

    @FindBy(id="operand2")
    private WebElement operand2;

    @FindBy(id="btn-add")
    private WebElement btnAdd;

    @FindBy(id="result")
    private WebElement result;

    private WebDriver driver;

    public CalcPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void performAddOperation(int a, int b) throws InterruptedException {
        operand1.sendKeys(Integer.toString(a));
        operand2.sendKeys(Integer.toString(b));

        String resultStr = driver.findElement(By.id("result")).getText();

        driver.findElement(By.id("btn-add")).click();

        WebElement resultDiv = driver.findElement(By.id("result"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElement(resultDiv,
                        resultStr )));
    }

    public int getResult() {
        return Integer.parseInt(driver.findElement(By.id("result")).getText());
    }
}
