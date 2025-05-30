import java.util.*;
// import java.text.DecimalFormat;

class Hang {
    String tenHang;
    int soLuong;
    double gia;

    public Hang(String tenHang, int soLuong, double gia) {
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public double tinhTien() {
        return soLuong * gia;
    }
}

class DonHang {
    String maDon;
    String hoTen;
    String soDienThoai;
    String ngayMua;
    List<Hang> danhSachHang;
    double tongTien;

    public DonHang(String maDon, String hoTen, String soDienThoai, String ngayMua, List<Hang> danhSachHang) {
        this.maDon = maDon;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.ngayMua = ngayMua;
        this.danhSachHang = danhSachHang;
        this.tongTien = tinhTongTien();
    }

    private double tinhTongTien() {
        double tong = 0;
        for (Hang hang : danhSachHang) {
            tong += hang.tinhTien();
        }
        return Math.round(tong);
    }

    public void capNhatHoTen(String hoTenMoi) {
        this.hoTen = hoTenMoi;
        this.maDon = taoMaDonHang(hoTenMoi);
    }

    private String taoMaDonHang(String hoTen) {
        String[] words = hoTen.split("\\s+");
        StringBuilder ma = new StringBuilder();
        for (String word : words) {
            ma.append(word.charAt(0));
        }
        return ma.toString().toUpperCase() + maDon.substring(maDon.length() - 3);
    }

    @Override
    public String toString() {
        return maDon + " " + hoTen + " " + ngayMua + " " + (int) tongTien;
    }
}

public class BaiTap4 {
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
                danhSachHang.add(new Hang(tenHang, soLuong, gia));
            }

            String maDon = taoMaDonHang(hoTen, i + 1);
            danhSachDonHang.add(new DonHang(maDon, hoTen, soDienThoai, ngayMua, danhSachHang));
        }

        String maDonCanSua = sc.nextLine();
        boolean timThay = false;

        for (DonHang donHang : danhSachDonHang) {
            if (donHang.maDon.equals(maDonCanSua)) {
                timThay = true;
                System.out.println(donHang);
                String hoTenMoi = sc.nextLine();
                donHang.capNhatHoTen(hoTenMoi);
                System.out.println(donHang);
                break;
            }
        }

        if (!timThay) {
            System.out.println("khong co don hang");
        }

        sc.close();
    }

    private static String taoMaDonHang(String hoTen, int soThuTu) {
        String[] words = hoTen.split("\\s+");
        StringBuilder ma = new StringBuilder();
        for (String word : words) {
            ma.append(word.charAt(0));
        }
        return ma.toString().toUpperCase() + String.format("%03d", soThuTu);
    }
}
