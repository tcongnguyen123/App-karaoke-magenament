package DAO;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Entity.DichVu;
import Entity.DonDatPhong;
import Entity.KhachHang;
import Entity.DonDatPhong;
import Entity.NhanVien;
import Entity.Phong;
import Entity.DonDatPhong;
import connect_DB.connectDB;



public class DonDatPhong_DAO {
	public ArrayList<DonDatPhong> layDSDonDatPhong() throws Exception {
		ArrayList<DonDatPhong> ds = new ArrayList<DonDatPhong>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select DonDatPhong.maDon,KhachHang.maKH,KhachHang.tenKH,Phong.maPhong,Phong.tenPhong,Phong.giaPhong,DonDatPhong.ngayThue,DonDatPhong.ngayTaoDon,  KhachHang.sdt,NhanVien.tenNV,NhanVien.maNV,DonDatPhong.tinhTrangThanhToan from DonDatPhong join KhachHang on DonDatPhong.maKH = KhachHang.maKH  join Phong on DonDatPhong.maPhong = Phong.maphong join NhanVien on NhanVien.maNV = DonDatPhong.maNV ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDon = rs.getString(1).trim();
				
				String maKH = rs.getString(2);
				String tenKH = rs.getString(3);
				String sdt = rs.getString(9);
				
				String maPhong = rs.getString(4);
				String tenPhong = rs.getString(5);
				int donGia = rs.getInt(6);
				
				Date dateNgayGiothue = rs.getDate(7);
				Time timeNgayGioThue = rs.getTime(7);
				@SuppressWarnings("deprecation")
				LocalDateTime localNgayGiothue = LocalDateTime.of(dateNgayGiothue.getYear()+1900, dateNgayGiothue.getMonth()+1,dateNgayGiothue.getDate(), timeNgayGioThue.getHours(), timeNgayGioThue.getMinutes(), timeNgayGioThue.getSeconds());
				
				Date dateNgayTaoDon = rs.getDate(8);
				Time timeNgayTaoDon = rs.getTime(8);
				@SuppressWarnings("deprecation")
				LocalDateTime localNgayTaoDon = LocalDateTime.of(dateNgayTaoDon.getYear()+1900, dateNgayTaoDon.getMonth()+1,dateNgayTaoDon.getDate(), timeNgayTaoDon.getHours(), timeNgayTaoDon.getMinutes(), timeNgayTaoDon.getSeconds());
				
				String tenNV = rs.getString(10);
				String maNV = rs.getString(11);
				
			/*	String maNV = rs.getString(11);
				String tenNV = rs.getString(12);*/
				NhanVien nhanvien = new NhanVien(maNV,tenNV);
				KhachHang khachhang = new KhachHang(maKH,tenKH,sdt);
				
				Phong phong = new Phong(maPhong,tenPhong,donGia);
				
				String tinhtrang = rs.getString(12);
				DonDatPhong dondatphong = new DonDatPhong(maDon,phong,khachhang,nhanvien,localNgayGiothue,localNgayTaoDon,tinhtrang);
				
				ds.add(dondatphong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public boolean themDonDatPhong(DonDatPhong dondatphong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into DonDatPhong (maDon,maPhong,maKH,ngayThue,ngayTaoDon,maNV,tinhTrangThanhToan) values (?,?,?,?,?,?,N'Chýa thanh toán')");
			stmt.setString(1, dondatphong.getMaDon());
			stmt.setString(2, dondatphong.getPhong().getMaPhong());
			stmt.setString(3, dondatphong.getKhachhang().getMaKH());
			stmt.setString(6, dondatphong.getNhanvien().getMaNV());
			Timestamp t = Timestamp.valueOf(dondatphong.getNgayGioThue());
			stmt.setTimestamp(4,t);
			Timestamp t1 = Timestamp.valueOf(dondatphong.getNgayTaoDon());
			stmt.setTimestamp(5,t1);
			
			
		
			
			
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

			String sql = "select top 1 maDon from DonDatPhong order by maDon desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				String maLonNhat = rs.getString(1).trim();
				String tienTo = maLonNhat.substring(0, 2);
				String hauTo = maLonNhat.substring(2);
				hauTo = Integer.toString(Integer.parseInt(hauTo) + 1);
				while (hauTo.length() < 2) {
					hauTo = "0" + hauTo;
				}
				maMoi = tienTo + hauTo;
			} else {
				maMoi = "A001";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maMoi;
	}
	public boolean suaDonDatPhong(DonDatPhong dondatphong) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DonDatPhong set tinhTrangDon = ? where maDon = ?");
			
			
		
			
			stmt.setString(2, dondatphong.getMaDon());
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
	public boolean suaTinhTrangThanhToan(String string,String maDon) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DonDatPhong set tinhTrangThanhToan = ? where maDon = ?");
			
			
		//	stmt.setBoolean(1, dondatphong.isTinhTrangThanhToan());
			stmt.setString(1, string);
			stmt.setString(2, maDon);
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
	public String layDSGio(LocalDateTime ngay, LocalDateTime ngay1,LocalDateTime ngay2,String maP) throws Exception {
		String ds = null;
		LocalTime c = LocalTime.of(0, 0, 0);
		
		
		LocalTime d = LocalTime.of(23, 59, 59);
		
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();
			PreparedStatement stmt = null;
			
			stmt =con.prepareStatement("select min(abs((DATEDIFF(hour, ngayThue, ?)))) from DonDatPhong where maPhong = ? and ngaythue between ? and ?");
			Timestamp t = Timestamp.valueOf(ngay);
			Timestamp t1 = Timestamp.valueOf(ngay1);
			Timestamp t2 = Timestamp.valueOf(ngay2);
			stmt.setTimestamp(1, t);
			stmt.setString(2, maP);
			stmt.setTimestamp(3, t1);
			stmt.setTimestamp(4, t2);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
				ds = rs.getString(1);
				if(ds ==null) {
					ds ="7";
				}
			}else {
				ds = "7";
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return ds;
	}
	public DonDatPhong timDonDatPhong(String mahd) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();

		DonDatPhong hd = null;
		try {
			String sql = "select * from DonDatPhong where maDon = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, mahd);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Date dateNgayTaoDon = rs.getDate(5);
				Time timeNgayTaoDon = rs.getTime(5);
				@SuppressWarnings("deprecation")
				LocalDateTime localNgayTaoDon = LocalDateTime.of(dateNgayTaoDon.getYear()+1900, dateNgayTaoDon.getMonth()+1,dateNgayTaoDon.getDate(), timeNgayTaoDon.getHours(), timeNgayTaoDon.getMinutes(), timeNgayTaoDon.getSeconds());
				
				Date dateNgayGiothue = rs.getDate(4);
				Time timeNgayGiothue = rs.getTime(4);
				@SuppressWarnings("deprecation")
				LocalDateTime localNgayGiothue = LocalDateTime.of(dateNgayGiothue.getYear()+1900, dateNgayGiothue.getMonth()+1,dateNgayGiothue.getDate(), timeNgayGiothue.getHours(), timeNgayGiothue.getMinutes(), timeNgayGiothue.getSeconds());
				
				hd = new DonDatPhong(rs.getString(1),new Phong(rs.getString(2)),new KhachHang(rs.getString(3)),new NhanVien(rs.getString(6)),localNgayGiothue,localNgayTaoDon,rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hd;
	}
}
