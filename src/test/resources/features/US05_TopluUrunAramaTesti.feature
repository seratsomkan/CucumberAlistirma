

Feature: Kullanici siteden urun arar

  Scenario Outline: TC07 Kullanici liste olarak verilen urunleri aratabilmeli

    Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
    When arama kutusuna "<aratilacakKelime>" kelimeyi yazip aratir
    And arama sonucunda urun bulunabildigini test eder
    And sayfayi kapar
    Examples:
      | aratilacakKelime |
      | samsung |
      | kazak |
      | bot |
