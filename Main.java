import java.util.Scanner;
 //Kullanıcıdan veri alabilmek için Scanner Kütüphanesi prpjeye dağil edildi
public class Main {
    public static void main(String[] args) {

        //mesafe, yaş ve ucuç tip için değişlkenler oluşturuldu
        int yas, mesafe, ucusTipi;


        //Uçuş tarifesi, yaş durumu ve ucuş şekili için değişkenler oluşturuldu
        double normalTarife, yasDurumu, ucusSecimi, total;

        //fiyat bilgilerinin proje boyunca her senaryoda sabit kalması için Final key kullanıldı
        final double mesafeBasina = 0.10, cocukIndirimi = 0.50, genclikIndirimi = 0.10, yasliIndirimi = 0.30, ciftYonbilet = 0.20;


        Scanner Input = new Scanner(System.in);


        //Kullanıcıdan mesafe ve yaş bilgileri alınıyor.
        System.out.print("Mesafe Bilgisi Giriniz: ");
        mesafe = Input.nextInt();

        System.out.print("Yaşınızı Bilgisi Giriniz: ");
        yas = Input.nextInt();


        //kullanıcıdan çift ve ya tek yön yapacağı uçuş bilgisi için seçim yaptırılıyor.
        System.out.print("Bir Uçuş Tipi Seçiniz: 1 = Tek yön, 2 = Cift Yön");
        ucusTipi = Input.nextInt();


        //Kullanıcının girdiği bilgilerle fiyatlandırma yapılıyor
        if ((mesafe > 0) && (yas > 0)) {
            if ((ucusTipi == 1) || (ucusTipi == 2)) {
                normalTarife = mesafe * mesafeBasina;

                if ((yas >= 1) && (yas <= 12)) {
                    //indirim icin uygun yas araligi kontrolu yapılıyor
                    switch (ucusTipi) {
                        //uçuş tipi kontrolü yapılıyor
                        case 1:
                            yasDurumu = normalTarife * cocukIndirimi;
                            total = normalTarife - yasDurumu;
                            System.out.print("Fiyat bilgisi: " + total + " TL" + "\n(0-12 yaş indirimi dahil)");
                            break;
                        case 2:
                            // ilgili şartlar yerine getirliyorsa indirimler uygulanıyor
                            yasDurumu = normalTarife * cocukIndirimi;
                            total = normalTarife - yasDurumu;
                            ucusSecimi = total * ciftYonbilet;
                            total = (total - ucusSecimi) * 2;
                            System.out.print("Fiyat bilgisi: " + total + " TL" + "\n(0-12 yaş ve Çift yön indirimi dahil)");
                            //tutar kullaniciya gösterilmek üzere ekrana bastırılıyor
                            break;
                    }
                } else if ((yas > 12) && (yas <= 24)) {
                    switch (ucusTipi) {
                        case 1:
                            yasDurumu = normalTarife * genclikIndirimi;
                            total = normalTarife - yasDurumu;
                            System.out.print("Fiyat bilgisi: " + total + " TL" + "\n(13-24 yaş indirimi dahil)");
                            break;
                        case 2:
                            yasDurumu = normalTarife * genclikIndirimi;
                            total = normalTarife - normalTarife;
                            ucusSecimi = total * ciftYonbilet;
                            total = (total - ucusSecimi) * 2;
                            System.out.print("Fiyat bilgisi: " + total + " TL" + "\n(13-24 yaş ve Çift yön indirimi dahil)");
                            break;
                    }
                } else if (yas >= 65) {
                    switch (ucusTipi) {
                        case 1:
                            yasDurumu = normalTarife * yasliIndirimi;
                            total = normalTarife - yasDurumu;
                            System.out.print("Fiyat bilgisi: " + total + " TL" + "\n(65 yaş indirimi dahil)");
                            break;
                        case 2:
                            yasDurumu = normalTarife * yasliIndirimi;
                            total = normalTarife - yasDurumu;
                            ucusSecimi = total * ciftYonbilet;
                            total = (total - ucusSecimi) * 2;
                            System.out.print("Fiyat bilgisi: " + total + " TL" + "\n(65 yaş ve Çift yön indirimleri dahil)");
                            break;
                    }
                } else {

                    if (ucusTipi == 1) {
                        //yukardaki  swich yapısıda kullanılabilirdi farklılık için kullanıldı

                        System.out.print("Fiyat bilgisi: " + normalTarife + " TL" + "\n(İndirimsiz fiyat)");
                        //indirim yaş aralıgın da olamdıgı için normal hesaplama yapılıyor
                    } else {
                        //çift yön ucus kontrolü
                        ucusSecimi = normalTarife * ciftYonbilet;
                        total = (normalTarife - ucusSecimi) * 2;
                        System.out.print("Fiyat bilgisi: " + total + " TL" + "\n(Çift yön indirimi dahil)");
                    }
                }
            } else {
                System.out.println("Lütfen bilgileri doğru girfiğinizden emin olun!");
            }
        }
    }
}