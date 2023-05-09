/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;
import  BUS.DangNhapBUS;
import DAL.DangNhapDAL;

/**
 *
 * @author ACER
 */
public class DangNhapBUS {

// KIEM TRA DANG NHAP
    public static boolean KiemTraDangNhap(String tendangnhap ,String Matkhau) throws Exception{
        return DangNhapDAL.KiemTraDangNhap(tendangnhap, Matkhau);
    }
}
