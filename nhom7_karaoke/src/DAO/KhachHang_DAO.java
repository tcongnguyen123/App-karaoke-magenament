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
	public String getMa(String tenKH,String sdt) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		String maKH = "";
		try {
			stmt = con.prepareStatement("select maKH from KhachHang where tenKH like ? and sdt like ? ");
			stmt.setString(1, tenKH);
			stmt.setString(2,sdt);
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
	public String getTenKH(String maKH) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
	
		String tenKH = "";
		
		try {
			stmt = con.prepareStatement("select tenKH from KhachHang where maKH = ? ");
			stmt.setString(1, maKH);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				tenKH = rs.getString(1).trim();
			} else {
				tenKH = "";
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
		return tenKH;
	}
	public boolean xoaKhachHang(String maKH) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhachHang where maKH = ?");
			stmt.setString(1, maKH);
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
	public boolean themKhachHang(KhachHang khachhang) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, khachhang.getMaKH());
			stmt.setString(2, khachhang.getTenKH());
			stmt.setString(3, khachhang.getSdt());
			stmt.setBoolean(4, khachhang.isGioiTinh());
			stmt.setString(5, khachhang.getCccd());
			stmt.setString(6, khachhang.getEmail());
			stmt.setString(7, khachhang.getTuoi());

			
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
	public boolean suaKhachHang(KhachHang khachhang) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang set tenKH = ?,  sdt = ?, gioiTinh = ?,cmnd = ?, email = ?, tuoi = ? where maKH = ?");
			
			stmt.setString(1, khachhang.getTenKH());
			stmt.setString(2, khachhang.getSdt());
			stmt.setBoolean(3, khachhang.isGioiTinh());
			stmt.setString(4, khachhang.getCccd());
			stmt.setString(5, khachhang.getEmail());
			stmt.setString(6, khachhang.getTuoi());

			
			stmt.setString(7, khachhang.getMaKH());
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
	public ArrayList<KhachHang> timKhachHang(String sdt, String maKhachH, String hoTen, String Email, String cccd, String tuoi ) throws Exception {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		try {
				stmt = con.prepareStatement("select * from KhachHang  where sdt like ? and maKH LIKE ? and tenKH like ? and email like ? and cmnd like ? and tuoi like ?");
				
				stmt.setString(1, sdt + "%");
				stmt.setString(2, maKhachH + "%");			
				stmt.setString(3, hoTen + "%");
				stmt.setString(4, Email + "%");
				stmt.setString(5, cccd + "%");			
				stmt.setString(6, tuoi + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String maKH = rs.getString(1).trim();
				String tenKH = rs.getString(2);
				String soDienThoai = rs.getString(3);
				boolean gioiTinh = rs.getBoolean(4);
				String cancuoc = rs.getString(5);
				String email = rs.getString(6);
				String tuoi1 = rs.getString(7);
				
				KhachHang khachhang = new KhachHang(maKH, tenKH,  soDienThoai, gioiTinh,cancuoc, email,tuoi1);
				
				ds.add(khachhang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public ArrayList<KhachHang> layDSTenKH() throws Exception {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from KhachHang order by tenKH asc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maKH = rs.getString(1).trim();
				String tenKH = rs.getString(2);
				KhachHang khachhang = new KhachHang(maKH, tenKH);
				ds.add(khachhang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
}
