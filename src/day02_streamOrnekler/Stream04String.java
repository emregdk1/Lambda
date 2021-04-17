package day02_streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream04String {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("Mark");
        list.add("Jackson");
        list.add("Amanda");
        list.add("Mariano");
        list.add("Alberto");
        list.add("Tucker");
        list.add("Christ");
        list.add("Alfonso");
        list.add("Alihandro");
        list.add("Cemalokko");
        System.out.println("Bas Harfi 'A' ile Baslayan Isimler");
        aIleBaslayanlar(list);
        System.out.println("\nTüm Isimlerin Büyük Harfli Hali");
        büyükHarfaCevir(list);
        System.out.println("\nIsimlerin Uzunluklarina Göre Kücük Harfle Siralanmis Hali");
        uzunlugaGöreSiralakücült(list);
        System.out.println("\nVerilen Uzunluktan Büyük Olan Isimler");
        verilenUzunluktanBüyük(list, 5);
        System.out.println("\nIsimlerin Tamami Verilen Uzunluktan Kücük mü?\n" + verilenUzunluktanKücükMü(list, 9));
        System.out.println("\nVerilen Harf ile Baslayan Isim Yok mu?\n" + verilenHarfIleBaslamadiMi(list, "M"));
        System.out.println("\nVerilen Harf ile Biten Herhangi bir Isim Var mi?\n" + verilenHarfIleBitenVarMi(list, "c"));
        System.out.println("\n'A' ile bBaslayan, 'O' ile Biten Isimler\n");
        aIleBaslayipOIleBiten(list);
        System.out.println("\nHer Bir Elemanin Karakter Sayisi ile Uzunluklarina Göre Sirali Hali\n");
        harfiSayisiIleSiraliYazdir(list);
        System.out.println("\n'A' ile bBaslayan, 'O' ile Biten Isimler\n");
        deneme(list);
    }

    //Listedeki bas harfi 'A' ile baslayan isimleri yazdiran methodu tanimlayalim
    public static void aIleBaslayanlar(List<String> list) {
        list.stream().filter(h -> h.startsWith("A")).forEach(System.out::println);
    }

    // Tüm isimleri büyük harfli yazdiralim
    public static void büyükHarfaCevir(List<String> list) {
        list.stream().map(h -> h.toUpperCase()).forEach(System.out::println);
    }

    // Listedeki tüm elemanlari uzunluklarina göre siralayan ve kücük harfe ceviren
    // ve yazdiran methodu tanimlayalim
    public static void uzunlugaGöreSiralakücült(List<String> list) {
        list.stream().
                sorted(Comparator.comparing(t -> t.length())).
                map(t -> t.toLowerCase()).
                forEach(System.out::println);
    }

    // Uzunluklari belirtilen uzunluktan fazla olan isimleri yazdiran methodu yazalim
    public static void verilenUzunluktanBüyük(List<String> list, int uzunluk) {
        list.stream().filter(t -> t.length() > uzunluk).forEach(System.out::println);
    }

    // Listedeki tüm isimlerin uzunluklari verilen uzunluktan Kücük mü
    // diye kontrol eden method yazalim
    // Belirtilen sartlari tüm elemanar saglarsa true, herhangi biri saglamazsa false döndürür
    public static boolean verilenUzunluktanKücükMü(List<String> list, int uzunluk) {
        return list.stream().allMatch(t -> t.length() < uzunluk);
    }

    //Listedeki tüm elemanlarin verilen harf ile baslamadigini kontrol eden method
    // Belirtilen sartlarin tamami saglamazsa true, herhangi biri saglarsa false döndürür
    public static boolean verilenHarfIleBaslamadiMi(List<String> list, String harf) {
        return list.stream().noneMatch(t -> t.startsWith(harf));
    }

    // Listede herhangi bir eleman verilen bir harf ile bitiyor mu diye kontrol eden method
    public static boolean verilenHarfIleBitenVarMi(List<String> list, String harf) {
        return list.stream().anyMatch(t -> t.endsWith(harf));
    }

    // "A" ile baslayip "O" ile biten elemanlari yazdiran method
    public static void aIleBaslayipOIleBiten(List<String> list) {
        list.stream().
                filter(t -> t.startsWith("A") && t.endsWith("O")).
                forEach(System.out::println);
    }

    // Asagidaki formata göre listedeki her bir elemanin uzunlugunu, uzunluklarina göre sirali yazdiran method
    // Ali: 3         Mark: 4            Amanda: 6    vb.
    public static void harfiSayisiIleSiraliYazdir(List<String> list) {
        list.stream().
                sorted(Comparator.comparing(String::length)).
                map(t -> t + ": " + t.length() + "\n").
                forEach(System.out::print);
    }

    public static void deneme(List<String> list) {
        list.stream().
                map(String::toLowerCase).
                filter(t -> t.startsWith("a") && t.endsWith("o")).
                forEach(System.out::println);
    }
}
