package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Entity.LoaiPhong;
import Entity.Phong;
import connectSQL.ConnectSQL;
import connect_DB.connectDB;


public class Phong_DAO {
	public ArrayList<Phong> layDSPhong() throws Exception {
		ArrayList<Phong> ds = new ArrayList<Phong>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from Phong join LoaiPhong on Phong.maLoaiPhong = LoaiPhong.maLoaiPhong ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maPhong = rs.getString(1).trim();
				String tenPhong = rs.getString(2);
				int donGia = rs.getInt(4);
				String mieuTa = rs.getString(5);
				boolean tinhTrang = rs.getBoolean(6);
				String maLoai = rs.getString(7);
				String tenLoai = rs.getString(8);
				
				LoaiPhong loaiPhong = new LoaiPhong(maLoai,tenLoai);
				Phong Phong = new Phong(maPhong, tenPhong,mieuTa,donGia ,loaiPhong,tinhTrang);
				
				ds.add(Phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public boolean themPhong(Phong Phong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Phong values (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, Phong.getMaPhong());
			stmt.setString(2, Phong.getTenPhong());
			stmt.setString(3, Phong.getNgaySinh().toString());
			stmt.setString(4, Phong.getSoDienThoai());
			stmt.setBoolean(5, Phong.isGioiTinh());
			stmt.setString(6, Phong.getEmail());
			stmt.setString(7, Phong.getDiaChi());
			stmt.setString(8, Phong.getLoaiPhong().getMaLoai());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean xoaPhong(String maPhong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from Phong where maPhong = ?");
			stmt.setString(1, maPhong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean suaPhong(Phong Phong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Phong set tenPhong = ?, ngaySinh = ?, sdt = ?, gioiTinh = ?, email = ?, diaChi = ?, maLoai = ? where maPhong = ?");
			
			stmt.setString(1, Phong.getTenPhong());
			stmt.setString(2, Phong.getNgaySinh().toString());
			stmt.setString(3, Phong.getSoDienThoai());
			stmt.setBoolean(4, Phong.isGioiTinh());
			stmt.setString(5, Phong.getEmail());
			stmt.setString(6, Phong.getDiaChi());
			stmt.setString(7, Phong.getLoaiPhong().getMaLoai());
			
			stmt.setString(8, Phong.getMaPhong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public String getMa(String tenPhong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
	
		String maPhong = "";
		
		try {
			stmt = con.prepareStatement("select maPhong from Phong where tenPhong = ? ");
			stmt.setString(1, tenPhong);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				maPhong = rs.getString(1).trim();
			} else {
				maPhong = "";
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
		return maPhong;
	}
		public boolean getTinhTrang(String tenPhong) {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();
			PreparedStatement stmt = null;
		
			boolean tinhTrang = false;
			
			try {
				stmt = con.prepareStatement("select tinhTrang from Phong where tenPhong = ? ");
				stmt.setString(1, tenPhong);
				
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					tinhTrang = rs.getBoolean(1);
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
			return tinhTrang;
	}
	public boolean capNhatPhong(String tinhTrang,String maPhong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(" update Phong set tinhTrang = ? where maPhong = ?");
			stmt.setString(1, tinhTrang);
			stmt.setString(2, maPhong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
