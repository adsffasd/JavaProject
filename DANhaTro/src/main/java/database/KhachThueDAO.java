package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DichVu;
import model.KhachThue;

public class KhachThueDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<KhachThue> getAllKhachThue() {
		List<KhachThue> list = new ArrayList<>();
		String query = "SELECT * FROM khach_thue";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new KhachThue(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public void insertKhachThue(String makhach, String hoten, Date ngaysinh, String gioitinh, String diachi, String sodienthoai) {
		String query = "INSERT INTO khach_thue\r\n" + "VALUES (?,?,?,?,?,?)";

		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, makhach);
			ps.setString(2, hoten);
			ps.setDate(3, ngaysinh);
			ps.setString(4, gioitinh);
			ps.setString(5, diachi);
			ps.setString(6, sodienthoai);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public KhachThue getKhachThueByMa(String makhach) {
		String query = "SELECT * FROM khach_thue\r\n"
				+ "WHERE makhach = ?";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, makhach);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new KhachThue(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateKhachThue(String makhach, String hoten, String ngaysinh, String gioitinh, String diachi, String sodienthoai ) {
		String query = "UPDATE khach_thue\r\n"
				+ "SET hoten = ?, ngaysinh = ?, gioitinh = ?, diachi = ?, sodienthoai=?\r\n"
				+ "WHERE makhach = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, hoten);
			ps.setString(2, ngaysinh);
			ps.setString(3, gioitinh);
			ps.setString(4, diachi);
			ps.setString(5, sodienthoai);
			ps.setString(6, makhach);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteKhachThue(String makhach) {
		String query = "DELETE FROM khach_thue\r\n"
				+ "WHERE makhach = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, makhach);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<KhachThue> searchKT(String hoten){
		List<KhachThue> list = new ArrayList<>();
		String query = "SELECT * FROM khach_thue WHERE hoten LIKE ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + hoten + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new KhachThue(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
