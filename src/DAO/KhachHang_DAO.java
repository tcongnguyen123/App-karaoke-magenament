package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Entity.KhachHang;
import Entity.LoaiNhanVien;
import Entity.NhanVien;
import connect_DB.connectDB;


public class KhachHang_DAO {
	public ArrayList<KhachHang> layDSKhachHang() throws Exception {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from KhachHang ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maKH = rs.getString(1).trim();
				String tenKH = rs.getString(2);
				String soDienThoai = rs.getString(3);
				boolean gioiTinh = rs.getBoolean(4);
				String cccd = rs.getString(5);
				String email = rs.getString(6);
				String tuoi = rs.getString(7);

				KhachHang khachHang = new KhachHang(maKH, tenKH,soDienThoai,gioiTinh,cccd, email,tuoi);
				
				ds.add(khachHang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public String getMa(String tenKH) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		String maKH = "";
		try {
			stmt = con.prepareStatement("select maKH from KhachHang where tenKH = ? ");
			stmt.setString(1, tenKH);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				maKH = rs.getString(1).trim();
			} else {
				maKH = "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return maKH;
	}
}
