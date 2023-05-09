/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAL.DanhMucSpDAL;
import DAL.SanPhamDAL;
import DTO.DanhMucDTO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class SanPhamBUS {

//    public static ArrayList<SanPhamDTO> getlistsp() throws Exception {
//        return SanPhamDAL.GetListSP();
//    }
    // lay danh sach danh muc
    public static ArrayList<DanhMucDTO> LayDanhSachDanhMuc() throws Exception {
        return SanPhamDAL.LayDsDanhMuc();
    }

    // kiem tra xem  san pham da ton tai chua
    public static boolean KiemTraSanPham(String tensanpham, int masanpham) throws Exception {
        return SanPhamDAL.KiemTraSanPham(tensanpham, masanpham);
    }

    // kiem tra ma san pham
    public static boolean KiemTraMaSanPham(int masanpham) throws Exception {
        return SanPhamDAL.KiemTraMaSanPham(masanpham);
    }

    // kiem tra ten san pham
    public static boolean KiemTraTenSanPham(String tensanpham,int masp) throws Exception {
        return SanPhamDAL.KiemTraTenSanPham(tensanpham,masp);
    }

    // them san pham
    public static void ThemSanPham(SanPhamDTO sanpham) throws Exception {
        SanPhamDAL.ThemSanPham(sanpham);
    }

    // lay ds san pham
    public static ArrayList<SanPhamDTO> LayDanhSachSanPham() throws Exception {
        return SanPhamDAL.LayDanhSachSanPham();
    }
    // cap nhat thong tin san pham
    public static void CapNhatSanPham(String tensp , int madanhmuc , String mota) throws Exception{
        SanPhamDAL.CapNhatSanPham(tensp, madanhmuc, mota);
    }
    
    // xoa san pham
    public static void XoaSanPham(int masanpham) throws Exception{
        SanPhamDAL.XoaSanPham(masanpham);
    }
    // tim kiem theo ten
    public static ArrayList<SanPhamDTO> TimKiemTheoTen(String noidungtimkiem) throws Exception{
        return SanPhamDAL.TimKiemTheoTen(noidungtimkiem);
    }
        // tim kiem theo ma
    public static ArrayList<SanPhamDTO> TimKiemTheoMa(int noidungtimkiem) throws Exception{
        return SanPhamDAL.TimKiemTheoMa(noidungtimkiem);
    }
    // lay san pham theo ma
    public static SanPhamDTO LaySanPhamTheoMa(int masp) throws Exception{
        return SanPhamDAL.LaySanPhamTheoMa(masp);
    }
}
