/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAL;

import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import com.mysql.cj.protocol.Resultset;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author ACER
 */
public class PhieuNhapDAL {
    // lấy mã nhân viên bằng tên đăng nhập

    public static int LayMaNhanVien(String tendangnhap) throws Exception {
        ConnectDAL conenct = new ConnectDAL();
        String query = "select ma_nv from nhan_vien where tendangnhap=?";
        PreparedStatement stmt = conenct.getConnect().prepareStatement(query);
        stmt.setString(1, tendangnhap);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int manhanvien = rs.getInt(1);
        return manhanvien;
    }

    // thêm 1 phiếu nhập
    public static void ThemPhieuNhap(PhieuNhapDTO pn) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "insert into phieu_nhap (ma_pn,ma_nv) values(?,?)";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, pn.getMaPN());
        stmt.setInt(2, pn.getMaNV());
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();

    }

    // theme chi tiet phieu nhap
    public static void ThemChiTietPN(ChiTietPhieuNhapDTO ChitietPN) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "insert into phieu_nhap_sp (ma_pn,ma_sp,so_luong,don_gia) values(?,?,?,?)";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, ChitietPN.getMaPN());
        stmt.setInt(2, ChitietPN.getMaSp());
        stmt.setInt(3, ChitietPN.getSoLuong());
        stmt.setInt(4, ChitietPN.getDonGia());
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();
    }

    // cap nhat so luong và gia 
    public static void CapNhatSoLuongVsGia(SanPhamDTO SanPham) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "Update san_pham set don_gia=?,so_luong_ton_kho=? where ma_sp=? ";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, SanPham.getDonGia());
        stmt.setInt(2, SanPham.getSLTonKho());
        stmt.setInt(3, SanPham.getMaSP());
        stmt.executeUpdate();
        stmt.close();
        connect.getConnect().close();
    }

    // kiem tra ma phieu nhap
    public static boolean KiemTraMaPhieuNhap(int mapn) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select count(*) from phieu_nhap where ma_pn = ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, mapn);
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

    // lay ds phieu nhap
    public static ArrayList<PhieuNhapDTO> LayDsPhieuNhap() throws Exception {
        ArrayList<PhieuNhapDTO> DsPhieuNhap = new ArrayList<>();
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from phieu_nhap";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int mapn = rs.getInt(1);
            Date ngaylap = rs.getDate(2);
            int manv = rs.getInt(3);
            PhieuNhapDTO pn = new PhieuNhapDTO(mapn, ngaylap, manv);
            DsPhieuNhap.add(pn);
        }
        return DsPhieuNhap;
    }

    // lay chi tiet phieu nhap tu ma phieu nhap
    public static ArrayList<ChiTietPhieuNhapDTO> LayChiTietPhieuNhap(int mapn) throws Exception {
        ArrayList<ChiTietPhieuNhapDTO> DsChiTiet = new ArrayList<>();
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from phieu_nhap_sp where ma_pn=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, mapn);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int ma_pn = rs.getInt(1);
            int ma_sp = rs.getInt(2);
            int so_luong = rs.getInt(3);
            int gia_sp = rs.getInt(4);
            ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(mapn, ma_sp, so_luong, gia_sp);
            DsChiTiet.add(ctpn);
        }
        return DsChiTiet;
    }

    // tim kiem theo ma phieu nhap
    public static ArrayList<PhieuNhapDTO> TimKiemPnTheoMa(int mapn) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from phieu_nhap where ma_pn like ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, "%" + mapn + "%");
        ResultSet rs = stmt.executeQuery();
        ArrayList<PhieuNhapDTO> DsPhieuNhap = new ArrayList<>();
        while (rs.next()) {
            int ma_pn = rs.getInt(1);
            Date ngaynhap = rs.getDate(2);
            int ma_nv = rs.getInt(3);
            PhieuNhapDTO pn = new PhieuNhapDTO(ma_pn, ngaynhap, ma_nv);
            DsPhieuNhap.add(pn);
        }
        return DsPhieuNhap;
    }

    // xoa phieu nhap
    public static void XoaPhieuNhap(int maphieunhap) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "delete from phieu_nhap where ma_pn = ?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setInt(1, maphieunhap);
        stmt.executeUpdate();
    }

    public static ArrayList<PhieuNhapDTO> LocPhieuNhap(Timestamp ngaybatdau, Timestamp ngayketthuc) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "select * from phieu_nhap where ngay_nhap >= ? and ngay_nhap<=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setTimestamp(1, ngaybatdau);
        stmt.setTimestamp(2, ngayketthuc);
        ArrayList<PhieuNhapDTO> DsPn = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int mapn = rs.getInt(1);
            int manv = rs.getInt(3);
            Date ngaynhap = rs.getDate(2);
            PhieuNhapDTO pn = new PhieuNhapDTO(mapn,ngaynhap, manv);
            DsPn.add(pn);
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return DsPn;
    }
}
