import java.util.*;
// import java.text.DecimalFormat;

class Hang {
    private String maHang;
    private String tenHang;
    private int soLuong;
    private double gia;

    public Hang(String tenHang, int soLuong, double gia, int index) {
        this.maHang = "MH" + String.format("%03d", index);
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public double tinhTien() {
        return soLuong * gia;
    }
}

class DonHang {
    private String maDon;
    private String hoTen;
    private String soDienThoai;
    private String ngayMua;
    private List<Hang> danhSachHang;
    private double tongTien;

    public DonHang(String hoTen, String soDienThoai, String ngayMua, List<Hang> danhSachHang, int index) {
        this.maDon = taoMaDon(hoTen, index);
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.ngayMua = ngayMua;
        this.danhSachHang = danhSachHang;
        this.tongTien = tinhTongTien();
    }

    private String taoMaDon(String hoTen, int index) {
        String[] parts = hoTen.split(" ");
        StringBuilder ma = new StringBuilder();
        for (String part : parts) {
            ma.append(part.charAt(0));
        }
        return ma.toString().toUpperCase() + String.format("%03d", index);
    }

    private double tinhTongTien() {
        double sum = 0;
        for (Hang hang : danhSachHang) {
            sum += hang.tinhTien();
        }
        return Math.round(sum);
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public String getMaDon() {
        return maDon;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getTongTien() {
        return tongTien;
    }
}

public class BaiTap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        List<DonHang> danhSachDonHang = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String hoTen = sc.nextLine();
            String soDienThoai = sc.nextLine();
            String ngayMua = sc.nextLine();
            int n = Integer.parseInt(sc.nextLine());
            List<Hang> danhSachHang = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String tenHang = sc.nextLine();
                int soLuong = Integer.parseInt(sc.nextLine());
                double gia = Double.parseDouble(sc.nextLine());
                danhSachHang.add(new Hang(tenHang, soLuong, gia, j + 1));
            }

            danhSachDonHang.add(new DonHang(hoTen, soDienThoai, ngayMua, danhSachHang, i + 1));
        }

        int namTimKiem = Integer.parseInt(sc.nextLine());
        boolean found = false;

        for (DonHang donHang : danhSachDonHang) {
            if (donHang.getNgayMua().endsWith(String.valueOf(namTimKiem))) {
                found = true;
                System.out.println(donHang.getMaDon() + " " + donHang.getHoTen() + " " + donHang.getNgayMua() + " "
                        + (int) donHang.getTongTien());
            }
        }

        if (!found) {
            System.out.println("khong co don hang");
        }
    }
}