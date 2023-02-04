package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Entity.*;
import connect_DB.connectDB;

public class CT_CaTruc_DAO {
	public ArrayList<CT_CaTruc> layDSCT_CaTruc() throws Exception {
		ArrayList<CT_CaTruc> ds = new ArrayList<CT_CaTruc>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from CT_CaTruc join NhanVien on NhanVien.maNV = CT_CaTruc.maNV join CaTruc on CaTruc.maCa = CT_CaTruc.maCa  join LoaiNV on NhanVien.maLoai = LoaiNV.maLoai ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maCa = rs.getString(1).trim();
				int soCa = rs.getInt(3);
				Date dateNgaytruc = rs.getDate(4);
				LocalDate ngayTruc = LocalDate.of(dateNgaytruc.getYear() + 1900, dateNgaytruc.getMonth() + 1, dateNgaytruc.getDate());
				
				String maNV = rs.getString(2);
				String tenNV  = rs.getString(6);
				Date dateNgaySinh = rs.getDate(7);
				LocalDate ngaySinh = LocalDate.of(dateNgaySinh.getYear() + 1900, dateNgaySinh.getMonth() + 1, dateNgaySinh.getDate());
				String soDienThoai = rs.getString(8);
				boolean gioiTinh = rs.getBoolean(9);
				String email = rs.getString(10);
				String diaChi = rs.getString(11);
				String maLoai = rs.getString(17);
				String tenLoai = rs.getString(18);
				
				Time dateGioBD = rs.getTime(14);
	          //LocalDate gioBD = LocalDate.of(dateGioBD.getHours(), dateGioBD.getMinutes(), dateGioBD.getSeconds());
				
				Time dateGioKT = rs.getTime(15);
				//LocalDate gioKT = LocalDate.of(dateGioKT.getHours(), dateGioKT.getMinutes(), dateGioKT.getSeconds());
				int mucLuong = rs.getInt(16);
				
				LoaiNhanVien loaiNhanVien =  new LoaiNhanVien(maLoai,tenLoai);
				NhanVien nhanVien = new NhanVien(maNV,tenNV,ngaySinh,soDienThoai,gioiTinh, email,diaChi,loaiNhanVien);
				
				CaTruc caTruc = new CaTruc (maCa,dateGioBD,dateGioKT,mucLuong);
				CT_CaTruc CT_CaTruc = new CT_CaTruc(caTruc,nhanVien,soCa,ngayTruc);
				
				ds.add(CT_CaTruc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
}
