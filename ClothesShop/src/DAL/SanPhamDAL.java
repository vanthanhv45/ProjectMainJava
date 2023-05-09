/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAL;

import DTO.DanhMucDTO;
import DTO.SanPhamDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ACER
 */
public class SanPhamDAL {

    // lấy danh sách danh mục
    public static ArrayList<DanhMucDTO> LayDsDanhMuc() throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from danh_muc";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<DanhMucDTO> DsDanhMuc = new ArrayList<>();

        while (rs.next()) {
            int ma = rs.getInt(1);
            String ten = rs.getString(2);
            DanhMucDTO dm = new DanhMucDTO(ma, ten);
            DsDanhMuc.add(dm);
        }
        return DsDanhMuc;
    }

    // hàm kiểm tra tên sản phẩm đã tồn tại chưa
    public static boolean KiemTraSanPham(String tensanpham, int masanpham) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select count(*) from san_pham where ten_sp=? or ma_sp=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, tensanpham);
        stmt.setInt(2, masanpham);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        stmt.close();
        connect.getConnect().close();
        if (count > 0) {
            return false;
        }
        return true;
    }

    // thêm sản phẩm
    public static void ThemSanPham(SanPhamDTO sanpham) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "Insert into san_pham  values(?,?,?,?,?,?)";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, sanpham.getMaSP());
        stmt.setString(2, sanpham.getTenSP());
        stmt.setInt(3, sanpham.getDonGia());
        stmt.setInt(4, sanpham.getSLTonKho());
        stmt.setInt(5, sanpham.getDanhMucSP());
        stmt.setString(6, sanpham.getMoTaSP());
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();
    }

    // lay danh sach san pham
    public static ArrayList<SanPhamDTO> LayDanhSachSanPham() throws SQLException, Exception {
        ArrayList<SanPhamDTO> DsSanPham = new ArrayList<>();
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from san_pham";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int masanpham = rs.getInt(1);
            String tensanpham = rs.getString(2);
            int dongia = rs.getInt(3);
            int soluong = rs.getInt(4);
            int danhmuc = rs.getInt(5);
            String mota = rs.getString(6);
            SanPhamDTO sanpham = new SanPhamDTO(masanpham, tensanpham, dongia, soluong, danhmuc, mota);
            DsSanPham.add(sanpham);
        }
        return DsSanPham;
    }

    // kiem tra ma san pham
    public static boolean KiemTraMaSanPham(int masanpham) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select count(*) from san_pham where  ma_sp=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, masanpham);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        stmt.close();
        connect.getConnect().close();
        if (count == 0) {
            return false;
        }
        return true;
    }

    // kiem tra ten san pham
    public static boolean KiemTraTenSanPham(String tensanpham, int masp) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select count(*) from san_pham where  ten_sp=? and ma_sp !=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, tensanpham);
        stmt.setInt(2, masp);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        stmt.close();
        connect.getConnect().close();
        if (count > 0) {
            return false;
        }
        return true;
    }

    // cap nhat thong tin san pham
    public static void CapNhatSanPham(String tensp, int madanhmuc, String mota) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "update san_pham set ten_sp=?,ma_danh_muc=?,mota=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, tensp);
        stmt.setInt(2, madanhmuc);
        stmt.setString(3, mota);
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();
    }

    // xoa san pham
    public static void XoaSanPham(int masanpham) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "delete from san_pham where ma_sp=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, masanpham);
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();
    }

    // tìm kiếm theo tên
    public static ArrayList<SanPhamDTO> TimKiemTheoTen(String noidungtimkiem) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "Select * from san_pham where ten_sp like ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, "%" + noidungtimkiem + "%");
        ResultSet rs = stmt.executeQuery();
        ArrayList<SanPhamDTO> DsSanPham = new ArrayList<>();
        while (rs.next()) {
            int masp = rs.getInt(1);
            String tensp = rs.getString(2);
            int giasp = rs.getInt(3);
            int soluong = rs.getInt(4);
            int danhmuc = rs.getInt(5);
            String mota = rs.getString(6);
            SanPhamDTO sp = new SanPhamDTO(masp, tensp, giasp, soluong, danhmuc, mota);
            DsSanPham.add(sp);
        }
        return DsSanPham;
    }
    // tìm kiếm theo ma

    public static ArrayList<SanPhamDTO> TimKiemTheoMa(int noidungtimkiem) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "Select * from san_pham where ma_sp like ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, "%" + noidungtimkiem + "%");
        ResultSet rs = stmt.executeQuery();
        ArrayList<SanPhamDTO> DsSanPham = new ArrayList<>();
        while (rs.next()) {
            int masp = rs.getInt(1);
            String tensp = rs.getString(2);
            int giasp = rs.getInt(3);
            int soluong = rs.getInt(4);
            int danhmuc = rs.getInt(5);
            String mota = rs.getString(6);
            SanPhamDTO sp = new SanPhamDTO(masp, tensp, giasp, soluong, danhmuc, mota);
            DsSanPham.add(sp);
        }
        return DsSanPham;
    }

    // lấy sản phẩm theo mã 
    public static SanPhamDTO LaySanPhamTheoMa(int masp) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from san_pham where ma_sp=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, masp);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int masanpham = rs.getInt(1);
        String tensp = rs.getString(2);
        int gia_sp = rs.getInt(3);
        int soluong = rs.getInt(4);
        int madanhmuc = rs.getInt(5);
        String mota = rs.getString(6);
        rs.close();
        stmt.close();
        connect.getConnect().close();
        SanPhamDTO sp = new SanPhamDTO(masp, tensp, gia_sp, soluong, madanhmuc, mota);
        return sp;
    }
}
