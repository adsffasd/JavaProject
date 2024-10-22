package model;

public class Phong {
	private String maphong;
	private String tenphong;
	private LoaiPhong loaiphong;
	private String trangthai;

	public Phong() {
	}

	public Phong(String maphong) {
		this.maphong = maphong;
	}

	public Phong(String maphong, String tenphong, LoaiPhong loaiphong, String trangthai) {
		this.maphong = maphong;
		this.tenphong = tenphong;
		this.loaiphong = loaiphong;
		this.trangthai = trangthai;
	}

	public String getMaphong() {
		return maphong;
	}

	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}

	public String getTenphong() {
		return tenphong;
	}

	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}

	public LoaiPhong getLoaiphong() {
		return loaiphong;
	}

	public void setLoaiphong(LoaiPhong loaiphong) {
		this.loaiphong = loaiphong;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

}
