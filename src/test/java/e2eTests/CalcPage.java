package e2eTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    private final String  SERVER_URL = System.getProperty("calculator.url");

    public CalcPage(String serverUrl) {
        getWebDriver(serverUrl);
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

    private void getWebDriver(String serverUrl) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//       Windows System.setProperty("webdriver.chrome.driver", "C:\\usr\\selenium\\chromedriver.exe");
//            WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get(serverUrl);

    }

    public void quit() {
        driver.quit();
    }
}
