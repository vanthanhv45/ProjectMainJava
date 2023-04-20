/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class PhieuNhapDTO {

    private int MaPN;
    private Date NgayNhap;
    private int MaNV;

    public PhieuNhapDTO(int MaPN, Date NgayNhap, int MaNV) {
        this.MaPN = MaPN;
        this.NgayNhap = NgayNhap;
        this.MaNV = MaNV;
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

}
