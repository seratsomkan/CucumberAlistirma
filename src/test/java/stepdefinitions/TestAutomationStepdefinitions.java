package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.TestAutomationPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestAutomationStepdefinitions {


    TestAutomationPages testAutomationPages = new TestAutomationPages();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String emailAdres = faker.internet().emailAddress();
    String password = faker.internet().password();

    @Given("kullanici test data dosyasinda verilen {string} anasayfaya gider")
    public void kullaniciTestDataDosyasindaVerilenAnasayfayaGider(String verilenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(verilenUrl));
    }
    @And("user sign up linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        testAutomationPages.anasayfaSignUpButonu.click();
    }
    @Then("user New User Signup! bolumune bilgileri girer")
    public void user_new_user_signUp_bolumune_bilgileri_girer() {
        testAutomationPages.emailKutusu.sendKeys(emailAdres);
        testAutomationPages.nameKutusu.sendKeys(firstName);
    }
    @And("signUp butonuna basar")
    public void sign_up_butonuna_basar() {
        testAutomationPages.loginSayfasindakiSignUpButonu.click();
    }
    @Then("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() {
        testAutomationPages.passwordKutusu.sendKeys(password);

        Select selectDay = new Select(testAutomationPages.dayDdm);
        selectDay.selectByValue("4");

        Select selectMonth = new Select(testAutomationPages.monthDdm);
        selectMonth.selectByVisibleText("August");

        Select selectYear = new Select(testAutomationPages.yearsDdm);
        selectYear.selectByValue("1998");

        testAutomationPages.firstNameKutusu.sendKeys(firstName);
        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.company().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).perform();

        ReusableMethods.bekle(1);

        Select selectCountry = new Select(testAutomationPages.countryKutusu);
        selectCountry.selectByValue("New Zealand");

    }
    @And("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {
        testAutomationPages.creatAccountButonu.click();

    }
    @Then("hesap olustugunu test edin")
    public void hesap_olustugunu_test_edin() {
        Assertions.assertTrue(testAutomationPages.accountCreatedYazisi.isDisplayed());
    }





}
