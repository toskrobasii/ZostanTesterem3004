import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

// Aplikacja Spring: Spring Boot Application
public class PageSetup {

    // typy proste a typy obiektowe
    String projectLocation = System.getProperty("user.dir");
    // deklaracja a definicja w programowaniu
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", projectLocation + "/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
    }

    @AfterEach
    public void teardown() {
        // roznica pomiedzy driver.close() a driver.quit()
        driver.quit();
    }
}
