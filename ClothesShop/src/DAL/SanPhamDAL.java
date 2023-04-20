/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAL;

import DTO.SanPhamDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author ACER
 */
public class SanPhamDAL {

//    public static ArrayList<SanPhamDTO> GetListSP() throws Exception {
//        ConnectDAL connect = new ConnectDAL();
//        ArrayList<SanPhamDTO> listsPham = new ArrayList<>();
//        String query = "Select * from SANPHAM ";
//        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//            String ma = rs.getString(1);
//            String ten = rs.getString(2);
//            String gia = rs.getString(3);
//            SanPhamDTO sp = new SanPhamDTO(ma, ten, gia);
//            listsPham.add(sp);
//        }
//        rs.close();
//        stmt.close();
//        connect.getConnect().close();
//        return listsPham;
//    }
//
//    public static ArrayList<SanPhamDTO> getListSpByCategoryId(int cat_id) throws Exception {
//        ConnectDAL connect = new ConnectDAL();
//        ArrayList<SanPhamDTO> listsPham = new ArrayList<>();
//        String query = "Select * from sanpham where  id = ?";
//        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
//        stmt.setInt(1, cat_id);
//        ResultSet rs = stmt.executeQuery();
//        return null;
//    }
}
