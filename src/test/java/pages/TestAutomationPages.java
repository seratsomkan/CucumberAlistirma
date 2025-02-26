package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestAutomationPages {


    public TestAutomationPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()=' Signup / Login']")
    public WebElement anasayfaSignUpButonu;

    @FindBy(xpath = "//*[@data-qa='signup-name']")
    public WebElement nameKutusu;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//*[@data-qa='signup-button']")
    public WebElement loginSayfasindakiSignUpButonu;

    @FindBy(xpath = "//*[@id='id_gender1']")
    public WebElement mrCheckBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@id='days']")
    public WebElement dayDdm;

    @FindBy(xpath = "//*[@id='months']")
    public WebElement monthDdm;

    @FindBy(xpath = "//*[@id='years']")
    public WebElement yearsDdm;

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement firstNameKutusu;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement lastNameKutusu;

    @FindBy(xpath = "//*[@id='country']")
    public WebElement countryKutusu;

    @FindBy(xpath = "//*[@data-qa='create-account']")
    public WebElement creatAccountButonu;

    @FindBy(xpath = "//b[.='Account Created!']")
    public WebElement accountCreatedYazisi;




}
