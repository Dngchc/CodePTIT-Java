import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BaiTap2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<GiangVien> a = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            a.add(new GiangVien(in.nextLine(),
                    Double.parseDouble(in.nextLine())));
        }
        a.forEach(gv -> System.out.println(gv));
    }
}

class GiangVien {
    private String ma;
    private String hoten;
    private double hsLuong;
    private int sMa;

    private static int counter = 1;

    public GiangVien(String hoten, double hsLuong) {
        this.hoten = hoten;
        this.hsLuong = hsLuong;
        this.sMa = counter++;
        this.ma = String.format("PM%03d", this.sMa);
    }

    public double getLuong() {
        return hsLuong * 300000;
    }

    public String toString() {
        return ma + " " + hoten + " " + hsLuong + " " + Math.round(getLuong());
    }
}