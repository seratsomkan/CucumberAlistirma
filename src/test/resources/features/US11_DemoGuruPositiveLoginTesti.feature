


  Feature: US01 Kullanici test automation sayfasına giderek uye olmayı dener
    @wip
    Scenario: TC01 kullanici gecerli bilgileri girerek hesap olusturabilmeli
      Given kullanici test data dosyasinda verilen "automationUrl" anasayfaya gider
      And user sign up linkine tiklar
      Then user New User Signup! bolumune bilgileri girer
      And signUp butonuna basar
      Then user kisisel bilgilerini ve iletisim bilgilerini girer
      And user Create Account butonuna basar
      Then hesap olustugunu test edin

