package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.JollyTurPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class JollyTurStepdefinitions {

    JollyTurPage jollyTurPage = new JollyTurPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.driver;

    @Given("kullanici jollyTur anasayfasina gider")
    public void kullanici_jolly_tur_anasayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("jollyTurUrl"));
    }

    @When("PlannerElements alanindaki Ucak Bileti sekmesine tiklar")
    public void plannerelementsAlanindakiUcakBiletiSekmesineTiklar() {
        jollyTurPage.ucakBiletiButton.click();
    }

    @Then("tek yon checkbox'ina tiklar")
    public void tekYonCheckboxInaTiklar() {
        jollyTurPage.TekYonCheckbox.click();
    }

    @Then("{string} ve {string} alani girilir")
    public void veAlaniGirilir(String configNereden, String ConfigNereye) {
        ReusableMethods.bekle(1);
        jollyTurPage.neredenTextAlani.sendKeys(ConfigReader.getProperty(configNereden));
        ReusableMethods.bekle(1);

        if (jollyTurPage.ankaraHavalimaniSecimi.getText().contains("Ankara")){
            jollyTurPage.ankaraHavalimaniSecimi.click();
        }

        ReusableMethods.bekle(1);
        jollyTurPage.nereyeTextAlani.sendKeys(ConfigReader.getProperty(ConfigNereye));
        ReusableMethods.bekle(1);

        if (jollyTurPage.istanbulHavalimaniSecimi.getText().contains("İstanbul")){
            jollyTurPage.istanbulHavalimaniSecimi.click();
        }

    }

    @Then("senkronizasyon icin {int} saniye bekle")
    public void senkronizasyonIcinSaniyeBekle(int saniye) {
        ReusableMethods.bekle(saniye);
    }

    @Then("gidis tarihi secilir")
    public void gidisTarihiSecilir() {
        jollyTurPage.gidisTarihiAlani.click();
        ReusableMethods.bekle(1);

        while ( !(jollyTurPage.datePickerMonth.getText().equals(ConfigReader.getProperty("istenenAy"))) ){
            jollyTurPage.calendarNextButton.click();
            ReusableMethods.bekle(1);
        }

            String dinamikTarih = "(//*[@data-handler='selectDay'])["+ConfigReader.getProperty("istenenGun")+"]";
            WebElement hedefTarih = Driver.driver.findElement(By.xpath(dinamikTarih));
            hedefTarih.click();


    }
    @Then("yolcu sayisi secilir ve arama yapilir")
    public void yolcuSayisiSecilirVeAramaYapilir() {
        jollyTurPage.yolcuSayisiAlani.click();
        jollyTurPage.yetiskinSayisiArtirmaButonu.click();
        jollyTurPage.cocukSayisiArtirmaButonu.click();
        jollyTurPage.kabinTipiDropdownMenu.click();
        jollyTurPage.kabinTipiBusinessButonu.click();
        jollyTurPage.hemenAraButonu.click();
    }

    @Then("ucus bulundugu dogrulanir")
    public void ucusBulunduguDogrulanir() {
        String bulunanSonucSayisiText = jollyTurPage.bulunanSonucSayisi.getText();
        int bulunanSonucSayisiInt = Integer.parseInt(bulunanSonucSayisiText);
        System.out.println(bulunanSonucSayisiText +"/"+ bulunanSonucSayisiInt);

        Assertions.assertTrue(bulunanSonucSayisiInt>0,"Uçuş bulunamadı.");
    }


    @Then("arama yapilamadigi dogrulanir")
    public void aramaYapilamadigiDogrulanir() {
        Assertions.assertTrue(jollyTurPage.neredenFieldzorunluAlanUyariText.isDisplayed());
        Assertions.assertTrue(jollyTurPage.nereyeFieldzorunluAlanUyariText.isDisplayed());
    }


    @When("footer alaninin gorundugunu test eder")
    public void footerAlanininGorundugunuTestEder() {
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", jollyTurPage.footerAlani);
        jollyTurPage.footerAlani.isDisplayed();
    }

    @Then("Hakkimizda sayfasina gider ve sayfayi dogrular")
    public void footerAlanindakiHakkimizdaSayfasinaGider() {
        jollyTurPage.footerHakkimizdaButonu.click(); //Hakkımızda butonuna tıklar
        Assertions.assertTrue(jollyTurPage.hakkimizdaSayfasiSayfaBasligi.isDisplayed()); // Hakkımızda metin başlığının görünürlüğü sorgulanır.
        Driver.driver.navigate().back(); // bir önceki sayfaya dönülür.
    }
    @Then("Misafir Iliskiler'i sayfasina gider ve sayfayi dogrular")
    public void misafirIliskilerISayfasinaGiderVeSayfayiDogrular() {
        jollyTurPage.footerMisafirIliskileriButonu.click(); //Misafir İlişkileri butonuna tıklar
        Assertions.assertTrue(jollyTurPage.misafirIliskileriSayfasiSayfaBasligi.isDisplayed()); //Misafir İlişkileri başlığının görünürlüğü sorgulanır.
        Driver.driver.navigate().back(); // bir önceki sayfaya dönülür.
    }

    @Then("İnsan Kaynaklari sayfasina gider ve sayfayi dogrular")
    public void insanKaynaklariSayfasinaGiderVeSayfayiDogrular() {
        jollyTurPage.footerInsanKaynaklariButonu.click(); //İnsan Kaynakları butonuna tıklar
        Assertions.assertTrue(jollyTurPage.insanKaynaklariSayfasiSayfaBasligi.isDisplayed()); // İnsan Kaynakları başlığının görünürlüğü sorgulanır.
        Driver.driver.navigate().back(); // bir önceki sayfaya dönülür.
    }

    @Then("Kullanim Sozlesmesi sayfasina gider ve sayfayi dogrular")
    public void kullanimSozlesmesiSayfasinaGiderVeSayfayiDogrular() {
        jollyTurPage.footerKullanimSozlesmesiButonu.click(); //Kullanım Sözleşmesi butonuna tıklar
        Assertions.assertTrue(jollyTurPage.kullanimSozlesmesiSayfasiSayfaBasligi.isDisplayed()); // İnsan Kaynakları başlığının görünürlüğü sorgulanır.
        Driver.driver.navigate().back(); // bir önceki sayfaya dönülür.
    }

    @Then("Bilgi Toplumu Hizmetleri sayfasina gider ve sayfayi dogrular")
    public void bilgiToplumuHizmetleriSayfasinaGiderVeSayfayiDogrular() {
        jollyTurPage.footerBilgiToplumuHizmetleriButonu.click(); //Bilgi Toplumu Hizmetleri butonuna tıklar

        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("mthsUrl")); // driver, açılan sayfaya
        ReusableMethods.bekle(2); // senkronizasyon için beklenir

        Assertions.assertTrue(jollyTurPage.bilgiToplumuHizmetleriSiteyeDonButonu.isDisplayed()); // Bilgi Toplumu Hizmetleri başlığının görünürlüğü sorgulanır.

        Driver.driver.navigate().back(); // bir önceki sayfaya dönülür.
        ReusableMethods.bekle(1); // senkronizasyon için beklenir
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurUrl"));
    }

    @Then("Satis Ofislerimiz sayfasina gider ve sayfayi dogrular")
    public void satisOfislerimizSayfasinaGiderVeSayfayiDogrular() {
        jollyTurPage.footerSatisOfislerimizButonu.click(); // Satış Ofislerimiz sayfasına gidilir.
        Assertions.assertTrue(jollyTurPage.satisOfisleriSayfaBasligi.isDisplayed());
        Driver.driver.navigate().back(); // bir önceki sayfaya dönülür.
    }

    @Then("İletisim sayfasina gider ve sayfayi dogrular")
    public void iletisimSayfasinaGiderVeSayfayiDogrular() {
        jollyTurPage.footerIletisimButonu.click();
        Assertions.assertTrue(jollyTurPage.iletisimSayfaBasligi.isDisplayed());
        Driver.driver.navigate().back();
    }


    @When("sosyal medya alaninin gorundugunu test eder")
    public void sosyalMedyaAlanininGorundugunuTestEder() {
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", jollyTurPage.sosyalMedyaFooterMenuTitle);
        Assertions.assertTrue(jollyTurPage.sosyalMedyaFooterMenuTitle.isDisplayed());
    }

    @Then("facebook linkine tiklar ve sayfayi dogrular")
    public void facebookLinkineTiklarVeSayfayiDogrular() {

        jollyTurPage.facebookLinkButonu.click(); // facebook butonuna tıklanır
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurFacebookUrl")); // driver, facebook sayfasına taşınır
        ReusableMethods.bekle(1);

        String expectedFacebookUrl = ConfigReader.getProperty("jollyTurFacebookUrl"); // sayfanın beklenen url'ini String olarak atadık
        String actualFacebookUrl = Driver.getDriver().getCurrentUrl(); // sayfanın gerçek url'ini string olarak atadık.
        Assertions.assertEquals(expectedFacebookUrl, actualFacebookUrl); // beklenen ve gerçek url'in, aynı olduğu sorgulanır.

        Driver.driver.close();// Facebook sayfa sekmesini kapatır
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurUrl")); // Driver, jolltur.com'a geri taşınır
        ReusableMethods.bekle(1);
    }

    @Then("X linkine tiklar ve sayfayi dogrular")
    public void xLinkineTiklarVeSayfayiDogrular() {
        jollyTurPage.xLinkButonu.click(); // X butonuna tıklanır
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurXUrl")); // driver, X sayfasına taşınır
        ReusableMethods.bekle(1);

        String expectedXUrl = ConfigReader.getProperty("jollyTurXUrl"); // sayfanın beklenen url'ini String olarak atadık
        String actualXUrl = Driver.getDriver().getCurrentUrl(); // sayfanın gerçek url'ini string olarak atadık.
        Assertions.assertEquals(expectedXUrl, actualXUrl); // beklenen ve gerçek url'in, aynı olduğu sorgulanır.

        Driver.driver.close(); // X sayfa sekmesini kapatır.
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurUrl")); // Driver, jolltur.com'a geri taşınır
        ReusableMethods.bekle(1);
    }

    @Then("youtube linkine tiklar ve sayfayi dogrular")
    public void youtubeLinkineTiklarVeSayfayiDogrular() {
        jollyTurPage.youtubeLinkButonu.click();
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurYoutubeUrl"));
        ReusableMethods.bekle(1);

        String expectedYoutubeUrl = ConfigReader.getProperty("jollyTurYoutubeUrl");
        String actualYoutubeUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedYoutubeUrl, actualYoutubeUrl);
        ReusableMethods.bekle(1);

        Driver.driver.close();
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurUrl"));
        ReusableMethods.bekle(1);
    }

    @Then("vimeo linkine tiklar ve sayfayi dogrular")
    public void vimeoLinkineTiklarVeSayfayiDogrular() {
        jollyTurPage.vimeoLinkButonu.click();
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurVimeoUrl"));
        ReusableMethods.bekle(1);

        String expectedVimeoUrl = ConfigReader.getProperty("jollyTurVimeoUrl");
        String actualVimeoUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedVimeoUrl, actualVimeoUrl);
        ReusableMethods.bekle(1);

        Driver.driver.close();
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurUrl"));
        ReusableMethods.bekle(1);
    }

    @Then("onedio linkine tiklar ve sayfayi dogrular")
    public void onedioLinkineTiklarVeSayfayiDogrular() {
        jollyTurPage.onedioLinkButonu.click();
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurOnedioUrl"));
        ReusableMethods.bekle(1);

        String expectedOnedioUrl = ConfigReader.getProperty("jollyTurOnedioUrl");
        String actualOnedioUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedOnedioUrl, actualOnedioUrl);
        ReusableMethods.bekle(1);

        Driver.driver.close();
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurUrl"));
        ReusableMethods.bekle(1);
    }

    @Then("jolly blog linkine tiklar ve sayfayi dogrular")
    public void jollyBlogLinkineTiklarVeSayfayiDogrular() {
        jollyTurPage.jollyBlogLinkButonu.click();
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurJollyBlogUrl"));
        ReusableMethods.bekle(1);

        String expectedJollyBlogUrl = ConfigReader.getProperty("jollyTurJollyBlogUrl");
        String actualJollyBlogUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedJollyBlogUrl, actualJollyBlogUrl);
        ReusableMethods.bekle(1);

        Driver.driver.close();
        ReusableMethods.urlIleWindowDegistir(Driver.driver,ConfigReader.getProperty("jollyTurUrl"));
        ReusableMethods.bekle(1);
    }




}
