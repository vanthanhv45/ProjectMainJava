/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAL;

import DTO.DanhMucDTO;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class DanhMucSpDAL {
    // kiểm tra xem mã danh mục hoặc tên danh mục đã tồn tại chưa

    public static boolean KiemTraDanhMuc(int MaDanhMuc, String TenDanhMuc) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "Select count(*) from danh_muc where ma_danh_muc=? or ten_danh_muc=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, MaDanhMuc);
        stmt.setString(2, TenDanhMuc);
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

    // thêm 1 danh mục
    public static void ThemDanhMuc(DanhMucDTO danhmuc) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "Insert into danh_muc  values(?,?)";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, danhmuc.getMaDanhMuc());
        stmt.setString(2, danhmuc.getTenDanhMuc());
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();
    }

    // lấy danh sách danh muc
    public static ArrayList<DanhMucDTO> LayDanhSachDanhMuc() throws Exception {
        ConnectDAL connect = new ConnectDAL();
        ArrayList<DanhMucDTO> DSdanhmuc = new ArrayList<>();
        String query = "select * from danh_muc";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int MaDanhMuc = rs.getInt(1);
            String TenDanhmuc = rs.getString(2);
            DanhMucDTO danhmuc = new DanhMucDTO(MaDanhMuc, TenDanhmuc);
            DSdanhmuc.add(danhmuc);
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return DSdanhmuc;
    }

    // kiểm tra tên danh mục
    public static boolean KiemTraTenDanhMuc(String TenDanhMuc, int MaDanhMuc) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "Select count(*) from danh_muc where ten_danh_muc=? and ma_danh_muc != ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, TenDanhMuc);
        stmt.setInt(2, MaDanhMuc);
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

    // cập nhật thông tin danh mục
    public static void CapNhatThongTinDanhMuc(int MaDanhMuc, String TenDanhMuc) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "update danh_muc set ten_danh_muc = ? where ma_danh_muc = ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, TenDanhMuc);
        stmt.setInt(2, MaDanhMuc);
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();
    }

    // xóa 1 danh muc
    public static void XoaDanhMuc(int MaDanhMuc) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "delete from danh_muc where ma_danh_muc=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, MaDanhMuc);
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();
    }

    // kiểm tra mã danh mục
    public static boolean KiemTraMaDanhMuc(int madanhmuc) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select count(*) from danh_muc where ma_danh_muc=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, madanhmuc);
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

    // tìm kiếm danh mục theo tên
    public static ArrayList<DanhMucDTO> TimKiemDanhMucTheoTen(String tendanhmuc) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from danh_muc where ten_danh_muc like ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, "%" + tendanhmuc + "%");
        ResultSet rs = stmt.executeQuery();
        ArrayList<DanhMucDTO> DsDanhMuc = new ArrayList<>();
        while (rs.next()) {
            int ma = rs.getInt(1);
            String ten = rs.getString(2);
            DanhMucDTO danhmuc = new DanhMucDTO(ma, ten);
            DsDanhMuc.add(danhmuc);
            System.out.println(danhmuc.getMaDanhMuc() + "--" + danhmuc.getTenDanhMuc());
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return DsDanhMuc;
    }

    // tìm kiếm danh mục theo mã
    public static ArrayList<DanhMucDTO> TimKiemDanhMucTheoMa(String madanhmuc) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from danh_muc where ma_danh_muc like ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, "%" + madanhmuc + "%");
        ResultSet rs = stmt.executeQuery();
        ArrayList<DanhMucDTO> dsdanhmuc = new ArrayList<>();
        while (rs.next()) {
            int ma = rs.getInt(1);
            String ten = rs.getString(2);
            DanhMucDTO dm = new DanhMucDTO(ma, ten);
            dsdanhmuc.add(dm);
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return dsdanhmuc;
    }

    // lay ten danh muc bang ma danh muc
    public static String LayTenDanhMucTheoMa(int madanhmuc) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select ten_danh_muc from danh_muc where ma_danh_muc=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, madanhmuc);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String tendanhmuc = rs.getString(1);
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return tendanhmuc;
    }
    
}
