package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.DonDatPhong;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.Phong;

import connect_DB.connectDB;

public class HoaDon_DAO {
	private ArrayList<HoaDon> ds;
	public ArrayList<HoaDon> layDsHoaDon() {
		ds = new ArrayList<HoaDon>();
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from HoaDon");
			while (rs.next()) {
				Date dateNgayGiotra = rs.getDate(5);
				Time timeNgayGiotra = rs.getTime(5);
				@SuppressWarnings("deprecation")
				LocalDateTime localNgayGiotra = LocalDateTime.of(dateNgayGiotra.getYear()+1900, dateNgayGiotra.getMonth()+1,dateNgayGiotra.getDate(), timeNgayGiotra.getHours(), timeNgayGiotra.getMinutes(), timeNgayGiotra.getSeconds());
				
				Date dateNgayTaoDon = rs.getDate(6);
				Time timeNgayTaoDon = rs.getTime(6);
				@SuppressWarnings("deprecation")
				LocalDateTime localNgayTaoDon = LocalDateTime.of(dateNgayTaoDon.getYear()+1900, dateNgayTaoDon.getMonth()+1,dateNgayTaoDon.getDate(), timeNgayTaoDon.getHours(), timeNgayTaoDon.getMinutes(), timeNgayTaoDon.getSeconds());
				
				Date dateNgayGiothue = rs.getDate(7);
				Time timeNgayGiothue = rs.getTime(7);
				@SuppressWarnings("deprecation")
				
				LocalDateTime localNgayGiothue = LocalDateTime.of(dateNgayGiothue.getYear()+1900, dateNgayGiothue.getMonth()+1,dateNgayGiothue.getDate(), timeNgayGiothue.getHours(), timeNgayGiothue.getMinutes(), timeNgayGiothue.getSeconds());
				HoaDon hd = new HoaDon(rs.getString(1),new DonDatPhong(rs.getString(2)),
						new NhanVien(rs.getString(3)), new KhachHang(rs.getString(4)),
						localNgayGiotra,localNgayTaoDon,localNgayGiothue,rs.getDouble(8)
						);

				ds.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean themHoaDon(HoaDon hoadon) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoaDon (maHD,maDon,maKH,gioTra,ngayLapDon,ngayGioThue,maNV,thanhTien) values (?,?,?,?,?,?,?,?)");
			stmt.setString(1, hoadon.getMaHD());
			stmt.setString(2, hoadon.getDonDat().getMaDon());
			stmt.setString(3, hoadon.getKhachHang().getMaKH());
			Timestamp t = Timestamp.valueOf(hoadon.getGioTra());
			stmt.setTimestamp(4,t);
			Timestamp t1 = Timestamp.valueOf(hoadon.getNgayLapDon());
			stmt.setTimestamp(5,t1);
		//	stmt.setTimestamp(6, t1);
			Timestamp t2 = Timestamp.valueOf(hoadon.getDonDat().getNgayGioThue());
			stmt.setTimestamp(6,t2);
			stmt.setString(7, hoadon.getNhanVien().getMaNV());
			stmt.setDouble(8, hoadon.getTongTien());
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
	public String getMaMoi() {
		String maMoi = "";

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select top 1 maHD from HoaDon order by maHD desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				String maLonNhat = rs.getString(1).trim();
				String tienTo = maLonNhat.substring(0, 2);
				String hauTo = maLonNhat.substring(2);
				hauTo = Integer.toString(Integer.parseInt(hauTo) + 1);
				while (hauTo.length() < 3) {
					hauTo = "0" + hauTo;
				}
				maMoi = tienTo + hauTo;
			} else {
				maMoi = "HD001";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maMoi;
	}
	public ArrayList<String> layDsNamLapHoaDon() {
		ArrayList<String> ds = new ArrayList<String>();
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select datepart(yyyy,ngayLapDon) from HoaDon group by datepart(yyyy,ngayLapDon)");
			while (rs.next()) {
				ds.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<HoaDon> layDSHDtheoThang (String thang) {
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		HoaDon hd = null;
		PreparedStatement stmt = null;
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		
		try {
		
		stmt = con.prepareStatement("select ngayLapDon, thanhTien from HoaDon where datepart(month,HoaDon.ngayLapDon) = ? " );
		stmt.setString(1, thang);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Date dateNgayTaoDon = rs.getDate(1);
			Time timeNgayTaoDon = rs.getTime(1);
			@SuppressWarnings("deprecation")
			LocalDateTime localNgayTaoDon = LocalDateTime.of(dateNgayTaoDon.getYear()+1900, dateNgayTaoDon.getMonth()+1,dateNgayTaoDon.getDate(), timeNgayTaoDon.getHours(), timeNgayTaoDon.getMinutes(), timeNgayTaoDon.getSeconds());
			hd = new HoaDon(localNgayTaoDon,rs.getDouble(2));
			ds.add(hd);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ds;
	
	}
	public Double layTongDoanhThu (String thang) {
		PreparedStatement stmt = null;
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		double tongtien =0;
		try {
			stmt = con.prepareStatement("select sum(thanhTien) from HoaDon where datepart(month,HoaDon.ngayLapDon) = ?");
					stmt.setString(1, thang);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tongtien = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tongtien;
	}
	public Double layTongDoanhThuTheoNam (String nam) {
		PreparedStatement stmt = null;
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		double tongtien =0;
		try {
			stmt = con.prepareStatement("select sum(thanhTien) from HoaDon where datepart(year,HoaDon.ngayLapDon) = ?");
					stmt.setString(1, nam);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tongtien = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tongtien;
	}
	public Double layTongTTGio (String thang) {
		PreparedStatement stmt = null;
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		double tongtien =0;
		try {
			stmt = con.prepareStatement("select sum(thanhTienGio) from  HoaDon join CT_HoaDonPhong on CT_HoaDonPhong.maHD = HoaDon.maHD  where datepart(month,HoaDon.ngayLapDon) = ?");
					stmt.setString(1, thang);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tongtien = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tongtien;
	}
	public Double layTongGio (String thang) {
		PreparedStatement stmt = null;
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		double tongtien =0;
		try {
			stmt = con.prepareStatement("select sum(soGio) from  HoaDon join CT_HoaDonPhong on CT_HoaDonPhong.maHD = HoaDon.maHD  where datepart(month,HoaDon.ngayLapDon) = ?");
					stmt.setString(1, thang);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tongtien = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tongtien;
	}
	public Double layTongTDV (String thang) {
		PreparedStatement stmt = null;
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		double tongtien =0;
		try {
			stmt = con.prepareStatement("select sum(thanhTienDV) from  HoaDon join CT_HoaDon on CT_HoaDon.maHD = HoaDon.maHD  where datepart(month,HoaDon.ngayLapDon) = ?");
					stmt.setString(1, thang);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tongtien = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tongtien;
	}
	public Double layNgayThuNhieuI (String thang) {
		PreparedStatement stmt = null;
		@SuppressWarnings("static-access")
		Connection con = connectDB.getInstance().getConnection();
		double tongtien =0;
		try {
			stmt = con.prepareStatement("select max(thanhTien) from HoaDon where datepart(MONTH,HoaDon.ngayLapDon) = ?");
					stmt.setString(1, thang);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tongtien = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tongtien;
	}
}
