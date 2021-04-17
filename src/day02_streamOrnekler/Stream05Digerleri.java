package day02_streamOrnekler;

import java.util.stream.IntStream;

public class Stream05Digerleri {
    public static void main(String[] args) {
        // 1'den belirtilen değere kadar olan tamsayıları toplayan ve sonucu döndüren metodu yazınız.
        System.out.println("TOPLAM: "+ topla(4));
        System.out.println("TOPLAM: "+ topla2(4)+"(Verilen sinir dahil)");
        System.out.println("Tek Sayilarin Toplami: "+tekSayilariTopla(1,20));
    }
    public static int topla(int deger){
        return IntStream.range(1,deger).sum();
    }
    public static int topla2(int deger){
        return IntStream.rangeClosed(1,deger).sum();
    }
    public static int tekSayilariTopla(int ilk, int son){
        return IntStream.rangeClosed(ilk,son).filter(t-> t%2==1).sum();
    }
}
