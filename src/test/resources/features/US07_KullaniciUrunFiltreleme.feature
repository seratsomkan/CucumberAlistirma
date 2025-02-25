

Feature: Kullanici siteden urun arar ve filtreleme uygular

  Scenario: TC08 Kullanici urun arayabililmeli ve filtreleme yapabilmeli

    Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
    And sayfa yuklenmesi icin 1 saniye bekler
    And cookies'leri kapat
    Then arama kutusuna "laptop" kelimeyi yazip aratir
    And soldaki menuden "Monster" markasini secer
    And sayfa yuklenmesi icin 1 saniye bekler
    And soldaki menuden fiyat araligini "25000" ila "50000" arasinda yapar
    And sayfa yuklenmesi icin 1 saniye bekler
    And soldaki menuden islemci olarak "Intel Core i7" secer
    And sayfa yuklenmesi icin 1 saniye bekler
    And soldaki menuden urun puanini 4 yildiz ve uzeri secer
    Then siralamayi Magaza Puani olarak secer
    Then bu filtreleme sonucunda urun bulunabildigini test eder
