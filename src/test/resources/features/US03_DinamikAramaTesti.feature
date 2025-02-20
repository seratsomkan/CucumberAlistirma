

  Feature: Kullanici siteden urun arar

    Scenario: TC05 Kullanici N11 sitesinde verilen ürünü bulabilmeli

      Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
      When arama kutusuna test data dosyasindaki belirlenen kelimeyi yazip aratir
      And sayfa yuklenmesi icin 1 saniye bekler
      Then arama sonucunda urun bulunabildigini test eder
      And sayfa yuklenmesi icin 1 saniye bekler
      And sayfayi kapar