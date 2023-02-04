package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Entity.DichVu;

import connect_DB.connectDB;




public class DichVu_DAO {
	public ArrayList<DichVu> layDSDichVu() throws Exception {
		ArrayList<DichVu> ds = new ArrayList<DichVu>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from DichVu" ;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDV = rs.getString(1).trim();
				String tenDV = rs.getString(2);
				String loai = rs.getString(3);
				int donGia = rs.getInt(4);
				String donViTinh = rs.getString(5);
				
				DichVu DichVu = new DichVu(maDV, tenDV,donViTinh,donGia,loai );
				
				ds.add(DichVu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public boolean themDichVu(DichVu DichVu) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into DichVu values (?, ?, ?, ?, ?)");
			stmt.setString(1, DichVu.getMaDV());
			stmt.setString(2, DichVu.getTenDV());
			stmt.setString(3, DichVu.getLoai());
			stmt.setInt(4, DichVu.getDonGia());
			stmt.setString(5, DichVu.getDonViTinh());
	
			
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
	public boolean xoaDichVu(String maDV) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from DichVu where maDV = ?");
			stmt.setString(1, maDV);
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
	public boolean suaDichVu(DichVu DichVu) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DichVu set tenDV = ?,thongTinDV = ?, giaDV = ?, donViTinh = ?  where maDV = ?");
			
			stmt.setString(1, DichVu.getTenDV());
			stmt.setString(2, DichVu.getLoai());
			stmt.setInt(3, DichVu.getDonGia());
			stmt.setString(4, DichVu.getDonViTinh());
			
			stmt.setString(5, DichVu.getMaDV());
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
	public ArrayList<DichVu> timDichVu(String maDichVu,String tenDichVu,String Loai,String donvitinh) throws Exception {
		ArrayList<DichVu> ds = new ArrayList<DichVu>();
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		try {
				stmt = con.prepareStatement("select DichVu.maDV, DichVu.tenDV, DichVu.thongtinDV, DichVu.giaDV, DichVu.donViTinh from DichVu where maDV like ? and tenDV like ? and thongtinDV like ? and donViTinh like ? ");
				
				stmt.setString(1, maDichVu + "%");
				stmt.setString(2, tenDichVu + "%");			
				stmt.setString(3, donvitinh + "%");
				stmt.setString(4, Loai + "%");
			//	stmt.setString(5, dongia + "%");			
	
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String maDV = rs.getString(1).trim();
				String tenDV = rs.getString(2);
				String loai = rs.getString(3);
				int donGia = rs.getInt(4);
				String donViTinh = rs.getString(5);
				
				DichVu DichVu = new DichVu(maDV, tenDV,donViTinh,donGia,loai );
				ds.add(DichVu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public String getTenDV(String maDV) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
	
		String tenDV = "";
		
		try {
			stmt = con.prepareStatement("select tenDV from DichVu where maDV = ?");
			stmt.setString(1, maDV);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				tenDV = rs.getString(1).trim();
			} else {
				tenDV = "";
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
		return tenDV;
	}
	public String timDichVu22(String madv) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		String dv = null;
		try {
			String sql = " select maDV  from DichVu where tenDV = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, madv);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dv = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dv;
	}
}