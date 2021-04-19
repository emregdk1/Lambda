package streamOrnekler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream06Files {
    public static void main(String[] args) throws IOException {

        String path="C:\\Users\\EMre\\IdeaProjects\\Lambda\\src\\streamOrnekler\\mars.txt";
        Stream <String> satirlar= Files.lines(Path.of("C:\\Users\\EMre\\IdeaProjects\\Lambda\\src\\streamOrnekler\\mars.txt"));
       satirlar.forEach(System.out::println);
       System.out.println("=============================================================");

       // Bir dosyadan okunan satirlari büyük harf olarak konsola yazdiralim
       Files.lines(Paths.get(path)).map(String::toUpperCase).forEach(System.out::println);

        System.out.println("====================================================");
       // Dosyadan sadece ilk satiri okuyarak büyük harf olarak konsola yazdiralim
        Files.lines(Path.of(path)).limit(1).map(t->t.toUpperCase()).forEach(System.out::println);

        System.out.println("====================================================");
        // Dosyadan sadece 3 ve 4. satilari yazdirmak istiyoruz
        Files.lines(Path.of(path)).
                map(String::toUpperCase).skip(2).limit(2).
                forEach(System.out::println);

        System.out.println("===================================================");

        // "bu"(kücük veya büyük) kelimesinin kac adet gectigini yazdiralim
        System.out.println(Files.lines(Path.of(path)).map(String::toLowerCase).
                filter(t->t.contains("o")).count());


        System.out.println("==============================================");
        // Dosyadaki tüm farkli kelimeleri alt alta yazdiralim
        Files.lines(Path.of(path)).map(t->t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).distinct().forEach(System.out::println);

        // Kelimeler içerisinde M veya m harfi olanları sayalım ve sonucu konsola yazdıralım.
        long mSayisi = Files.lines(Paths.get(path)).map(t->t.toLowerCase().split("")).
                flatMap(Arrays::stream).
                filter(t-> t.equals("m")).count();
        System.out.println("M harfinin sayısı:" + mSayisi);
        //Boşluk ve noktalama işaretleri hariç dosyada kaç adet karakter kullanıldığını
        // hesaplayarak sonucu konsola yazdıran uygulamayı yazınız.
        //  \\W "a-z" U "A-Z" U "0-9" U "_" hariç tüm karakterler demektir.
        System.out.println(Files.lines(Paths.get(path)).map(t->t.replace("_","").
                replaceAll("\\W","").split("")).
                flatMap(Arrays::stream).
                count());








    }
}
