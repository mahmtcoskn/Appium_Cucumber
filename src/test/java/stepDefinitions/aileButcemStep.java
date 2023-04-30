package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AileButcemPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

public class aileButcemStep {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    TouchAction action=new TouchAction<>(driver);
    AileButcemPage page = new AileButcemPage();
    @Given("Kullanici kurulumlari tamamlar")
    public void kullanici_kurulumlari_tamamlar() {
        Driver.getAndroidDriver();

    }
    @Then("ilk ekran ayarlarini yapar ve {string} a tiklayin ve ardindan login sayfasina ulasin")
    public void ilk_ekran_ayarlarini_yapar_ve_a_tiklayin_ve_ardindan_login_sayfasina_ulasin(String girisyap) {
        ReusableMethods.wait(2);

        for (int i=0;i<6; i++){
            action.press(PointOption.point(899,800))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                    moveTo(PointOption.point(205,800)).release().perform();
        }
        ReusableMethods.scrollWithUiScrollable(girisyap);
    }
    @Then("{string} ve {string} bilgilerini girerek kullanici bilgileriyle {string}")
    public void ve_bilgilerini_girerek_kullanici_bilgileriyle(String mail, String password, String girisyap) {
        page.mailBox.sendKeys(ConfigReader.getProperty(mail));
        page.passwordBox.sendKeys(ConfigReader.getProperty(password));
        ReusableMethods.scrollWithUiScrollable(girisyap);
    }
    @Then("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamaya_kullanici_bilgileriyle_giris_yapildigini_dogrulayin() {
        ReusableMethods.wait(1);
        page.girisBasariliMethodu();
    }
    @Then("sol kisimdaki menuden {string} bolumune gidin")
    public void sol_kisimdaki_menuden_bolumune_gidin(String hesabim) {
        ReusableMethods.wait(6);
        page.solUstMenu.click();
        ReusableMethods.scrollWithUiScrollable(hesabim);
    }
    @Then("hesabim sayfasindaki bilgileri {string} {string} {string} {string} {string} degistirerek degisikleri kaydedin")
    public void hesabim_sayfasindaki_bilgileri_degistirerek_degisikleri_kaydedin(String string, String string2, String string3, String string4, String string5) {

    }
    @Then("ardindan degisiklerin yapildigini dogrulayin")
    public void ardindan_degisiklerin_yapildigini_dogrulayin() {

    }


}
