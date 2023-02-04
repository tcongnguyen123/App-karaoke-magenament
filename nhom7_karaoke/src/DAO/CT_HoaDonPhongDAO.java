package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Entity.CT_HoaDonPhong;
import connect_DB.connectDB;

public class CT_HoaDonPhongDAO {
	public boolean themChiTietHoaDonPhong(CT_HoaDonPhong p) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		int n = 0;
		try {
			String sql = " insert into CT_HoaDonPhong (maHD,soGio,thanhTienGio,maPhong) values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getHoadon().getMaHD());
			stmt.setInt(2, p.getSoGio());
			
			stmt.setDouble(3, p.getThanhTienGio());
			stmt.setString(4, p.getPhong().getMaPhong());


			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
