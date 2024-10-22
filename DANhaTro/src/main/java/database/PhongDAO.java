package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.phong.AddPT;
import model.KhachThue;
import model.LoaiPhong;
import model.Phong;

public class PhongDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Phong> getAllPhong(){
		List<Phong> list = new ArrayList<>();
		
		String sql = "SELECT p.*, lp.tenloaiphong, lp.dongia\r\n"
				+ "FROM phong p\r\n"
				+ "JOIN loai_phong lp ON p.maloaiphong = lp.maloaiphong";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				LoaiPhong lp = new LoaiPhong(rs.getString("maloaiphong"), rs.getString("tenloaiphong"), rs.getInt("dongia"));
				Phong p = new Phong(rs.getString("maphong"), rs.getString("tenphong"), lp, rs.getString("trangthai"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertPhong(Phong p) {
		String query = "INSERT INTO phong(maphong, tenphong, maloaiphong, trangthai)"
				+ "VALUES(?,?,?,?)";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getMaphong());
			ps.setString(2, p.getTenphong());
			ps.setString(3, p.getLoaiphong().getMaloaiphong());
			ps.setString(4, p.getTrangthai());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<LoaiPhong> getAllLoaiPhong() {
		List<LoaiPhong> list = new ArrayList<>();
		String query = "SELECT * FROM loai_phong";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new LoaiPhong(rs.getString("maloaiphong"), rs.getString("tenloaiphong"), rs.getInt("dongia")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public LoaiPhong findLPById(String maloaiphong) throws SQLException, ClassNotFoundException {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from loai_phong where maloaiphong=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, maloaiphong);
			rs = ps.executeQuery();
			if (rs.next()) {
				LoaiPhong k = new LoaiPhong(rs.getString("maloaiphong"), rs.getString("tenloaiphong"), rs.getInt("dongia"));
				return k;
			}
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(AddPT.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
	
	public Phong getPhongByMa(String maphong) {
		String query = "SELECT * FROM phong\r\n" + "WHERE maphong = ?";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maphong);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Phong(rs.getString("maphong"), rs.getString("tenphong"), new LoaiPhong(rs.getString("maloaiphong")), rs.getString("trangthai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updatePhong(Phong p) {
		String query = "UPDATE phong\r\n"
				+ "SET tenphong = ?, maloaiphong = ?, trangthai = ?\r\n" + "WHERE maphong = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getTenphong());
			ps.setString(2, p.getLoaiphong().getMaloaiphong());
			ps.setString(3, p.getTrangthai());
			ps.setString(4, p.getMaphong());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletePhong(String maphong) {
		String query = "DELETE FROM phong\r\n" + "WHERE maphong = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maphong);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Phong> searchPT(String tenphong){
		List<Phong> list = new ArrayList<>();
		String query = "SELECT p.*, lp.tenloaiphong, lp.dongia\r\n"
				+ "FROM phong p\r\n"
				+ "JOIN loai_phong lp ON p.maloaiphong = lp.maloaiphong\r\n"
				+ "WHERE p.maphong IN (\r\n"
				+ "    SELECT maphong\r\n"
				+ "    FROM phong\r\n"
				+ "    WHERE tenphong LIKE ? )";
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + tenphong + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				LoaiPhong lp = new LoaiPhong(rs.getString("maloaiphong"), rs.getString("tenloaiphong"), rs.getInt("dongia"));
				Phong p = new Phong(rs.getString("maphong"), rs.getString("tenphong"), lp, rs.getString("trangthai"));
				list.add(p);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
