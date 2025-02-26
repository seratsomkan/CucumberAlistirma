

  Feature: US02 Footer Alani Dogrulama Testi

    Scenario: TC01 Footer alaninda bulunan tum ogelerin dogru calistiginin kontrol edilmesi

      Given kullanici jollyTur anasayfasina gider
      When footer alaninin gorundugunu test eder
      Then Hakkimizda sayfasina gider ve sayfayi dogrular
      Then Misafir Iliskiler'i sayfasina gider ve sayfayi dogrular
      Then İnsan Kaynaklari sayfasina gider ve sayfayi dogrular
      Then Kullanim Sozlesmesi sayfasina gider ve sayfayi dogrular
      Then Bilgi Toplumu Hizmetleri sayfasina gider ve sayfayi dogrular
      Then Satis Ofislerimiz sayfasina gider ve sayfayi dogrular
      Then İletisim sayfasina gider ve sayfayi dogrular


    Scenario: TC Footer alaninda bulunan sosyal medya ogelerinin dogru calistiginin kontrol edilmesi
      Given kullanici jollyTur anasayfasina gider
      When sosyal medya alaninin gorundugunu test eder
      Then facebook linkine tiklar ve sayfayi dogrular
      Then X linkine tiklar ve sayfayi dogrular
      Then youtube linkine tiklar ve sayfayi dogrular
      Then vimeo linkine tiklar ve sayfayi dogrular
      Then onedio linkine tiklar ve sayfayi dogrular
      Then jolly blog linkine tiklar ve sayfayi dogrular


