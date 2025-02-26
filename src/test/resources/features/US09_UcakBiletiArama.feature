
  Feature: US01 Ucak bileti arama testi

    Scenario: TC01 Geçerli kriterlerle ucak bileti arama

      Given kullanici jollyTur anasayfasina gider
      When PlannerElements alanindaki Ucak Bileti sekmesine tiklar
      Then tek yon checkbox'ina tiklar
      And senkronizasyon icin 1 saniye bekle
      Then "toGecerliNereden" ve "toGecerliNereye" alani girilir
      Then gidis tarihi secilir
      Then yolcu sayisi secilir ve arama yapilir
      And senkronizasyon icin 5 saniye bekle
      Then ucus bulundugu dogrulanir

    Scenario: TC02 Geçersiz kriterlerle ucak bileti arama

      Given kullanici jollyTur anasayfasina gider
      When PlannerElements alanindaki Ucak Bileti sekmesine tiklar
      Then tek yon checkbox'ina tiklar
      And senkronizasyon icin 1 saniye bekle
      Then "toGecersizNereden" ve "toGecersizNereye" alani girilir
      Then gidis tarihi secilir
      Then yolcu sayisi secilir ve arama yapilir
      And senkronizasyon icin 1 saniye bekle
      Then arama yapilamadigi dogrulanir


