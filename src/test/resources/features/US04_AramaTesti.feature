

  Feature: Kullanici siteden urun arar

    Scenario: TC06 Kullanici N11 sitesinde girilen ürünü bulabilmeli

      Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
      When arama kutusuna "samsung" kelimeyi yazip aratir
      And arama sonucunda urun bulunabildigini test eder

