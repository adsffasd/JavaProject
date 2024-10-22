package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.KhachThue;
import model.LoaiPhong;
import model.Phong;
import model.ThuePhong;

public class ThuePhongDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<ThuePhong> getAllThuePhong(){
		List<ThuePhong> list = new ArrayList<>();
		String sql = "SELECT tp.*, kt.hoten, kt.ngaysinh, kt.gioitinh, kt.diachi ,kt.sodienthoai, p.tenphong, p.maloaiphong, p.trangthai, lp.tenloaiphong, lp.dongia\r\n"
				+ "FROM thue_phong tp\r\n"
				+ "JOIN khach_thue kt ON tp.makhach = kt.makhach\r\n"
				+ "JOIN phong p ON tp.maphong = p.maphong\r\n"
				+ "JOIN loai_phong lp ON p.maloaiphong = lp.maloaiphong";
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				KhachThue kt = new KhachThue(rs.getString("makhach"), rs.getString("hoten"), rs.getDate("ngaysinh"), rs.getString("gioitinh"), rs.getString("diachi"), rs.getString("sodienthoai"));
				LoaiPhong lp = new LoaiPhong(rs.getString("maloaiphong"), rs.getString("tenloaiphong"), rs.getInt("dongia"));
				Phong p = new Phong(rs.getString("maphong"), rs.getString("tenphong"), lp, rs.getString("trangthai"));
				ThuePhong tp = new ThuePhong(rs.getString("mathue"), kt, p, rs.getInt("giaphong"), rs.getInt("tiendatcoc"), rs.getDate("ngaythue"), rs.getDate("ngaytraphong"), rs.getString("thanhtoan"));
				list.add(tp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
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
	
	public void insertThuePhong(ThuePhong tp) {
		String query = "INSERT INTO thue_phong(mathue, makhach, maphong, giaphong, tiendatcoc, ngaythue, ngaytraphong, thanhtoan)"
						+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tp.getMathue());
			ps.setString(2, tp.getKhachthue().getMakhach());
			ps.setString(3, tp.getPhong().getMaphong());
			ps.setInt(4, tp.getGiaphong());
			ps.setInt(5, tp.getTiendatcoc());
			ps.setDate(6, tp.getNgaythue());
			ps.setDate(7, tp.getNgaytraphong());
			ps.setString(8, tp.getThanhtoan());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ThuePhong getThuePhongByMa(String mathue) {
		String query = "SELECT * FROM thue_phong\r\n" + "WHERE mathue = ?";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, mathue);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ThuePhong(rs.getString("mathue"), new KhachThue(rs.getString("makhach")), new Phong(rs.getString("maphong")), rs.getInt("giaphong"), rs.getInt("tiendatcoc"), rs.getDate("ngaythue"), rs.getDate("ngaytraphong"), rs.getString("thanhtoan"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateThuePhong(ThuePhong tp) {
		String query = "UPDATE thue_phong\r\n"
				+ "SET makhach = ?, maphong = ?, giaphong = ?, tiendatcoc = ?, ngaythue = ?, ngaytraphong = ?, thanhtoan = ?\r\n"
				+ "WHERE mathue = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tp.getKhachthue().getMakhach());
			ps.setString(2, tp.getPhong().getMaphong());
			ps.setInt(3, tp.getGiaphong());
			ps.setInt(4, tp.getTiendatcoc());
			ps.setDate(5, tp.getNgaythue());
			ps.setDate(6, tp.getNgaytraphong());
			ps.setString(7, tp.getThanhtoan());
			ps.setString(8, tp.getMathue());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteThuePhong(String mathue) {
		String query = "DELETE FROM thue_phong\r\n" + "WHERE mathue = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, mathue);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ThuePhong> searchTP(String mathue){
		List<ThuePhong> list = new ArrayList<ThuePhong>();
		
		String query = "SELECT tp.*, kt.hoten, kt.ngaysinh, kt.gioitinh, kt.diachi, kt.sodienthoai, p.tenphong, p.maloaiphong, p.trangthai, lp.tenloaiphong, lp.dongia\r\n"
				+ "FROM thue_phong tp\r\n"
				+ "JOIN khach_thue kt ON tp.makhach = kt.makhach\r\n"
				+ "JOIN phong p ON tp.maphong = p.maphong\r\n"
				+ "JOIN loai_phong lp ON p.maloaiphong = lp.maloaiphong\r\n"
				+ "WHERE tp.mathue LIKE ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + mathue + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				KhachThue kt = new KhachThue(rs.getString("makhach"), rs.getString("hoten"), rs.getDate("ngaysinh"), rs.getString("gioitinh"), rs.getString("diachi"), rs.getString("sodienthoai"));
				LoaiPhong lp = new LoaiPhong(rs.getString("maloaiphong"), rs.getString("tenloaiphong"), rs.getInt("dongia"));
				Phong p = new Phong(rs.getString("maphong"), rs.getString("tenphong"), lp, rs.getString("trangthai"));
				ThuePhong tp = new ThuePhong(rs.getString("mathue"), kt, p, rs.getInt("giaphong"), rs.getInt("tiendatcoc"), rs.getDate("ngaythue"), rs.getDate("ngaytraphong"), rs.getString("thanhtoan"));
				list.add(tp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
