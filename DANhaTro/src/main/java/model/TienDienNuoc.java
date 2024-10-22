package model;

import java.sql.Date;

public class TienDienNuoc {
	private String matiendien;
	private ThuePhong thue;
	private DichVu dichvu;
	private Date tungay;
	private Date toingay;
	private Double sodien;
	private Double dongia;
	private String dathanhtoan;

	public TienDienNuoc() {
	}

	public TienDienNuoc(String matiendien, ThuePhong thue, DichVu dichvu, Date tungay, Date toingay, Double sodien,
			Double dongia, String dathanhtoan) {
		this.matiendien = matiendien;
		this.thue = thue;
		this.dichvu = dichvu;
		this.tungay = tungay;
		this.toingay = toingay;
		this.sodien = sodien;
		this.dongia = dongia;
		this.dathanhtoan = dathanhtoan;
	}

	public String getMatiendien() {
		return matiendien;
	}

	public void setMatiendien(String matiendien) {
		this.matiendien = matiendien;
	}

	public ThuePhong getThue() {
		return thue;
	}

	public void setThue(ThuePhong thue) {
		this.thue = thue;
	}

	public DichVu getDichvu() {
		return dichvu;
	}

	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
	}

	public Date getTungay() {
		return tungay;
	}

	public void setTungay(Date tungay) {
		this.tungay = tungay;
	}

	public Date getToingay() {
		return toingay;
	}

	public void setToingay(Date toingay) {
		this.toingay = toingay;
	}

	public Double getSodien() {
		return sodien;
	}

	public void setSodien(Double sodien) {
		this.sodien = sodien;
	}

	public Double getDongia() {
		return dongia;
	}

	public void setDongia(Double dongia) {
		this.dongia = dongia;
	}

	public String getDathanhtoan() {
		return dathanhtoan;
	}

	public void setDathanhtoan(String dathanhtoan) {
		this.dathanhtoan = dathanhtoan;
	}

}
