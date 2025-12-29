import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://example.com/login");
    }

    @Test
    void shouldLoginWithValidCredentials() {
        driver.findElement(By.cssSelector("#email"))
                .sendKeys("test@example.com");

        driver.findElement(By.cssSelector("#password"))
                .sendKeys("123456");

        driver.findElement(By.cssSelector("button[type='submit']"))
                .click();

        // Validação simples
        assertTrue(driver.getCurrentUrl().contains("/dashboard"),
                "User was not redirected to dashboard");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
