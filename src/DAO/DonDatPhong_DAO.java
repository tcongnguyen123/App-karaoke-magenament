package DAO;

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
import java.util.ArrayList;
import java.util.Date;

import Entity.Phong;
import Entity.DichVu;
import Entity.DonDatPhong;
import Entity.KhachHang;
import Entity.DonDatPhong;
import connect_DB.connectDB;

public class DonDatPhong_DAO {
	public ArrayList<DonDatPhong> layDSDonDatPhong() throws Exception {
		ArrayList<DonDatPhong> ds = new ArrayList<DonDatPhong>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select DonDatPhong.maDon, DonDatPhong.tenDon ,DonDatPhong.ngayThue,DonDatPhong.gioThue,KhachHang.maKH,KhachHang.tenKH,Phong.maPhong,Phong.tenPhong,Phong.giaPhong,DonDatPhong.ngayTaoDon\r\n"
					+ "from DonDatPhong join KhachHang on DonDatPhong.maKH = KhachHang.maKH  join Phong on DonDatPhong.maPhong = Phong.maphong  ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maDon = rs.getString(1).trim();
				String tenDon = rs.getString(2);
				String gioThue = rs.getString(4);
			//	Time dateGioThue = rs.getTime(3);
				SimpleDateFormat spd = new SimpleDateFormat("hh:mm:ss ");
			//	LocalTime gioThue = LocalTime.of(dateGioThue.getHours(),dateGioThue.getMinutes(), dateGioThue.getSeconds());
		//		LocalDateTime gioThue = LocalDateTime.from(Instant.ofEpochMilli(dateGioThue.getTime()).atZone(ZoneId.systemDefault()));
				Date dateNgayThue = rs.getDate(3);
			
				LocalDate ngayThue = LocalDate.of(dateNgayThue.getYear() + 1900, dateNgayThue.getMonth() + 1, dateNgayThue.getDate());
			//	boolean tinhTrang  = rs.getBoolean(12);
				Date dateNgayTao = rs.getDate(10);
				Timestamp ngayTaoDon = new Timestamp(dateNgayTao.getTime());
			//	Time dateNgayTao1 = rs.getTime(12);
			//	LocalDateTime ngayTao = LocalDateTime.of(dateNgayTao.getYear() + 1900, dateNgayTao.getMonth() + 1, dateNgayTao.getDate(),dateNgayTao1.getHours(),dateNgayTao1.getMinutes(),dateNgayTao1.getSeconds() );
				
				String maKH = rs.getString(5);
				String tenKH = rs.getString(6);
				
				String maPhong = rs.getString(7);
				String tenPhong = rs.getString(8);
				int donGia = rs.getInt(9);
				
				
				
				KhachHang khachhang = new KhachHang(maKH,tenKH);
				
				Phong phong = new Phong(maPhong,tenPhong,donGia);
				DonDatPhong dondatphong = new DonDatPhong(maDon,tenDon,phong,khachhang,gioThue,ngayThue,ngayTaoDon);
				
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
			stmt = con.prepareStatement("insert into DonDatPhong (maDon,tenDon,maPhong,maKH,gioThue,ngayThue,ngayTaoDon) values (?,?,?,?,?,?,?)");
			stmt.setString(1, dondatphong.getMaDon());
			stmt.setString(2, dondatphong.getPhong().getTenPhong());
			stmt.setString(3, dondatphong.getPhong().getMaPhong());
			stmt.setString(4, dondatphong.getKhachhang().getMaKH());
			stmt.setString(5, dondatphong.getGioThue());
			stmt.setString(6, dondatphong.getNgayThue().toString());
			stmt.setTimestamp(7, dondatphong.getNgayTaoDon());
			
		
			
			
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
	
		
}
