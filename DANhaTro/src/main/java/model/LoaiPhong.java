package model;

public class LoaiPhong {
	private String maloaiphong;
	private String tenloaiphong;
	private int dongia;

	public LoaiPhong() {
	}
	
	public LoaiPhong(String maloaiphong) {
		this.maloaiphong = maloaiphong;
	}

	public LoaiPhong(String maloaiphong, String tenloaiphong, int dongia) {
		this.maloaiphong = maloaiphong;
		this.tenloaiphong = tenloaiphong;
		this.dongia = dongia;
	}

	public String getMaloaiphong() {
		return maloaiphong;
	}

	public void setMaloaiphong(String maloaiphong) {
		this.maloaiphong = maloaiphong;
	}

	public String getTenloaiphong() {
		return tenloaiphong;
	}

	public void setTenloaiphong(String tenloaiphong) {
		this.tenloaiphong = tenloaiphong;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

}
