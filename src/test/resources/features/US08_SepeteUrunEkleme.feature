

  Feature: Kullanici sepete urun ekler ve sepeti goruntuler

    Scenario: TC09 kullanici urunu sepete eklemeli ve sepetteki urunleri goruntuleyebilmeli
      Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
      And cookies'leri kapat
      Then arama kutusuna "buzdolabı" kelimeyi yazip aratir
      Then soldaki menuden "bosch" markasini secer
      And soldaki menuden fiyat araligini "40000" ila "45000" arasinda yapar