

  Feature: Kullanici siteden urun arar

    Scenario Outline: TC08 Kullanici excel'deki urunleri istenen miktarda bulabilmeli

      Given kullanici test data dosyasinda verilen "nUrl" anasayfaya gider
      Then urun excelindeki "<istenenSatir>" daki urunun min. miktarini ve urun ismini kaydeder
      And urun ismini anasayfasinda arar ve sonuc sayisini kaydeder
      And bulunan urun sayisinin "<istenenSatir>" da verilen min. miktardan fazla oldugunu test eder
      Then bulunan sonuc sayisini excelde "<istenenSatir>" daki 4.sutuna yazdirir
      Examples:
        | istenenSatir |
        | 2 |
        | 3 |
        | 4 |
        | 5 |
        | 6 |
        | 7 |
        | 8 |