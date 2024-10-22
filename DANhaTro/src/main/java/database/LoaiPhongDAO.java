package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.LoaiPhong;

public class LoaiPhongDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<LoaiPhong> getAllLoaiPhong() {
		List<LoaiPhong> list = new ArrayList<>();
		String query = "SELECT * FROM loai_phong";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new LoaiPhong(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void insertLoaiPhong(String maloaiphong, String tenloaiphong, int dongia) {
		String query = "INSERT INTO loai_phong\r\n" + "VALUES (?,?,?)";

		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maloaiphong);
			ps.setString(2, tenloaiphong);
			ps.setInt(3, dongia);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LoaiPhong getLoaiPhongByMa(String maloaiphong) {
		String query = "SELECT * FROM loai_phong\r\n" + "WHERE maloaiphong = ?";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maloaiphong);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new LoaiPhong(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateLoaiPhong(String maloaiphong, String tenloaiphong, int dongia) {
		String query = "UPDATE loai_phong\r\n"
				+ "SET tenloaiphong = ?, dongia = ?\r\n" + "WHERE maloaiphong = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tenloaiphong);
			ps.setInt(2, dongia);
			ps.setString(3, maloaiphong);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteLoaiPhong(String maloaiphong) {
		String query = "DELETE FROM loai_phong\r\n" + "WHERE maloaiphong = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maloaiphong);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<LoaiPhong> searchLP(String tenloaiphong){
		List<LoaiPhong> list = new ArrayList<>();
		String query = "SELECT * FROM loai_phong WHERE tenloaiphong LIKE ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + tenloaiphong + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new LoaiPhong(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
