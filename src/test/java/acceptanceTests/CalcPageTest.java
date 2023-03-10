package acceptanceTests;

import acceptanceTests.config.AcceptanceTestConfig;
import cloud.ez2learn.seleniumproj.SeleniumProjApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SeleniumProjApplication.class)
@ContextConfiguration(classes = { AcceptanceTestConfig.class })
public class CalcPageTest {

    @Autowired
    private WebDriver driver;

    @Autowired
    private URI notepadBaseUri;

    private CalcPage calcPage;

    @BeforeEach
    public void setUp() {
        driver.get(notepadBaseUri.toString());
        calcPage = new CalcPage(driver);
    }

    @Test
    public void shouldReturnTHeResultOfAddition() throws InterruptedException {
        calcPage.performAddOperation(10, 20);
        assertEquals(30, calcPage.getResult());
    }
}
