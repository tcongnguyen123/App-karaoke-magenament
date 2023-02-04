package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.LoaiNhanVien;
import connect_DB.connectDB;


public class LoaiNhanVien_DAO {
	public ArrayList<LoaiNhanVien> layDSLoai() throws Exception {
		ArrayList<LoaiNhanVien> ds = new ArrayList<LoaiNhanVien>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from LoaiNV order by tenLoai asc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maLoai = rs.getString(1).trim();
				String tenLoai = rs.getString(2);
				LoaiNhanVien loaiNV = new LoaiNhanVien(maLoai, tenLoai);
				ds.add(loaiNV);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
}
