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
import Entity.NhanVien;

import connect_DB.connectDB;



public class NhanVien_DAO {
	public ArrayList<NhanVien> layDSNhanVien() throws Exception {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from NhanVien join LoaiNV on NhanVien.maLoai = LoaiNV.maLoai ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maNV = rs.getString(1).trim();
				String tenNV = rs.getString(2);
				Date dateNgaySinh = rs.getDate(3);
				LocalDate ngaySinh = LocalDate.of(dateNgaySinh.getYear() + 1900, dateNgaySinh.getMonth() + 1, dateNgaySinh.getDate());
				String soDienThoai = rs.getString(4);
				boolean gioiTinh = rs.getBoolean(5);
				String email = rs.getString(6);
				String diaChi = rs.getString(7);
				String maLoai = rs.getString(8);
				String tenLoai = rs.getString(10);
				
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(maLoai,tenLoai);
				NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh,soDienThoai,gioiTinh, email,diaChi,loaiNhanVien);
				
				ds.add(nhanVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	public boolean themNhanVien(NhanVien nhanVien) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien values (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nhanVien.getMaNV());
			stmt.setString(2, nhanVien.getTenNV());
			stmt.setString(3, nhanVien.getNgaySinh().toString());
			stmt.setString(4, nhanVien.getSoDienThoai());
			stmt.setBoolean(5, nhanVien.isGioiTinh());
			stmt.setString(6, nhanVien.getEmail());
			stmt.setString(7, nhanVien.getDiaChi());
			stmt.setString(8, nhanVien.getLoaiNV().getMaLoai());
			
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
	public boolean xoaNhanVien(String maNV) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhanVien where maNV = ?");
			stmt.setString(1, maNV);
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
	public boolean suaNhanVien(NhanVien nhanVien) {
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set tenNV = ?, ngaySinh = ?, sdt = ?, gioiTinh = ?, email = ?, diaChi = ?, maLoai = ? where maNV = ?");
			
			stmt.setString(1, nhanVien.getTenNV());
			stmt.setString(2, nhanVien.getNgaySinh().toString());
			stmt.setString(3, nhanVien.getSoDienThoai());
			stmt.setBoolean(4, nhanVien.isGioiTinh());
			stmt.setString(5, nhanVien.getEmail());
			stmt.setString(6, nhanVien.getDiaChi());
			stmt.setString(7, nhanVien.getLoaiNV().getMaLoai());
			
			stmt.setString(8, nhanVien.getMaNV());
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
	public ArrayList<NhanVien> timNhanVien(String sdt,String maNhanV,String loaiNV,String DiaChi,String hoTen,String Email) throws Exception {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		connectDB.getInstance();
		Connection con = connectDB.getConnection();
		PreparedStatement stmt = null;
		try {
				stmt = con.prepareStatement("select NhanVien.maNV, NhanVien.tenNV,NhanVien.ngaysinh, NhanVien.sdt, NhanVien.gioiTinh, NhanVien.email,NhanVien.diaChi ,NhanVien.maLoai,LoaiNV.tenLoai \r\n"
						+ "from NhanVien join LoaiNV on NhanVien.maLoai = LoaiNV.maLoai where sdt like ? and maNV LIKE ? and tenLoai like ? and diaChi like ? and tenNV like ? and email like ?");
				
				stmt.setString(1, sdt + "%");
				stmt.setString(2, maNhanV + "%");			
				stmt.setString(3, loaiNV + "%");
				stmt.setString(4, DiaChi + "%");
				stmt.setString(5, hoTen + "%");			
				stmt.setString(6, Email + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String maNV = rs.getString(1).trim();
				String tenNV = rs.getString(2);
				Date dateNgaySinh = rs.getDate(3);
				LocalDate ngaySinh = LocalDate.of(dateNgaySinh.getYear() + 1900, dateNgaySinh.getMonth() + 1, dateNgaySinh.getDate());
				String soDienThoai = rs.getString(4);
				boolean gioiTinh = rs.getBoolean(5);
				String email = rs.getString(6);
				String diaChi = rs.getString(7);
				String maLoai = rs.getString(8);
				String tenLoai = rs.getString(9);
				
				LoaiNhanVien loaiNhanVien = new LoaiNhanVien(maLoai,tenLoai);
				NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh,soDienThoai,gioiTinh, email,diaChi,loaiNhanVien);
				
				ds.add(nhanVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
}
