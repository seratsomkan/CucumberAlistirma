package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.NPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class n11Stepdefinitions {

    public NPage nPage = new NPage();

    String satirdakiUrunIsmi;
    int actualSonucYazisiInt;
    Double satirdakiMinBulunacakUrunSayisi;
    Workbook workbook;
    Sheet calisilanSayfa;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver(); //driver'ımızı, JavascriptExecutor'a cast ettik.
    /*
        Javascript, HTML kodlara direk erişim sağlayıp yönetebilen script bir dildir.
        JavascriptExecutor'ı selenium komutları yetersiz kaldığında kullanırız.
     */
    Actions actions = new Actions(Driver.getDriver());

    @Given("kullanici test data dosyasinda verilen {string} anasayfaya gider")
    public void kullanici_test_data_dosyasinda_verilen_anasayfaya_gider(String configIstenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(configIstenenUrl));
        ReusableMethods.bekle(2);

    }

    @Then("Giris Yap butonuna basar")
    public void girisYapButonunaBasar() {
        nPage.anasayfaGirisYapinButonu.click();
    }

    @And("email {string} girer")
    public void emailGirer(String configIstenenMail) {
        nPage.epostaKutusu.sendKeys(ConfigReader.getProperty(configIstenenMail));
    }

    @And("sayfa yuklenmesi icin {int} saniye bekler")
    public void sayfaYuklenmesiIcinSaniyeBekler(int beklenecekSaniye) {
        ReusableMethods.bekle(beklenecekSaniye);
    }

    @Then("password {string} girer")
    public void password_girer(String configIstenenPassword) {
        nPage.passwordKutusu.sendKeys(ConfigReader.getProperty(configIstenenPassword));
    }
    @Then("giris yap butonuna basar")
    public void giris_yap_butonuna_basar() {
        nPage.loginGirisYapButonu.click();
    }

    @Then("sisteme giris yapildigini test eder")
    public void sisteme_giris_yapildigini_test_eder() {
        Assertions.assertTrue(nPage.hesabimButonu.isDisplayed());
    }

    @Then("hesaptan cikis yapilir")
    public void hesaptanCikisYapilir() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(nPage.hesabimButonu).perform();
        ReusableMethods.bekle(2);
        nPage.cikisYapButonu.click();
    }

    @Then("sayfayi kapar")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }

    @And("sisteme giris yapilmadigini test eder")
    public void sistemeGirisYapilmadiginiTestEder() {
        String expectedHataYazisi = "E-posta adresi veya şifre hatalı, kontrol edebilir misin?";
        String actualHataYazisiYazisi = nPage.hataYazisi.getText();

        Assertions.assertEquals(actualHataYazisiYazisi,expectedHataYazisi);
    }

    @And("cookies'leri kapat")
    public void cookiesLeriKapat() throws AWTException {
        Robot robot = new Robot();
        // Örnek piksel konumları (x, y)
        int x = 1550;
        int y = 960;
        // Fareyi belirtilen konuma taşı
        robot.mouseMove(x, y);
        // Bir süre bekle (gözlemleyebilmeniz için)
        ReusableMethods.bekle(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tuşa bas
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tuşu bırak
    }

    @When("arama kutusuna {string} kelimeyi yazip aratir")
    public void aramaKutusunaKelimeyiYazipAratir(String aranacakUrun) {
        nPage.UrunAramaKutusu.sendKeys(aranacakUrun +Keys.ENTER);
    }

    @When("arama kutusuna test data dosyasindaki belirlenen kelimeyi yazip aratir")
    public void aramaKutusunaTestDataDosyasindakiBelirlenenKelimeyiYazipAratir() {
        nPage.UrunAramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void aramaSonucundaUrunBulunabildiginiTestEder() {
        String actualAramaSonucuStr = nPage.aramaSonucYazisi.getText();
        String actualAramaSonucu = actualAramaSonucuStr.replaceAll("\\D","");
        int actualAramaSonucuInt = Integer.parseInt(actualAramaSonucu);
        int unexpectedAramaSonucu = 0;

        Assertions.assertTrue(actualAramaSonucuInt>unexpectedAramaSonucu);
    }

    @Then("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
    public void urunExcelindekiDakiUrununMinMiktariniVeUrunIsminiKaydeder(String excelSatirNoStr) throws IOException {

        String excelDosyaYolu = "src/test/resources/ArananUrunListesi.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        calisilanSayfa = workbook.getSheet("Sheet1");

        int satirNo = Integer.parseInt(excelSatirNoStr);
        satirdakiUrunIsmi = calisilanSayfa.getRow(satirNo-1).getCell(0).getStringCellValue();
        satirdakiMinBulunacakUrunSayisi = calisilanSayfa.getRow(satirNo-1).getCell(1).getNumericCellValue();
    }

    @And("urun ismini anasayfasinda arar ve sonuc sayisini kaydeder")
    public void urunIsminiAnasayfasindaArarVeSonucSayisiniKaydeder() {
        nPage.UrunAramaKutusu.sendKeys(satirdakiUrunIsmi +Keys.ENTER);

        String actualSonucYazisiStr = nPage.aramaSonucYazisi.getText();
        String actualSonucYazisi = actualSonucYazisiStr.replaceAll("\\D","");
        actualSonucYazisiInt = Integer.parseInt(actualSonucYazisi);
    }

    @And("bulunan urun sayisinin {string} da verilen min. miktardan fazla oldugunu test eder")
    public void bulunanUrunSayisininDaVerilenMinMiktardanFazlaOldugunuTestEder(String satirNoStr) {
        Assertions.assertTrue(actualSonucYazisiInt>=satirdakiMinBulunacakUrunSayisi);
    }

    @Then("bulunan sonuc sayisini excelde {string} daki {int}.sutuna yazdirir")
    public void bulunanSonucSayisiniExceldeDakiSutunaYazdirir(String satirNoStr, int sutunNo) throws IOException {

        //once workbook'da istenen işlemi yapalım
        int satirNo = Integer.parseInt(satirNoStr);
        calisilanSayfa
                .getRow(satirNo-1)          //ilgili satıra gittik
                .createCell(sutunNo-1)      //ilgili satırdan cell oluşturduk
                .setCellValue(actualSonucYazisiInt); //ilgili satırdan cell oluşturduk

        //excel'e bilgi yazdırmak için FileOutputStream'e ihtiyaç var
        String excelDosyaYolu = "src/test/resources/ArananUrunListesi.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
    }

    @And("soldaki menuden fiyat araligini {string} ila {string} arasinda yapar")
    public void soldaki_menuden_fiyat_araligini_ila_arasinda_yapar(String minFiyat, String maxFiyat) {

        nPage.fiyatAraligiEnAzKutusu.sendKeys(minFiyat);
        nPage.fiyatAraligiEnCokKutusu.sendKeys(maxFiyat);
        nPage.fiyatAramaTusu.click();
    }

    @And("soldaki menuden islemci olarak {string} secer")
    public void soldaki_menuden_islemci_olarak_secer(String istenilenIslemci) {
        nPage.islemciAramaKutusu.sendKeys(istenilenIslemci);
        ReusableMethods.bekle(1);
        nPage.intelCoreI7SecimButonu.click();
    }

    @And("soldaki menuden {string} markasini secer")
    public void soldaki_menuden_markasini_secer(String istenilenMarka) {

        ReusableMethods.sayfaKaydir();

        if (istenilenMarka.equals("Monster")){
            nPage.markaSekmesiAcilirMenu.click();
            nPage.markaAramaKutusu.sendKeys(istenilenMarka);
            nPage.monsterSecimButonu.click();
        }

        if (istenilenMarka.equals("bosch")){
            nPage.markaAramaKutusu.sendKeys(istenilenMarka);
            nPage.boschSecimButonu.click();
        }

    }

    @And("soldaki menuden urun puanini 4 yildiz ve uzeri secer")
    public void soldakiMenudenUrunPuaniniSecerMarkasiniSecer() {
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", nPage.filtreAlani);
        nPage.urunPuaniSekmesiAcilirMenu.click();
        ReusableMethods.bekle(1);
        nPage.puanSecimi.click();
    }

    @Then("bu filtreleme sonucunda urun bulunabildigini test eder")
    public void bu_filtreleme_sonucunda_urun_bulunabildigini_test_eder() {
        String urunSonucStr = nPage.urunSonucYazisi.getText();
        urunSonucStr = urunSonucStr.replaceAll("\\D","");
        Integer urunSayisi = Integer.parseInt(urunSonucStr);

        int unexpectedUrunSonucu = 0;
        System.out.println(urunSayisi);
        Assertions.assertTrue(urunSayisi>unexpectedUrunSonucu);
    }

    @Then("siralamayi Magaza Puani olarak secer")
    public void siralamayi_olarak_secer() {
        nPage.akilliSiralamaButonu.click();
        nPage.magazaPuaniSiralamaSecenegi.click();
    }



}
