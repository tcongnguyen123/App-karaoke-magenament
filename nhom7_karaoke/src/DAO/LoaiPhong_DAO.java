package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.LoaiPhong;
import connect_DB.connectDB;


public class LoaiPhong_DAO {
	public ArrayList<LoaiPhong> layDSLoai() throws Exception {
		ArrayList<LoaiPhong> ds = new ArrayList<LoaiPhong>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from LoaiPhong order by tenLoaiPhong asc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maLoaiPhong = rs.getString(1).trim();
				String tenLoaiPhong = rs.getString(2);
				LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong);
				ds.add(loaiPhong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
}
