public class App {

    public static double TinhPhiDichVu(double quangDuong, int thoiGianCho, int voucher, boolean thoiTietXau) {
        if (quangDuong <= 0 || quangDuong > 100) {
            throw new IllegalArgumentException("Quang duong khong hop le");
        }
        if (thoiGianCho < 0 || thoiGianCho > 10) {
            throw new IllegalArgumentException("Thoi gian cho khong hop le");
        }
        if (voucher < 0 || voucher > 100) {
            throw new IllegalArgumentException("Voucher khong hop le");
        }
        double cuoc = 0;
        if (quangDuong <= 2) {
            cuoc = 14000;
        } else {
            cuoc = 14000 + (quangDuong - 2) * 5000;
        }
        cuoc += thoiGianCho * 500;
        if (thoiTietXau) {
            cuoc *= 1.7;
        }
        cuoc *= (1 - voucher / 100.0);
        cuoc *= 1.1;
        return Math.floor(cuoc * 10) / 10.0;
    }

    public static void main(String[] args) {
        double gia = TinhPhiDichVu(5, 5, 5, false);
        System.out.println("Giá cước: " + gia + " VND");
    }
}
