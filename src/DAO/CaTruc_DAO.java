package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
//import java.sql.Time;
import java.time.*;
import java.util.ArrayList;


import Entity.*;
import connect_DB.connectDB;

public class CaTruc_DAO {
	public ArrayList<CaTruc> layDSCaTruc() throws Exception {
		ArrayList<CaTruc> ds = new ArrayList<CaTruc>();

		try {
			connectDB.getInstance();
			Connection con = connectDB.getConnection();

			String sql = "select * from CaTruc ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maCa = rs.getString(1);
				Time dateGioBD = rs.getTime(2);
				
				
				Time dateGioKT = rs.getTime(3);
		//		LocalDate gioKT = LocalDate.of(dateGioKT.getHours(), dateGioKT.getMinutes(), dateGioKT.getSeconds());
				int mucLuong = rs.getInt(4);
				
				
				CaTruc caTruc = new CaTruc (maCa,dateGioBD,dateGioKT,mucLuong);
				
				ds.add(caTruc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
}
