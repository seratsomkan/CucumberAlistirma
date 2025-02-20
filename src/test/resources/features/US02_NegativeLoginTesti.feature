

Feature: US01 kullanici yanlis bilgileri girerek giris yapmayı dener


  Scenario: TC02 Gecerli email ve Gecersiz password ile giris yapmali

  Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
  Then Giris Yap butonuna basar
  And sayfa yuklenmesi icin 2 saniye bekler
  And email "nGecerliEmail" girer
  And password "nGecersizPassword" girer
  Then giris yap butonuna basar
  And sayfa yuklenmesi icin 2 saniye bekler
  And sisteme giris yapilmadigini test eder
  And sayfayi kapar

  Scenario: TC03 Gecersiz email ve Gecerli password ile giris yapmali

  Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
  Then Giris Yap butonuna basar
  And email "nGecersizEmail" girer
  And sayfa yuklenmesi icin 2 saniye bekler
  And password "nGecerliPassword" girer
  Then giris yap butonuna basar
  And sayfa yuklenmesi icin 2 saniye bekler
  And sisteme giris yapilmadigini test eder
  And sayfayi kapar

  Scenario: TC04 Gecersiz email ve Gecersiz password ile giris yapmali

  Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
  Then Giris Yap butonuna basar
  And email "nGecersizEmail" girer
  And sayfa yuklenmesi icin 2 saniye bekler
  And password "nGecersizPassword" girer
  Then giris yap butonuna basar
  And sayfa yuklenmesi icin 2 saniye bekler
  And sisteme giris yapilmadigini test eder
  And sayfayi kapar