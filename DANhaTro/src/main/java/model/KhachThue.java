package model;

import java.sql.Date;

public class KhachThue {
	private String makhach;
	private String hoten;
	private Date ngaysinh;
	private String gioitinh;
	private String diachi;
	private String sodienthoai;

	public KhachThue() {
	}
	
	public KhachThue(String makhach) {
		this.makhach = makhach;
	}

	public KhachThue(String makhach, String hoten, Date ngaysinh, String gioitinh, String diachi, String sodienthoai) {
		this.makhach = makhach;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
	}

	public String getMakhach() {
		return makhach;
	}

	public void setMakhach(String makhach) {
		this.makhach = makhach;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

}
