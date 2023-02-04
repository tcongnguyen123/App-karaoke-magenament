package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import Entity.CT_DatDV;
import Entity.CT_HoaDon;
import Entity.DichVu;
import Entity.DonDatPhong;
import Entity.HoaDon;
import Entity.NhanVien;
import Entity.Phong;

import connect_DB.connectDB;


public class CT_HoaDon_DAO {
	private ArrayList<CT_HoaDon> ds;
	public double tongTienDichVu(String maDon) throws Exception {
		
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		
		double tongtien = 0;
		try {
				stmt = con.prepareStatement("select SUM(soLuong * giaDV) as 'Tongtien',maDon from CT_DonDat join DichVu on DichVu.maDV = CT_DonDat.maDV where maDon like ? GROUP BY maDon");
				
				stmt.setString(1, maDon + "%");
				
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				tongtien = rs.getDouble(1);
			} else {
				tongtien = 0;
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
		return tongtien;
	}
	
	public boolean suaHoaDon(CT_HoaDon chitiethoadon) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update CT_HoaDon set maHD = ?,maPhong = ? where maHD is NULL");
			
			stmt.setString(1, chitiethoadon.getHoaDon().getMaHD());
		
			
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
	
	public boolean themChiTietHoaDon(CT_HoaDon p) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		int n = 0;
		try {
			String sql = " 			insert into CT_HoaDon (maHD,soLuong,thanhTienDV,maDV) values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getHoaDon().getMaHD());
			stmt.setInt(2, p.getSoLuong());
			
			stmt.setDouble(3, p.getThanhTienDV());
			stmt.setString(4, p.getDichVu().getMaDV());

			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public ArrayList<CT_HoaDon> layDSHDTheoMa (String maHD) {
		ds = new ArrayList<CT_HoaDon>();
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		try {
			PreparedStatement stmt = null;
			stmt = con.prepareStatement("	Select sum(soLuong),HoaDon.maHD,maDV,thanhTienDV from CT_Hoadon join HoaDon on HoaDon.maHD = CT_Hoadon.maHD where HoaDon.maHD = ? group by HoaDon.maHD,CT_Hoadon.maDV,CT_Hoadon.thanhTienDV");
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				CT_HoaDon dv = new CT_HoaDon(new HoaDon(rs.getString(2)),rs.getInt(1), new DichVu(rs.getString(3)), rs.getDouble(4)
						);
				ds.add(dv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	
	}
	
}
