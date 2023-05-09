/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAL;

import com.mysql.cj.protocol.a.result.ResultsetRowsStreaming;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class DangNhapDAL {

    // KIEM TRA THONG TIN DĂNG NHAP
    public static boolean KiemTraDangNhap(String tendangnhap ,String matkhau) throws Exception{
        ConnectDAL connect = new ConnectDAL();
        String query = "select count(*) from nhan_vien where tendangnhap=? and mat_khau=?";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        stmt.setString(1, tendangnhap);
        stmt.setString(2, matkhau);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        if(rs.getInt(1) > 0){
            return  true;
        }
        return false;
    }
}
