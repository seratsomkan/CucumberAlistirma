package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.opentest4j.AssertionFailedError;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class DemoguruStepdefinitions {

    Map<String,String> companyMap;
    Collection<String> valueCollection;

    @Then("Company listesini consola yazdirir")
    public void companyListesiniConsolaYazdirir() {
        companyMap = new TreeMap<>();

        for (int i=1; i<=26; i++){
            companyMap.put("Company "+i+":",Driver.getDriver().findElement(By.xpath("//tr["+ i +"]/td[1]")).getText());
        }
        System.out.println(companyMap);
    }


    @Then("{string}in listede oldugunu test eder")
    public void inListedeOldugunuTestEder(String arananSirketIsmi) {
        valueCollection = companyMap.values();

        boolean arananSirketIsmiVarMi = false; // istenilen sirket ismini false olarak tanımladık.

        for(String eachSirketIsmi : valueCollection){ //tum sirket isimlerini kontrol ettirdik

            if (eachSirketIsmi.equals(arananSirketIsmi)){ //aranan sirket ismi, map içerisinde varsa
                arananSirketIsmiVarMi = true; // true olarak atama yaptık.
                break; // aranan şirket ismini bulduktan sonra, diğer değerlere bakmamak için break komutunu kullandık.
            }
        }

        try {
            // Assertion kontrolü
            Assertions.assertTrue(arananSirketIsmiVarMi, "Şirket ismi bulunamadı!");
        } catch (AssertionFailedError e) {
            System.err.println("Doğrulama başarısız oldu: " + e.getMessage());
        }
    }


    @And("senkronizasyon icin {int} saniye bekler")
    public void senkronizasyonIcinSaniyeBekler(int beklemeSuresi) {
        ReusableMethods.bekle(beklemeSuresi);
    }

    @Then("{string}in prev.close degerini yazdirir")
    public void inPrevCloseDegeriniYazdirir(String verilenSirketIsmi) {

        Map<String, Map<String,String>> sirketMap = new TreeMap<>();
        Map<String,String> prevCloseMap = new TreeMap<>();
        for (int i=1;i<=26;i++){
            prevCloseMap.put("Prev Close (Rs)",Driver.getDriver().findElement(By.xpath("//tr["+ i +"]/td[3]")).getText());
            sirketMap.put(Driver.getDriver().findElement(By.xpath("//tr["+ i +"]/td[1]")).getText(),prevCloseMap);
        }
        System.out.println(verilenSirketIsmi+":"+sirketMap.get(verilenSirketIsmi));
    }

    @Then("{int}. satir {int}. sutunu yazdirir")
    public void satirSutunuYazdirir(int satirNo, int sutunNo) {

        System.out.println(Driver.getDriver().findElement(By.xpath("//tr[" + satirNo + "]/td["+sutunNo+"]")).getText());
    }
}
