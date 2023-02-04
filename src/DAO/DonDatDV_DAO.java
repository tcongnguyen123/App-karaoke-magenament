package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Entity.CT_DatDV;
import Entity.DichVu;
import Entity.DonDatPhong;
import Entity.KhachHang;
import Entity.Phong;
import connect_DB.connectDB;

public class DonDatDV_DAO {
	public boolean themDonDatDV(CT_DatDV dondat) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into CT_DonDat (maCTDP,maDon,soLuong,maDV) values (?,?,?,?)");
			stmt.setString(1, dondat.getMaCTDP());
			stmt.setString(2, dondat.getDondatPhong().getMaDon());
			stmt.setInt(3, dondat.getSoLuong());
			stmt.setString(4, dondat.getDichvu().getMaDV());

			
		
			
			
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
	public ArrayList<CT_DatDV> layDSDonDatDV() throws Exception {
		ArrayList<CT_DatDV> ds = new ArrayList<CT_DatDV>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select CT_DonDat.maCTDP, DichVu.tenDV,CT_DonDat.soLuong,DonDatPhong.maDon,DonDatPhong.maPhong from CT_DonDat join DonDatPhong  on CT_DonDat.maDon = DonDatPhong.maDon join DichVu on CT_DonDat.maDV= DichVu.maDV  ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maCTDP = rs.getString(1);
				String tenDV = rs.getString(2);
				int soluong = rs.getInt(3);
				String donDat = rs.getString(4);
				String maPhong = rs.getString(5);
				Phong phong = new Phong (maPhong);
				DichVu dichvu = new DichVu(tenDV);
								
				DonDatPhong dondatphong = new DonDatPhong(donDat,phong);
				
				CT_DatDV dondatdv = new CT_DatDV(maCTDP,dondatphong, soluong, dichvu);
				ds.add(dondatdv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public String getMa(String maPhong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
	
		String tenPhong = "";
		
		try {
			stmt = con.prepareStatement("select tenPhong from Phong where maPhong = ? ");
			stmt.setString(1, maPhong);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				tenPhong = rs.getString(1).trim();
			} else {
				tenPhong = "";
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
		return tenPhong;
	}
}
