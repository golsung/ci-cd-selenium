package e2eTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcPageTest {

    private WebDriver driver;
    private CalcPage calcPage;
    private final String  SERVER_URL = System.getProperty("calculator.url");

    @BeforeEach
    public void setUp() {
        calcPage = new CalcPage(SERVER_URL);
    }

    @Test
    public void shouldReturnTHeResultOfAddition() throws InterruptedException {
        calcPage.performAddOperation(10, 20);
        assertEquals(20, calcPage.getResult());
    }
}
