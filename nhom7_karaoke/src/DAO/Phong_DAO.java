package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Entity.LoaiNhanVien;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.Phong;
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
				String tinhTrang = rs.getString(6);
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
			stmt = con.prepareStatement("insert into Phong values (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, Phong.getMaPhong());
			stmt.setString(2, Phong.getTenPhong());
			stmt.setString(3, Phong.getLoaiPhong().getMaLoai());
			stmt.setInt(4, Phong.getDonGia());
			stmt.setString(5, Phong.getMieuTa());
			stmt.setString(6, Phong.getTinhTrang());

			
		
			
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
			stmt = con.prepareStatement(" update Phong set tinhTrang = ? where tenPhong = ?");
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
	public ArrayList<Phong> timPhong(String maPhong,String tenPhong,String loaiPhong) throws Exception {
		ArrayList<Phong> ds = new ArrayList<Phong>();
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		try {
				stmt = con.prepareStatement("select Phong.maPhong, Phong.tenPhong,LoaiPhong.tenLoaiPhong, Phong.giaPhong, Phong.mieuTa, Phong.tinhTrang,Phong.maLoaiPhong from Phong join Loaiphong on LoaiPhong.maLoaiPhong = Phong.maLoaiPhong where maPhong like ? and tenPhong like ? and tenLoaiPhong like ?");
				
				stmt.setString(1, maPhong + "%");
				stmt.setString(2, tenPhong + "%");			
				stmt.setString(3, loaiPhong + "%");
	
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String maP = rs.getString(1).trim();
				String tenP = rs.getString(2);
				int giaP = rs.getInt(4);
				String mieuta = rs.getString(5);
				String tinhTrang = rs.getString(6);
				
				String maLoai = rs.getString(3);
				String tenLoai = rs.getString(7);
				
				LoaiPhong loaiphong = new LoaiPhong(maLoai,tenLoai);
				Phong phong = new Phong(maP,tenP,mieuta,giaP,loaiphong,tinhTrang);
				
				ds.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public boolean suaPhong(Phong phong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Phong set tenPhong = ?, maLoaiPhong = ?, giaPhong = ?, mieuTa = ?, tinhTrang = ? where maPhong = ?");
			
			stmt.setString(1, phong.getTenPhong());
			stmt.setString(2, phong.getLoaiPhong().getMaLoai());
			stmt.setInt(3, phong.getDonGia());
			stmt.setString(4, phong.getMieuTa());
			stmt.setString(5, phong.getTinhTrang());
			
			
			stmt.setString(6, phong.getMaPhong());
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
	public String getTinhTrangPhong(String tenPhong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
	
		String tinhTrang = null;
		
		try {
			stmt = con.prepareStatement("select top 1 tinhTrang from Phong join DonDatPhong on Phong.maPhong = DonDatPhong.maPhong WHERE  DonDatPhong.maPhong = ?");
			stmt.setString(1, tenPhong);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				tinhTrang = rs.getString(1);
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
}
