

Feature: US01 kullanici doğru bilgileri girerek giris yapmayı dener
  @wip
  Scenario: TC01 Gecerli email ve Gecerli password ile giris yapmali
    
    Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
    Then Giris Yap butonuna basar
    And sayfa yuklenmesi icin 2 saniye bekler
    And email "nGecerliEmail" girer
    And password "nGecerliPassword" girer
    Then giris yap butonuna basar
    And sayfa yuklenmesi icin 2 saniye bekler
    And sisteme giris yapildigini test eder
    Then hesaptan cikis yapilir
    And sayfa yuklenmesi icin 2 saniye bekler
    And sayfayi kapar

