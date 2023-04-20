/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class ChiTietPhieuNhapDTO {

    private int MaPN;
    private int MaSp;
    private int SoLuong;
    private float DonGia;

    public ChiTietPhieuNhapDTO(int MaPN, int MaSp, int SoLuong, float DonGia) {
        this.MaPN = MaPN;
        this.MaSp = MaSp;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public int getMaSp() {
        return MaSp;
    }

    public void setMaSp(int MaSp) {
        this.MaSp = MaSp;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

}
