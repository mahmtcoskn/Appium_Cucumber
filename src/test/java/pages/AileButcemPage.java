package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AileButcemPage {
    public AileButcemPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)), this);
    }

    @FindBy(xpath = "//*[@text='E-mail Adresi']")
    public MobileElement mailBox;

    @FindBy(xpath = "//*[@text='Şifre']")
    public MobileElement passwordBox;

    @FindBy(xpath = "//*[@text='Başarıyla giriş yapıldı.']")
    public MobileElement girisBasariliText;

    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
    public MobileElement solUstMenu;

    public void girisBasariliMethodu() {
        String actual = girisBasariliText.getText();
        String expected = "Başarıyla giriş yapıldı.";
        assertEquals("Giris Basarisiz", expected, actual);
    }
}