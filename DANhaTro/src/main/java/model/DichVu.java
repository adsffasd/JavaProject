package model;

public class DichVu {
	private String madichvu;
	private String tendichvu;

	public DichVu() {
	}

	public DichVu(String madichvu) {
		this.madichvu = madichvu;
	}

	public DichVu(String madichvu, String tendichvu) {
		this.madichvu = madichvu;
		this.tendichvu = tendichvu;
	}

	public String getMadichvu() {
		return madichvu;
	}

	public void setMadichvu(String madichvu) {
		this.madichvu = madichvu;
	}

	public String getTendichvu() {
		return tendichvu;
	}

	public void setTendichvu(String tendichvu) {
		this.tendichvu = tendichvu;
	}

}
