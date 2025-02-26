


Feature: US01 Kullanici demoguru99 sayfasına giderek liste alır

  Scenario: TC02 kullanici liste alabilmeli
    Given kullanici test data dosyasinda verilen "demoguru99Url" anasayfaya gider
    Then Company listesini consola yazdirir
    And senkronizasyon icin 5 saniye bekler
    Then "Vakrangee"in listede oldugunu test eder
    Then "Vakrangee"in prev.close degerini yazdirir
    Then 21. satir 5. sutunu yazdirir