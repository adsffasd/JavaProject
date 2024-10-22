package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DichVu;

public class DichVuDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<DichVu> getAllDichVu() {
		List<DichVu> list = new ArrayList<>();
		String query = "SELECT * FROM dich_vu";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new DichVu(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void insertDichVu(String madichvu, String tendichvu) {
		String query = "INSERT INTO dich_vu\r\n" + "VALUES (?,?)";

		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, madichvu);
			ps.setString(2, tendichvu);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DichVu getDichVuByMa(String madichvu) {
		String query = "SELECT * FROM dich_vu\r\n"
				+ "WHERE madichvu = ?";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, madichvu);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new DichVu(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateDichVu(String madichvu, String tendichvu) {
		String query = "UPDATE dich_vu\r\n"
				+ "SET tendichvu = ?\r\n"
				+ "WHERE madichvu = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tendichvu);
			ps.setString(2, madichvu);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDichVu(String madichvu) {
		String query = "DELETE FROM dich_vu\r\n"
				+ "WHERE madichvu = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, madichvu);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<DichVu> searchDV(String tendichvu){
		List<DichVu> list = new ArrayList<DichVu>();
		String query = "SELECT * FROM dich_vu WHERE tendichvu LIKE ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + tendichvu + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new DichVu(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
