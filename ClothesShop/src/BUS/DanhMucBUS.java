/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAL.DanhMucSpDAL;
import DTO.DanhMucDTO;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class DanhMucBUS {

// hàm kiểm tra xem danh muc đã tồn tại chưa
    public static boolean kiemtraDM(int Madanhmuc, String tendanhmuc) throws Exception {
        return DanhMucSpDAL.KiemTraDanhMuc(Madanhmuc, tendanhmuc);
    }

    // kiểm tra xem mã dnah mục đã tồn tại chưa
    public static boolean KiemTraMaDanhMuc(int madanhmuc) throws Exception {
        return DanhMucSpDAL.KiemTraMaDanhMuc(madanhmuc);
    }

    // kiểm tra xem tên danh mục đã tồn tại chưae
    public static boolean KiemTraTenDanhMuc(String TenDanhMuc, int MadanhMuc) throws Exception {
        return DanhMucSpDAL.KiemTraTenDanhMuc(TenDanhMuc, MadanhMuc);
    }

    // them 1 danh muc
    public static void ThemDanhMuc(DanhMucDTO danhmuc) throws Exception {
        DanhMucSpDAL.ThemDanhMuc(danhmuc);
    }
    // lay danh sach danh muc

    public static ArrayList<DanhMucDTO> LayDsDanhMuc() throws Exception {
        return DanhMucSpDAL.LayDanhSachDanhMuc();
    }

    // cap nhat thong tin dnah muc
    public static void CapNhatDanhMuc(String TenDanhMuc, int MaDanhMuc) throws Exception {
        DanhMucSpDAL.CapNhatThongTinDanhMuc(MaDanhMuc, TenDanhMuc);
    }

    // xoa danh muc
    public static void XoaDanhMuc(int Madanhmuc) throws Exception {
        DanhMucSpDAL.XoaDanhMuc(Madanhmuc);
    }
    // tìm kiếm danh mục theo tên
    public static ArrayList<DanhMucDTO> TimKiemDanhMucTheoTen(String tendanhmuc) throws Exception{
        return DanhMucSpDAL.TimKiemDanhMucTheoTen(tendanhmuc);
    }
    // tìm kiếm danh mục theo mã
    public static ArrayList<DanhMucDTO> TimKiemDanhMucTheoMa(String madanhmuc) throws Exception{
        return DanhMucSpDAL.TimKiemDanhMucTheoMa(madanhmuc);
    }
        // lay ten danh muc bang ma danh muc
    public static String LayTenDanhMucTheoMa(int madanhmuc) throws Exception {
        return DanhMucSpDAL.LayTenDanhMucTheoMa(madanhmuc);
    }

}
