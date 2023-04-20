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
public class DonHangDTO {

    private int MaDH;
    private Date NgayLap;
    private int MaKH;
    private int MaNV;

    public DonHangDTO(int MaDH, Date NgayLap, int MaKH, int MaNV) {
        this.MaDH = MaDH;
        this.NgayLap = NgayLap;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
    }

    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int MaDH) {
        this.MaDH = MaDH;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }
    

}
