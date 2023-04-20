/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class SanPhamDTO {

    private int MaSP;
    private String TenSP;
    private Float DonGia;
    private int SLTonKho;
    private int DanhMucSP;
    private String MoTaSP;

    public SanPhamDTO(int MaSP, String TenSP, Float DonGia, int SLTonKho, int DanhMucSP, String MoTaSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DonGia = DonGia;
        this.SLTonKho = SLTonKho;
        this.DanhMucSP = DanhMucSP;
        this.MoTaSP = MoTaSP;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSLTonKho() {
        return SLTonKho;
    }

    public void setSLTonKho(int SLTonKho) {
        this.SLTonKho = SLTonKho;
    }

    public int getDanhMucSP() {
        return DanhMucSP;
    }

    public void setDanhMucSP(int DanhMucSP) {
        this.DanhMucSP = DanhMucSP;
    }

    public String getMoTaSP() {
        return MoTaSP;
    }

    public void setMoTaSP(String MoTaSP) {
        this.MoTaSP = MoTaSP;
    }
    
}
