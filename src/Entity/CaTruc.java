package Entity;

import java.sql.Time;


public class CaTruc {
	private String maCa;
	private Time gioBD;
	private Time gioKT;
	private int mucLuong;
	public CaTruc(String maCa) {
		super();
	}
	public CaTruc(String maCa, Time dateGioBD, Time dateGioKT, int mucLuong) {
		super();
		this.maCa = maCa;
		this.gioBD = dateGioBD;
		this.gioKT = dateGioKT;
		this.mucLuong = mucLuong;
	}
	public String getMaCa() {
		return maCa;
	}
	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}
	public Time getGioBD() {
		return gioBD;
	}
	public void setGioBD(Time gioBD) {
		this.gioBD = gioBD;
	}
	public Time getGioKT() {
		return gioKT;
	}
	public void setGioKT(Time gioKT) {
		this.gioKT = gioKT;
	}
	public int getMucLuong() {
		return mucLuong;
	}
	public void setMucLuong(int mucLuong) {
		this.mucLuong = mucLuong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCa == null) ? 0 : maCa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaTruc other = (CaTruc) obj;
		if (maCa == null) {
			if (other.maCa != null)
				return false;
		} else if (!maCa.equals(other.maCa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CaTruc [maCa=" + maCa + ", gioBD=" + gioBD + ", gioKT=" + gioKT + ", mucLuong=" + mucLuong + "]";
	}
	
}
