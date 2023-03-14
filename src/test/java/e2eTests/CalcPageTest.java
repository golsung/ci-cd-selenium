package e2eTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcPageTest {

    private CalcPage calcPage;
    private final String  SERVER_URL = System.getProperty("calculator.url");

    @BeforeEach
    public void setUp() {
        calcPage = new CalcPage(SERVER_URL);
    }
    @AfterEach
    public void tearDown() {
        calcPage.quit();
    }
    @Test
    public void shouldReturnTHeResultOfAddition() throws InterruptedException {
        calcPage.performAddOperation(10, 20);
        assertEquals(30, calcPage.getResult());
    }
}
