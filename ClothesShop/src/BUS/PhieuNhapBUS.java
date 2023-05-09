/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAL.PhieuNhapDAL;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author ACER
 */
public class PhieuNhapBUS {

    public static int LayMaNhanVien(String tendangnhap) throws Exception {
        return PhieuNhapDAL.LayMaNhanVien(tendangnhap);
    }

    //
    public static void ThemPhieuNhap(PhieuNhapDTO sp) throws Exception {
        PhieuNhapDAL.ThemPhieuNhap(sp);
    }

    // them chi tiet phieu nhap
    public static void ThemChiTietPN(ChiTietPhieuNhapDTO pn) throws Exception {
        PhieuNhapDAL.ThemChiTietPN(pn);
    }

    // cap nhat so luong vs gia san pham
    public static void CapNhatSoLuongVsGia(SanPhamDTO sanpham) throws Exception {
        PhieuNhapDAL.CapNhatSoLuongVsGia(sanpham);
    }

    // kiem tra ma phieu nhap
    public static boolean KiemTraMaPhieuNhap(int mapn) throws Exception {
        return PhieuNhapDAL.KiemTraMaPhieuNhap(mapn);
    }

    // lay ds phieu nhap
    public static ArrayList<PhieuNhapDTO> LayDsPhieuNhap() throws Exception {
        return PhieuNhapDAL.LayDsPhieuNhap();
    }

    // lay chi tiet phieu nhap tu ma ;phieu nhap
    public static ArrayList<ChiTietPhieuNhapDTO> LayChiTietPhieuNhap(int mapn) throws Exception {
        return PhieuNhapDAL.LayChiTietPhieuNhap(mapn);
    }
    // tim kiem theo ma 
    public  static  ArrayList<PhieuNhapDTO> TimKiemPnTheoMa(int mapn) throws Exception{
        return PhieuNhapDAL.TimKiemPnTheoMa(mapn);
    }
    // xoa phieu nhap
    public static void XoaPhieuNhap(int maphieunhap) throws Exception{
        PhieuNhapDAL.XoaPhieuNhap(maphieunhap);
    }
    // loc phieu nhap
    public static ArrayList<PhieuNhapDTO> LocPhieuNhap(Timestamp ngaybatdau , Timestamp ngayketthuc) throws Exception{
        return PhieuNhapDAL.LocPhieuNhap(ngaybatdau, ngayketthuc);
    }
}
