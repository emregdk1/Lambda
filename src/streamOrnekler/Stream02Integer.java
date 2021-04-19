package streamOrnekler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stream02Integer {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(9);
        list.add(13);
        list.add(4);
        list.add(9);
        list.add(2);
        list.add(4);
        list.add(12);
        list.add(15);
        tekKareYazdir(list);
        System.out.println("\n====================");
        System.out.println("TOPLAM: " + tekKüpToplam(list));  // TOPLAM: 7030
        System.out.println("TOPLAM(Math::addExact): " + tekKüpToplam2(list)); // TOPLAM(Math::addExact): Optional[7030]
        System.out.println("TOPLAM(Integer::sum)  : " + tekKüpToplam3(list)); // TOPLAM(Integer::sum)  : 7030
    }

    public static void tekKareYazdir(List<Integer> l) {
        l.stream().filter(Stream01Integer::tekMi).map(x -> x * x).forEach(Stream01Integer::yazdir);
        // 81 169 81 225
        System.out.println();
        l.stream().distinct().filter(Stream01Integer::tekMi).map(x -> x * x).forEach(Stream01Integer::yazdir);
        // 81 169 225 distinct ile tekrarlari yazdirmadik
        // Özellikle stream()'dan sonra distinct'i yazdik cünkü hiz kazanmak icin
    }

    public static int tekKüpToplam(List<Integer> l) {
        return l.stream().filter(Stream01Integer::tekMi).map(x -> x * x * x).reduce(0, (x, y) -> x + y);
    }

    public static Optional<Integer> tekKüpToplam2(List<Integer> l) {
        return l.stream().filter(Stream01Integer::tekMi).map(x -> x * x * x).reduce(Math::addExact);
    }

    public static int tekKüpToplam3(List<Integer> l) {
        return l.stream().filter(Stream01Integer::tekMi).map(x -> x * x * x).reduce(0, Integer::sum);
    }


}
