package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DichVu;
import model.KhachThue;
import model.LoaiPhong;
import model.Phong;
import model.ThuePhong;
import model.TienDienNuoc;

public class TienDienNuocDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<TienDienNuoc> getAllDienNuoc() {
		List<TienDienNuoc> list = new ArrayList<>();
		String sql = "SELECT dn.*, tp.makhach, tp.maphong, tp.giaphong, tp.tiendatcoc, tp.ngaythue, tp.ngaytraphong, tp.thanhtoan, kt.hoten, kt.ngaysinh, kt.gioitinh, kt.diachi, kt.sodienthoai, p.tenphong, p.maloaiphong, p.trangthai, lp.tenloaiphong, lp.dongia, dv.tendichvu\r\n"
				+ "FROM tien_dien_nuoc dn\r\n"
				+ "JOIN thue_phong tp ON dn.mathue = tp.mathue\r\n"
				+ "JOIN dich_vu dv ON dn.madichvu = dv.madichvu\r\n"
				+ "JOIN khach_thue kt ON tp.makhach = kt.makhach\r\n"
				+ "JOIN phong p ON tp.maphong = p.maphong\r\n"
				+ "JOIN loai_phong lp ON p.maloaiphong = lp.maloaiphong";

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				KhachThue kt = new KhachThue(rs.getString("makhach"), rs.getString("hoten"), rs.getDate("ngaysinh"),
						rs.getString("gioitinh"), rs.getString("diachi"), rs.getString("sodienthoai"));
				LoaiPhong lp = new LoaiPhong(rs.getString("maloaiphong"), rs.getString("tenloaiphong"),
						rs.getInt("dongia"));
				Phong p = new Phong(rs.getString("maphong"), rs.getString("tenphong"), lp, rs.getString("trangthai"));
				ThuePhong tp = new ThuePhong(rs.getString("mathue"), kt, p, rs.getInt("giaphong"),
						rs.getInt("tiendatcoc"), rs.getDate("ngaythue"), rs.getDate("ngaytraphong"),
						rs.getString("thanhtoan"));
				DichVu dv = new DichVu(rs.getString("madichvu"), rs.getString("tendichvu"));

				TienDienNuoc tdn = new TienDienNuoc(rs.getString("matiendien"), tp, dv, rs.getDate("tungay"),
						rs.getDate("toingay"), rs.getDouble("sodien"), rs.getDouble("dongia"), rs.getString("dathanhtoan"));
				list.add(tdn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
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
	
	public void insertDienNuoc(TienDienNuoc dn) {
		String query = "INSERT INTO tien_dien_nuoc(matiendien, mathue, madichvu, tungay, toingay, sodien, dongia, dathanhtoan)"
						+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, dn.getMatiendien());
			ps.setString(2, dn.getThue().getMathue());
			ps.setString(3, dn.getDichvu().getMadichvu());
			ps.setDate(4, dn.getTungay());
			ps.setDate(5, dn.getToingay());
			ps.setDouble(6, dn.getSodien());
			ps.setDouble(7, dn.getDongia());
			ps.setString(8, dn.getDathanhtoan());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TienDienNuoc getDienNuocByMa(String matiendien) {
		String query = "SELECT * FROM tien_dien_nuoc\r\n" + "WHERE matiendien = ?";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, matiendien);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new TienDienNuoc(rs.getString("matiendien"), new ThuePhong(rs.getString("mathue")), new DichVu(rs.getString("madichvu")), rs.getDate("tungay"), rs.getDate("toingay"), rs.getDouble("sodien"), rs.getDouble("dongia"), rs.getString("dathanhtoan"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateDienNuoc(TienDienNuoc dn) {
		String query = "UPDATE tien_dien_nuoc\r\n"
				+ "SET mathue = ?, madichvu = ?, tungay = ?, toingay = ?, sodien = ?, dongia = ?, dathanhtoan = ?\r\n"
				+ "WHERE matiendien = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, dn.getThue().getMathue());
			ps.setString(2, dn.getDichvu().getMadichvu());
			ps.setDate(3, dn.getTungay());
			ps.setDate(4, dn.getToingay());
			ps.setDouble(5, dn.getSodien());
			ps.setDouble(6, dn.getDongia());
			ps.setString(7, dn.getDathanhtoan());
			ps.setString(8, dn.getMatiendien());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDienNuoc(String matiendien) {
		String query = "DELETE FROM tien_dien_nuoc\r\n" + "WHERE matiendien = ?";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, matiendien);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<TienDienNuoc> searchDN(String matiendien){
		List<TienDienNuoc> list = new ArrayList<TienDienNuoc>();
		String sql = "SELECT dn.*, tp.makhach, tp.maphong, tp.giaphong, tp.tiendatcoc, tp.ngaythue, tp.ngaytraphong, tp.thanhtoan, kt.hoten, kt.ngaysinh, kt.gioitinh, kt.diachi, kt.sodienthoai, p.tenphong, p.maloaiphong, p.trangthai, lp.tenloaiphong, lp.dongia, dv.tendichvu\r\n"
				+ "FROM tien_dien_nuoc dn\r\n"
				+ "JOIN thue_phong tp ON dn.mathue = tp.mathue\r\n"
				+ "JOIN dich_vu dv ON dn.madichvu = dv.madichvu\r\n"
				+ "JOIN khach_thue kt ON tp.makhach = kt.makhach\r\n"
				+ "JOIN phong p ON tp.maphong = p.maphong\r\n"
				+ "JOIN loai_phong lp ON p.maloaiphong = lp.maloaiphong WHERE dn.matiendien LIKE ?";

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%" + matiendien + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				KhachThue kt = new KhachThue(rs.getString("makhach"), rs.getString("hoten"), rs.getDate("ngaysinh"),rs.getString("gioitinh"), rs.getString("diachi"), rs.getString("sodienthoai"));
				LoaiPhong lp = new LoaiPhong(rs.getString("maloaiphong"), rs.getString("tenloaiphong"),rs.getInt("dongia"));
				Phong p = new Phong(rs.getString("maphong"), rs.getString("tenphong"), lp, rs.getString("trangthai"));
				ThuePhong tp = new ThuePhong(rs.getString("mathue"), kt, p, rs.getInt("giaphong"),rs.getInt("tiendatcoc"), rs.getDate("ngaythue"), rs.getDate("ngaytraphong"),rs.getString("thanhtoan"));
				DichVu dv = new DichVu(rs.getString("madichvu"), rs.getString("tendichvu"));
				TienDienNuoc tdn = new TienDienNuoc(rs.getString("matiendien"), tp, dv, rs.getDate("tungay"),rs.getDate("toingay"), rs.getDouble("sodien"), rs.getDouble("dongia"), rs.getString("dathanhtoan"));
				list.add(tdn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
