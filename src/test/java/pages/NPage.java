package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NPage {

    public NPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //LoginTesti
    @FindBy(xpath = "//*[@title='Giriş Yap']")
    public WebElement anasayfaGirisYapinButonu;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement epostaKutusu;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@id='loginButton']")
    public WebElement loginGirisYapButonu;

    @FindBy(xpath = "//*[@title='Hesabım']")
    public WebElement hesabimButonu;

    @FindBy(xpath = "//*[@title='Çıkış Yap']")
    public WebElement cikisYapButonu;

    @FindBy(xpath = "//*[text()='E-posta adresi veya şifre hatalı, kontrol edebilir misin?']")
    public WebElement hataYazisi;
    //LoginTestiSonu

    @FindBy(xpath = "//*[@id='searchData']")
    public WebElement UrunAramaKutusu;

    @FindBy(xpath = "//*[@class='resultText ']")
    public WebElement aramaSonucYazisi;

    @FindBy(xpath = "//*[@id='minPrice']")
    public WebElement fiyatAraligiEnAzKutusu;

    @FindBy(xpath = "//*[@id='maxPrice']")
    public WebElement fiyatAraligiEnCokKutusu;

    @FindBy(xpath = "//*[@id='priceSearchButton']")
    public WebElement fiyatAramaTusu;

    @FindBy(xpath = "//*[@placeholder='İşlemci Ara']")
    public WebElement islemciAramaKutusu;

    @FindBy(xpath = "//*[text()='Intel Core i7']")
    public WebElement intelCoreI7SecimButonu;

    @FindBy(xpath = "//*[text()='Marka']")
    public WebElement markaSekmesiAcilirMenu;

    @FindBy(xpath = "//*[@placeholder='Marka Ara']")
    public WebElement markaAramaKutusu;

    @FindBy(xpath = "//*[text()='Monster']")
    public WebElement monsterSecimButonu;

    @FindBy(xpath = "//*[@data-tag-name='Product Review']")
    public WebElement urunPuaniSekmesiAcilirMenu;

    @FindBy(xpath = "(//*[@class='rate customRadio  '])[2]")
    public WebElement puanSecimi;

    @FindBy(xpath = "//*[@class='resultText ']")
    public WebElement urunSonucYazisi;

    @FindBy(xpath = "//*[@class='filterArea']")
    public WebElement filtreAlani;

    @FindBy(xpath = "//*[text()='  Akıllı Sıralama']")
    public WebElement akilliSiralamaButonu;

    @FindBy(xpath = "//*[@class='item i7']")
    public WebElement magazaPuaniSiralamaSecenegi;

    @FindBy(xpath = "//*[text()='Bosch']")
    public WebElement boschSecimButonu;





}
