package e2eTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoE2ETest {

        WebDriver driver;
        private final String  SERVER_URL = System.getProperty("calculator.url");

        @BeforeEach
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
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

            driver.get(SERVER_URL);

        }
        @AfterEach
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void shouldReturnTHeResultOfAddition() throws IOException {
            driver.findElement(By.id("operand1")).sendKeys("10");
            driver.findElement(By.id("operand2")).sendKeys("20");

            String resultStr = driver.findElement(By.id("result")).getText();

            driver.findElement(By.id("btn-add")).click();

            WebElement resultDiv = driver.findElement(By.id("result"));

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.not(
                    ExpectedConditions.textToBePresentInElement(resultDiv,
                    resultStr )));

            resultStr = resultDiv.getText();
            int actual = Integer.parseInt(resultStr);
            assertEquals(30, actual);
        }
}
