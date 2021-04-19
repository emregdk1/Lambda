package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03Integer {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(9);
        list.add(13);
        list.add(4);
        list.add(9);
        list.add(2);
        list.add(-2);
        list.add(4);
        list.add(12);
        list.add(15);
        list.add(500);
        list.add(-15);
        list.add(-1);
        System.out.println("En Büyük Deger: " + enBüyükBul(list));
        System.out.println("En Büyük Deger: " + enBüyükBul1(list));
        System.out.println("En Büyük Deger: " + enBüyükBul2(list));
        System.out.println("En Kücük Deger: " + enKücükBul(list));
        System.out.println("Carpim Deger: " + capimBul(list));
        System.out.println("Kac adet 9 sayisi var: " + kacTekrar(list));
        List<Integer> negatifSayiList=negatifList(list);
        System.out.println("Negatif Sayilarin Listesi: "+ negatifSayiList);
        List<Integer> tekSayilarinSiraliKaresiList=tekKareSiraliList(list);
        System.out.println("Tek Sayilarin Sirali Karesi: "+tekSayilarinSiraliKaresiList);
    }
    public static int enBüyükBul(List<Integer> list) {
        return list.stream().reduce(0, (x, y) -> x > y ? x : y);
    }
    public static int enBüyükBul1(List<Integer> list) {
        return list.stream().reduce(0, Math::max);
    }
    public static int enBüyükBul2(List<Integer> list) {
        return list.stream().sorted().reduce(0, (x, y) -> y);
    }
    public static int enKücükBul(List<Integer> list) {
        return list.stream().reduce(0, (x, y) -> x < y ? x : y);
    }
    public static int capimBul(List<Integer> list) {
        return list.stream().reduce(1, (x, y) -> x * y);
    }
    public static int kacTekrar(List<Integer> list) {
        return (int) list.stream().filter(x-> x==9).count();
    }
    // Bir listedeki negatif sayilari ayri bir liste olarak döndüren methodu yazalim
    public static List<Integer> negatifList(List<Integer> list) {
        return list.stream().filter(x-> x<0).collect(Collectors.toList());
    }
    // Listedeki tek elemanlarin karelerini tekrarsiz
    // ve sirali olarak bir listeye kaydeden method'u yaziniz
    public static List<Integer> tekKareSiraliList(List<Integer> list){
        return list.
                stream().
                filter(Stream01Integer::tekMi).
                map(x-> x*x). // map(x-> (int) Math.pow(x,2)) ile üssü pratik kullanabiliriz
                distinct().
                sorted(Comparator.reverseOrder()). //  Ters sirali yapar
                collect(Collectors.toList());
    }

}
