import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Programowanie obiektowe: teoria, hermetyzacja (enkapsulacja), dziedziczenie, abstrakcja, interfejsy
// Page Object Model
public class UltimateQATest extends PageSetup {

    @Test
    public void testOne() {
        driver.findElementById("idExample").click();

        WebElement buttonSuccess = driver.findElementByClassName("entry-title");
        Assertions.assertEquals("Button success", buttonSuccess.getText());
    }

    @Test
    // Obsuga wyjatkow w Java
    public void testTwo() throws InterruptedException {

        WebElement nameInput = driver.findElementById("et_pb_contact_name_0");
        nameInput.sendKeys("Tester");

        WebElement emailInput = driver.findElementById("et_pb_contact_email_0");
        emailInput.sendKeys("tester@tester.pl");

        // waity w Selenium: implicit wait, explicit wait, fluent wait
        Thread.sleep(2000);

        WebElement emailMeButton = driver.findElementByName("et_builder_submit_button");
        emailMeButton.click();

        Thread.sleep(2000);

        // Ogolna postac xpath: //*[]
        // xpath: //div[@class='et-pb-contact-message']/p
        // xpath / - jeden poziom nizej,   // - dwa lub wiecej poziomow
        WebElement thanksText = driver.findElement(By.xpath("//div[@class='et-pb-contact-message']/p"));
        Assertions.assertEquals("Thanks for contacting us", thanksText.getText());
    }

}
