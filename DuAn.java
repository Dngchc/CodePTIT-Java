import java.util.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class DuAn {
    private String ma;
    private String tenDuAn;
    private double tongChiPhi;
    private static int sMa;

    public DuAn(String tenDuAn, double tongChiPhi) {
        this.tenDuAn = tenDuAn;
        this.tongChiPhi = tongChiPhi;
        sMa++;
        this.ma = "CNTT" + String.format("%03d", sMa);
    }

    public double getTienDot1() {
        return 0.3 * tongChiPhi;
    }

    public String toString() {
        return ma + " " + tenDuAn + " " + Math.round(tongChiPhi) + " " + Math.round(getTienDot1());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<DuAn> a = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            a.add(new DuAn(in.nextLine(), Double.parseDouble(in.nextLine())));
        }
        a.forEach(da -> System.out.println(da));
    }
}