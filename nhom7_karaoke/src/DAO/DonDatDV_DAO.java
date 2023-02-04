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
import Entity.LoaiNhanVien;
import Entity.NhanVien;
import Entity.Phong;

import connect_DB.connectDB;


public class DonDatDV_DAO {
	public ArrayList<Entity.CT_DatDV> ds;
	public boolean themDonDatDV(CT_DatDV dondat) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into CT_DonDat (maDon,soLuong,maDV,thanhTienDichVu) values (?,?,?,?)");
			stmt.setString(1, dondat.getDondatPhong().getMaDon());
			stmt.setInt(2, dondat.getSoLuong());
			stmt.setString(3, dondat.getDichvu().getMaDV());
			stmt.setDouble(4,dondat.getThanhTienDichVu());
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
	public ArrayList<CT_DatDV> layDSDonDatDV(String maDon1) throws Exception {
		ArrayList<CT_DatDV> ds = new ArrayList<CT_DatDV>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "select tenDV,sum(soLuong),CT_DonDat.maDon,maPhong,thanhTienDichVu from CT_DonDat  join DichVu on DichVu.maDV = CT_DonDat.maDV join DonDatPhong ON DonDatPhong.maDon = CT_DonDat.maDon where CT_DonDat.maDon = ?  group by DichVu.tenDV, CT_DonDat.maDon,DonDatPhong.maPhong,CT_DonDat.thanhTienDichVu   ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maDon1);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String tenDV = rs.getString(1);
				int soluong = rs.getInt(2);
				String maDon = rs.getString(3);
				String maPhong = rs.getString(4);
				Double ttdv = rs.getDouble(5);
				Phong phong = new Phong (maPhong);
				DichVu dichvu = new DichVu(tenDV);
								
				DonDatPhong dondatphong = new DonDatPhong(maDon,phong);
				
				CT_DatDV dondatdv = new CT_DatDV(dondatphong, soluong, dichvu,ttdv);
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
	public ArrayList<CT_DatDV> docDSDVtheoPhong(String mp) throws Exception {
		ArrayList<CT_DatDV> ds = new ArrayList<CT_DatDV>();
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		try {
				stmt = con.prepareStatement("select  DichVu.tenDV,CT_DonDat.soLuong,DonDatPhong.maDon,DonDatPhong.maPhong,CT_DonDat.thanhTienDichVu from CT_DonDat join DonDatPhong  on CT_DonDat.maDon = DonDatPhong.maDon  join DichVu on CT_DonDat.maDV= DichVu.maDV  where maPhong LIKE ? ");
				
				stmt.setString(1, mp + "%");
				
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
			
				String tenDV = rs.getString(1);
				int soluong = rs.getInt(2);
				String donDat = rs.getString(3);
				String maPhong = rs.getString(4);
				Double ttdv = rs.getDouble(5);
				Phong phong = new Phong (maPhong);
				DichVu dichvu = new DichVu(tenDV);
								
				DonDatPhong dondatphong = new DonDatPhong(donDat,phong);
				
				CT_DatDV dondatdv = new CT_DatDV(dondatphong, soluong, dichvu,ttdv);
				ds.add(dondatdv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public ArrayList<CT_DatDV> docDSDVtheoMaDon(String md) throws Exception {
		ArrayList<CT_DatDV> ds = new ArrayList<CT_DatDV>();
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		try {
				stmt = con.prepareStatement("select  DichVu.tenDV,sum(CT_DonDat.soLuong),DonDatPhong.maDon,DonDatPhong.maPhong from CT_DonDat join DonDatPhong  on CT_DonDat.maDon = DonDatPhong.maDon  join DichVu on CT_DonDat.maDV= DichVu.maDV WHERE DonDatPhong.maDon like ? group by tenDV,DonDatPhong.maDon,DonDatPhong.maPhong  ");
				
				stmt.setString(1, md + "%");
				
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
			
				String tenDV = rs.getString(1);
				int soluong = rs.getInt(2);
				String donDat = rs.getString(3);
				String maPhong = rs.getString(4);
				Phong phong = new Phong (maPhong);
				DichVu dichvu = new DichVu(tenDV);
								
				DonDatPhong dondatphong = new DonDatPhong(donDat,phong);
				
				CT_DatDV dondatdv = new CT_DatDV(dondatphong, soluong, dichvu);
				ds.add(dondatdv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public boolean xoaDichVu(String maDV) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from CT_DonDat where maDV = ?");
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
	public ArrayList<CT_DatDV> layDsCT_DatDVTheoPhieuDat(String madon) {
		ds = new ArrayList<CT_DatDV>();
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from CT_DonDat c join DonDatPhong d\n"
					+ "on c.maDon = d.maDon\n" + "where d.maDon = '" + madon + "'");
			while (rs.next()) {

				CT_DatDV dv = new CT_DatDV(new DonDatPhong(rs.getString(5)),rs.getInt(2), new DichVu(rs.getString(3)), rs.getDouble(4)
						);
				ds.add(dv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
