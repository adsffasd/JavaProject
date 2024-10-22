-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 20, 2023 lúc 06:01 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `nhatro`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dich_vu`
--

CREATE TABLE `dich_vu` (
  `madichvu` varchar(50) NOT NULL,
  `tendichvu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `dich_vu`
--

INSERT INTO `dich_vu` (`madichvu`, `tendichvu`) VALUES
('DV1', 'Sửa bóng đèn điện tử'),
('DV3', 'Sửa điện'),
('DV4', 'Sửa ống cống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_thue`
--

CREATE TABLE `khach_thue` (
  `makhach` varchar(50) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `ngaysinh` date NOT NULL,
  `gioitinh` varchar(50) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `sodienthoai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khach_thue`
--

INSERT INTO `khach_thue` (`makhach`, `hoten`, `ngaysinh`, `gioitinh`, `diachi`, `sodienthoai`) VALUES
('KT1', 'Trương Hoài Phong', '2003-04-09', 'Nam', 'Nhơn Đức Nhà Bè Thành phố Hồ Chí Minh', '0764818899'),
('KT2', 'Đặng Thị Hoài Giang', '2003-11-25', 'Nữ', 'Hiệp Phước', '0375666944'),
('KT3', 'Trần Thái Thiên', '2003-03-04', 'Nam', 'Hiệp Phước', '0123123123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_phong`
--

CREATE TABLE `loai_phong` (
  `maloaiphong` varchar(50) NOT NULL,
  `tenloaiphong` varchar(50) NOT NULL,
  `dongia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loai_phong`
--

INSERT INTO `loai_phong` (`maloaiphong`, `tenloaiphong`, `dongia`) VALUES
('ML1', 'Phòng đơn', 2000000),
('ML2', 'Phòng đôi', 5000000),
('ML3', 'Phòng 4 đến 6 người', 10000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `login_register`
--

CREATE TABLE `login_register` (
  `user` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `login_register`
--

INSERT INTO `login_register` (`user`, `password`) VALUES
('phong', '123'),
('truonghoaiphong', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phong`
--

CREATE TABLE `phong` (
  `maphong` varchar(50) NOT NULL,
  `tenphong` varchar(50) NOT NULL,
  `maloaiphong` varchar(50) NOT NULL,
  `trangthai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phong`
--

INSERT INTO `phong` (`maphong`, `tenphong`, `maloaiphong`, `trangthai`) VALUES
('MP1', 'Phòng 1', 'ML1', 'Chưa'),
('MP2', 'Phòng 2', 'ML2', 'Đã thuê'),
('MP3', 'Phòng 3', 'ML3', 'Chưa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thue_phong`
--

CREATE TABLE `thue_phong` (
  `mathue` varchar(50) NOT NULL,
  `makhach` varchar(50) NOT NULL,
  `maphong` varchar(50) NOT NULL,
  `giaphong` int(11) NOT NULL,
  `tiendatcoc` int(11) NOT NULL,
  `ngaythue` date NOT NULL,
  `ngaytraphong` date NOT NULL,
  `thanhtoan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thue_phong`
--

INSERT INTO `thue_phong` (`mathue`, `makhach`, `maphong`, `giaphong`, `tiendatcoc`, `ngaythue`, `ngaytraphong`, `thanhtoan`) VALUES
('TP1', 'KT1', 'MP1', 2000000, 500000, '2021-04-09', '2022-03-09', 'Đã thanh toán'),
('TP2', 'KT2', 'MP2', 4000000, 1000000, '2021-11-25', '2021-12-25', 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tien_dien_nuoc`
--

CREATE TABLE `tien_dien_nuoc` (
  `matiendien` varchar(50) NOT NULL,
  `mathue` varchar(50) NOT NULL,
  `madichvu` varchar(50) NOT NULL,
  `tungay` date NOT NULL,
  `toingay` date NOT NULL,
  `sodien` double NOT NULL,
  `dongia` double NOT NULL,
  `dathanhtoan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tien_dien_nuoc`
--

INSERT INTO `tien_dien_nuoc` (`matiendien`, `mathue`, `madichvu`, `tungay`, `toingay`, `sodien`, `dongia`, `dathanhtoan`) VALUES
('DN1', 'TP1', 'DV3', '2022-04-09', '2022-04-10', 800, 3.4, 'Đã thanh toán'),
('DN2', 'TP2', 'DV1', '2021-04-09', '2021-05-09', 400, 3.4, 'Chưa');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dich_vu`
--
ALTER TABLE `dich_vu`
  ADD PRIMARY KEY (`madichvu`);

--
-- Chỉ mục cho bảng `khach_thue`
--
ALTER TABLE `khach_thue`
  ADD PRIMARY KEY (`makhach`);

--
-- Chỉ mục cho bảng `loai_phong`
--
ALTER TABLE `loai_phong`
  ADD PRIMARY KEY (`maloaiphong`);

--
-- Chỉ mục cho bảng `phong`
--
ALTER TABLE `phong`
  ADD PRIMARY KEY (`maphong`),
  ADD KEY `FK_phong_loaiphong` (`maloaiphong`);

--
-- Chỉ mục cho bảng `thue_phong`
--
ALTER TABLE `thue_phong`
  ADD PRIMARY KEY (`mathue`) USING BTREE,
  ADD KEY `FK_thuephong_khach` (`makhach`),
  ADD KEY `FK_thuephong_phong` (`maphong`);

--
-- Chỉ mục cho bảng `tien_dien_nuoc`
--
ALTER TABLE `tien_dien_nuoc`
  ADD PRIMARY KEY (`matiendien`) USING BTREE,
  ADD KEY `FK_dichVu` (`madichvu`),
  ADD KEY `FK_thue` (`mathue`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `phong`
--
ALTER TABLE `phong`
  ADD CONSTRAINT `FK_phong_loaiphong` FOREIGN KEY (`maloaiphong`) REFERENCES `loai_phong` (`maloaiphong`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `thue_phong`
--
ALTER TABLE `thue_phong`
  ADD CONSTRAINT `FK_thuephong_khach` FOREIGN KEY (`makhach`) REFERENCES `khach_thue` (`makhach`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_thuephong_phong` FOREIGN KEY (`maphong`) REFERENCES `phong` (`maphong`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tien_dien_nuoc`
--
ALTER TABLE `tien_dien_nuoc`
  ADD CONSTRAINT `FK_dichVu` FOREIGN KEY (`madichvu`) REFERENCES `dich_vu` (`madichvu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_thue` FOREIGN KEY (`mathue`) REFERENCES `thue_phong` (`mathue`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
