package SLIDE1;
import java.util.ArrayList;

public class Slide1main {
    public static void main(String[] args) {
        ArrayList<Slide1> danhsach = new ArrayList<Slide1>();
        Slide1 s1 = new Slide1("Honda", 2020);
        Slide1 s2 = new Slide1();

        s2.setHangxe("Yamaha");
        s2.setNamsx(2021);
        danhsach.add(s1);
        danhsach.add(s2);
        for (Slide1 s : danhsach) {
            s.xuat();
        }
    }
}
