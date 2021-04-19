package fonksiyonel;

import java.util.Arrays;
import java.util.List;

// Javada Lambda fonksiyonları sadece Fonksiyonel interface'ler ile kullanılabilir.
// Sadece bir adet abstract metodu olan interface'lere fonksiyonel interface denilir.
// Kullanıcı isterse kendi fonksiyonel interface'ini yazabilir. Ama Javada hali hazırda
// Consumer, Function, Supplier, Predicate gibi tanımlanmış interfaceler bulunmaktadır.
// Ayrıca bu interface'leri parametre olarak alabilen High Order Function (HOF)'lar da bulunmaktadır.
// foreEach(), map(), filter(), reduce() gibi HOF'lar fonksiyonel interfaceler ile çalıştığı için
// içerisinde Lambda fonksiyonları yazmak mümkündür.
// Javada genelde bu gibi fonksiyonlar üzerinden Lambda ifadeleri kullanılmaktadır.

public class Lambda01Kurallar {
    public static void main(String[] args) {
        List<Integer> liste = Arrays.asList(1,2,3,4,5);

        // forEach() bir collection'nın iterasyonu için kullanılan HOF'dur.
        // Parametre olarak bir lambda fonksiyonu alabilir.
        // Dizinin Elemanlarını yazdıralım
           liste.forEach(x->System.out.println(x));
        System.out.println("==========================");

        // Listenin elemanlarini 2 arttirarak yazdiralim
        liste.forEach(t-> System.out.println(t+2));

        System.out.println("\nEger satir sayisi 1'den fazla ise {} kullanmaliyiz..");
        liste.forEach(t-> {

                int miktar = 2;
                System.out.println(t+miktar);
        });

        System.out.println("Veri tipi kullanilirsa Explit");
        liste.forEach((Integer x) -> System.out.println(x*2 + " "));

        System.out.println("Bir dis degisken kullanalim");
        int deger=6;
        liste.forEach(t-> System.out.println(t+deger));

        // Method referansi ==> Class adi : Method adi
        System.out.println("\nMethod referans'i kullanimi");
        liste.forEach(Lambda01Kurallar::yazdir);

    }

    public static void yazdir(int x) {
        System.out.print(x + " ");
    }



}
