package streamOrnekler;


import java.util.ArrayList;
import java.util.List;

public class Stream01Integer {

    public static <Integer> void main(String[] args) {
        List<java.lang.Integer> rakamlar = new ArrayList<>();
        rakamlar.add(5);
        rakamlar.add(7);
        rakamlar.add(7);
        rakamlar.add(9);
        rakamlar.add(-1);
        rakamlar.add(2);
        rakamlar.add(4);
        rakamlar.add(-1000);
        rakamlar.add(4);
        System.out.println("\n======Tek Sayilar======");
        rakamlar.stream().filter(t -> t % 2 != 0).forEach(x -> System.out.print(x + " "));
        System.out.println("\n=======Cift Sayilar======");
        rakamlar.stream().filter(t -> t % 2 == 0).forEach(Stream01Integer::yazdir);
        System.out.println("\n======Tek Sayilar======");
        rakamlar.stream().filter(Stream01Integer::tekMi).forEach(Stream01Integer::yazdir);
        System.out.println("\n======Cift Sayilar(Method)======");
        ciftlerYazdir(rakamlar);
    }

    public static void ciftlerYazdir(List<Integer> list) {
        //  list.stream().filter(x-> x%2==0).forEach(x-> System.out.print(x+" "));
        list.stream().filter(Stream01Integer::ciftMi).forEach(Stream01Integer::yazdir);
    }

    public static boolean tekMi(int x) {
        return x % 2 != 0;
    }

    public static boolean ciftMi(int x) {
        return x % 2 == 0;
    }

    public static void yazdir(int x) {
        System.out.print(x + " ");
    }

}


