package model;

import java.sql.Date;

public class ThuePhong {
	private String mathue;
	private KhachThue khachthue;
	private Phong phong;
	private int giaphong;
	private int tiendatcoc;
	private Date ngaythue;
	private Date ngaytraphong;
	private String thanhtoan;

	public ThuePhong() {
	}
	
	public ThuePhong(String mathue) {
		this.mathue = mathue;
	}

	public ThuePhong(String mathue, KhachThue khachthue, Phong phong, int giaphong, int tiendatcoc, Date ngaythue,
			Date ngaytraphong, String thanhtoan) {
		this.mathue = mathue;
		this.khachthue = khachthue;
		this.phong = phong;
		this.giaphong = giaphong;
		this.tiendatcoc = tiendatcoc;
		this.ngaythue = ngaythue;
		this.ngaytraphong = ngaytraphong;
		this.thanhtoan = thanhtoan;
	}

	public String getMathue() {
		return mathue;
	}

	public void setMathue(String mathue) {
		this.mathue = mathue;
	}

	public KhachThue getKhachthue() {
		return khachthue;
	}

	public void setKhachthue(KhachThue khachthue) {
		this.khachthue = khachthue;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public int getGiaphong() {
		return giaphong;
	}

	public void setGiaphong(int giaphong) {
		this.giaphong = giaphong;
	}

	public int getTiendatcoc() {
		return tiendatcoc;
	}

	public void setTiendatcoc(int tiendatcoc) {
		this.tiendatcoc = tiendatcoc;
	}

	public Date getNgaythue() {
		return ngaythue;
	}

	public void setNgaythue(Date ngaythue) {
		this.ngaythue = ngaythue;
	}

	public Date getNgaytraphong() {
		return ngaytraphong;
	}

	public void setNgaytraphong(Date ngaytraphong) {
		this.ngaytraphong = ngaytraphong;
	}

	public String getThanhtoan() {
		return thanhtoan;
	}

	public void setThanhtoan(String thanhtoan) {
		this.thanhtoan = thanhtoan;
	}

}
