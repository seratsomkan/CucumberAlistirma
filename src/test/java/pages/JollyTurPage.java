package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class JollyTurPage {

    public JollyTurPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[text()='Uçak Bileti'])[2]")
    public WebElement ucakBiletiButton;

    @FindBy(xpath = "//*[text()='Tek Yön']")
    public WebElement TekYonCheckbox;

    @FindBy(xpath = "//*[@id='travelDestinationDepartureSearch']")
    public WebElement neredenTextAlani;

    @FindBy(xpath = "(//*[@class='main-text'])[27]")
    public WebElement ankaraHavalimaniSecimi;

    @FindBy(xpath = "//*[@id='travelDestinationReturnSearch']")
    public WebElement nereyeTextAlani;

    @FindBy(xpath = "(//*[@class='main-text'])[54]")
    public WebElement istanbulHavalimaniSecimi;

    @FindBy(xpath = "//*[text()='Gidiş Tarihi']")
    public WebElement gidisTarihiAlani;

    @FindBy(xpath = "//*[@class='ui-datepicker-month']")
    public WebElement datePickerMonth;

    @FindBy(xpath = "//*[@class='ui-datepicker-year']")
    public WebElement datePickerYear;

    @FindBy(xpath = "//*[@class='ui-icon ui-icon-circle-triangle-e']")
    public WebElement calendarNextButton;

    @FindBy(xpath = "//*[@class='ui-icon ui-icon-circle-triangle-w']")
    public WebElement calendarBackButton;

    @FindBy(xpath = "//*[text()='Yolcu Sayısı']")
    public WebElement yolcuSayisiAlani;

    @FindBy(xpath = "(//*[@data-name='inc'])[13]")
    public WebElement yetiskinSayisiArtirmaButonu;

    @FindBy(xpath = "(//*[@data-name='inc'])[14]")
    public WebElement cocukSayisiArtirmaButonu;

    @FindBy(xpath = "(//*[text()='Ekonomi'])[2]")
    public WebElement kabinTipiDropdownMenu;

    @FindBy(xpath = "//*[@data-val='Business']")
    public WebElement kabinTipiBusinessButonu;

    @FindBy(xpath = "(//*[text()='UYGULA'])[4]")
    public WebElement yolcuSayisiUygulaButonu;

    @FindBy(xpath = "(//*[@class='list action-button'])[7]")
    public WebElement hemenAraButonu;

    @FindBy(xpath = "//*[@id='selectCountbox']")
    public WebElement bulunanSonucSayisi;

    @FindBy(xpath = "(//*[@class='error-tooltip'])[15]")
    public WebElement neredenFieldzorunluAlanUyariText;

    @FindBy(xpath = "(//*[@class='error-tooltip'])[16]")
    public WebElement nereyeFieldzorunluAlanUyariText;

    @FindBy(xpath = "//*[@class='footer-menu']")
    public WebElement footerAlani;

    @FindBy(xpath = "//*[@id='footer']/div[2]/div/nav/a[1]")
    public WebElement footerHakkimizdaButonu;

    @FindBy(xpath = "//*[@id='footer']/div[2]/div/nav/a[2]")
    public WebElement footerMisafirIliskileriButonu;

    @FindBy(xpath = "//*[@id='footer']/div[2]/div/nav/a[3]")
    public WebElement footerInsanKaynaklariButonu;

    @FindBy(xpath = "//*[@id='footer']/div[2]/div/nav/a[4]")
    public WebElement footerKullanimSozlesmesiButonu;

    @FindBy(xpath = "//*[@id='footer']/div[2]/div/nav/a[5]")
    public WebElement footerBilgiToplumuHizmetleriButonu;

    @FindBy(xpath = "//*[@id='footer']/div[2]/div/nav/a[6]")
    public WebElement footerSatisOfislerimizButonu;

    @FindBy(xpath = "//*[@id='footer']/div[2]/div/nav/a[7]")
    public WebElement footerIletisimButonu;

    //Hakkımızda sayfası
    @FindBy(xpath = "//*[text()='Hakkımızda - Jolly ']")
    public WebElement hakkimizdaSayfasiSayfaBasligi;

    //Müşteri İlişkileri sayfası
    @FindBy(xpath = "(//*[text()='Misafir İlişkileri - Jolly'])[2]")
    public WebElement misafirIliskileriSayfasiSayfaBasligi;

    //İnsan Kaynakları sayfası
    @FindBy(xpath = "(//*[text()='İnsan Kaynakları - Jolly'])[2]")
    public WebElement insanKaynaklariSayfasiSayfaBasligi;

    //Kullanım Sözleşmesi sayfası
    @FindBy(xpath = "//*[text()='Kullanım Sözleşmesi - Jolly Tur']")
    public WebElement kullanimSozlesmesiSayfasiSayfaBasligi;

    //Bilgi Toplumu Hizmetleri sayfası
    @FindBy(xpath = "//*[@class='siteyDon']")
    public WebElement bilgiToplumuHizmetleriSiteyeDonButonu;

    //Satış Ofisleri sayfası
    @FindBy(xpath = "//*[text()='Satış Ofisleri']")
    public WebElement satisOfisleriSayfaBasligi;

    //İletişim sayfası
    @FindBy(xpath = "//*[text()='İletişim - Jolly Tur']")
    public WebElement iletisimSayfaBasligi;

    @FindBy(xpath = "//*[text()='Sosyal Medya']")
    public WebElement sosyalMedyaFooterMenuTitle;

    @FindBy(xpath = "//*[@href='https://www.facebook.com/jollytur']")
    public WebElement facebookLinkButonu;

    @FindBy(xpath = "//*[@href='https://twitter.com/jollytur']")
    public WebElement xLinkButonu;

    @FindBy(xpath = "//*[@href='https://www.youtube.com/user/jollyturtatil']")
    public WebElement youtubeLinkButonu;

    @FindBy(xpath = "//*[@href='https://vimeo.com/jollytur']")
    public WebElement vimeoLinkButonu;

    @FindBy(xpath = "//*[@href='https://onedio.com/profil/jolly-tur']")
    public WebElement onedioLinkButonu;

    @FindBy(xpath = "//*[@href='https://blog.jollytur.com']")
    public WebElement jollyBlogLinkButonu;




}
