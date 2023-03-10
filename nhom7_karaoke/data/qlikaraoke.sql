USE [QLKaraoke]
GO
ALTER TABLE [dbo].[TaiKhoan] DROP CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[TaiKhoan] DROP CONSTRAINT [FK_TaiKhoan_KhachHang]
GO
ALTER TABLE [dbo].[Phong] DROP CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[NhanVien] DROP CONSTRAINT [FK_NhanVien_LoaiNV]
GO
ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK_HoaDon_DonDatPhong]
GO
ALTER TABLE [dbo].[DonDatPhong] DROP CONSTRAINT [FK_DonDatPhong_Phong]
GO
ALTER TABLE [dbo].[DonDatPhong] DROP CONSTRAINT [FK_DonDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[CT_HoaDonPhong] DROP CONSTRAINT [FK_CT_HoaDonPhong_Phong1]
GO
ALTER TABLE [dbo].[CT_HoaDonPhong] DROP CONSTRAINT [FK_CT_HoaDonPhong_HoaDon]
GO
ALTER TABLE [dbo].[CT_Hoadon] DROP CONSTRAINT [FK_CT_Hoadon_HoaDon]
GO
ALTER TABLE [dbo].[CT_Hoadon] DROP CONSTRAINT [FK_CT_Hoadon_DichVu]
GO
ALTER TABLE [dbo].[CT_DonDat] DROP CONSTRAINT [FK_CT_DonDat_DonDatPhong]
GO
ALTER TABLE [dbo].[CT_DonDat] DROP CONSTRAINT [FK_CT_DonDat_DichVu]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[TaiKhoan]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[Phong]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[NhanVien]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[LoaiPhong]
GO
/****** Object:  Table [dbo].[LoaiNV]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[LoaiNV]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[KhachHang]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[HoaDon]
GO
/****** Object:  Table [dbo].[DonDatPhong]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[DonDatPhong]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[DichVu]
GO
/****** Object:  Table [dbo].[CT_HoaDonPhong]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[CT_HoaDonPhong]
GO
/****** Object:  Table [dbo].[CT_Hoadon]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[CT_Hoadon]
GO
/****** Object:  Table [dbo].[CT_DonDat]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP TABLE [dbo].[CT_DonDat]
GO
USE [master]
GO
/****** Object:  Database [QLKaraoke]    Script Date: 22/12/2021 10:59:30 SA ******/
DROP DATABASE [QLKaraoke]
GO
/****** Object:  Database [QLKaraoke]    Script Date: 22/12/2021 10:59:30 SA ******/
CREATE DATABASE [QLKaraoke]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLKaraoke', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QLKaraoke.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLKaraoke_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QLKaraoke_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLKaraoke] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLKaraoke].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLKaraoke] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLKaraoke] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLKaraoke] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLKaraoke] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLKaraoke] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLKaraoke] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLKaraoke] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLKaraoke] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLKaraoke] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLKaraoke] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLKaraoke] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLKaraoke] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLKaraoke] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLKaraoke] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLKaraoke] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLKaraoke] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLKaraoke] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLKaraoke] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLKaraoke] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLKaraoke] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLKaraoke] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLKaraoke] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLKaraoke] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLKaraoke] SET  MULTI_USER 
GO
ALTER DATABASE [QLKaraoke] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLKaraoke] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLKaraoke] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLKaraoke] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QLKaraoke] SET DELAYED_DURABILITY = DISABLED 
GO
USE [QLKaraoke]
GO
/****** Object:  Table [dbo].[CT_DonDat]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CT_DonDat](
	[maDon] [varchar](50) NULL,
	[soLuong] [int] NULL,
	[maDV] [varchar](50) NULL,
	[thanhTienDichVu] [money] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CT_Hoadon]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CT_Hoadon](
	[maHD] [varchar](50) NULL,
	[soLuong] [int] NULL,
	[maDV] [varchar](50) NULL,
	[thanhTienDV] [money] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CT_HoaDonPhong]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CT_HoaDonPhong](
	[maHD] [varchar](50) NULL,
	[soGio] [int] NOT NULL,
	[thanhTienGio] [money] NOT NULL,
	[maPhong] [varchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDV] [varchar](50) NOT NULL,
	[tenDV] [nvarchar](50) NULL,
	[thongtinDV] [nvarchar](50) NULL,
	[giaDV] [int] NULL,
	[donViTinh] [nvarchar](50) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[maDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DonDatPhong]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DonDatPhong](
	[maDon] [varchar](50) NOT NULL,
	[maPhong] [varchar](50) NULL,
	[maKH] [varchar](50) NULL,
	[ngayThue] [datetime] NULL,
	[ngayTaoDon] [datetime] NULL,
	[maNV] [nvarchar](50) NULL,
	[tinhTrangThanhToan] [nvarchar](50) NULL,
 CONSTRAINT [PK_DonDatPhong] PRIMARY KEY CLUSTERED 
(
	[maDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [varchar](50) NOT NULL,
	[maDon] [varchar](50) NULL,
	[maNV] [varchar](50) NULL,
	[maKH] [varchar](50) NULL,
	[gioTra] [datetime] NULL,
	[ngayLapDon] [datetime] NULL,
	[ngayGioThue] [datetime] NULL,
	[thanhTien] [money] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [varchar](50) NOT NULL,
	[tenKH] [nvarchar](50) NULL,
	[sdt] [nvarchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[cmnd] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[tuoi] [varchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiNV]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiNV](
	[maLoai] [varchar](50) NOT NULL,
	[tenLoai] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiNV] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLoaiPhong] [varchar](50) NOT NULL,
	[tenLoaiPhong] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[maLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](50) NOT NULL,
	[tenNV] [nvarchar](40) NULL,
	[ngaysinh] [date] NULL,
	[sdt] [varchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[email] [varchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[maLoai] [varchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [varchar](50) NOT NULL,
	[tenPhong] [varchar](50) NULL,
	[maLoaiPhong] [varchar](50) NOT NULL,
	[giaPhong] [int] NULL,
	[mieuTa] [varchar](50) NULL,
	[tinhTrang] [nvarchar](50) NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 22/12/2021 10:59:30 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[maNV] [varchar](50) NULL,
	[maKH] [varchar](50) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[CT_DonDat] ([maDon], [soLuong], [maDV], [thanhTienDichVu]) VALUES (N'A001', 10, N'DV1', 200000.0000)
INSERT [dbo].[CT_DonDat] ([maDon], [soLuong], [maDV], [thanhTienDichVu]) VALUES (N'A001', 2, N'DV5', 40000.0000)
INSERT [dbo].[CT_DonDat] ([maDon], [soLuong], [maDV], [thanhTienDichVu]) VALUES (N'A002', 8, N'DV2', 80000.0000)
INSERT [dbo].[CT_DonDat] ([maDon], [soLuong], [maDV], [thanhTienDichVu]) VALUES (N'A005', 1, N'DV1', 20000.0000)
INSERT [dbo].[CT_DonDat] ([maDon], [soLuong], [maDV], [thanhTienDichVu]) VALUES (N'A005', 1, N'DV1', 20000.0000)
INSERT [dbo].[CT_DonDat] ([maDon], [soLuong], [maDV], [thanhTienDichVu]) VALUES (N'A003', 4, N'DV4', 80000.0000)
INSERT [dbo].[CT_DonDat] ([maDon], [soLuong], [maDV], [thanhTienDichVu]) VALUES (N'A012', 10, N'DV2', 100000.0000)
INSERT [dbo].[CT_DonDat] ([maDon], [soLuong], [maDV], [thanhTienDichVu]) VALUES (N'A013', 2, N'DV2', 20000.0000)
INSERT [dbo].[CT_Hoadon] ([maHD], [soLuong], [maDV], [thanhTienDV]) VALUES (N'HD001', 10, N'DV1', 200000.0000)
INSERT [dbo].[CT_Hoadon] ([maHD], [soLuong], [maDV], [thanhTienDV]) VALUES (N'HD001', 2, N'DV5', 40000.0000)
INSERT [dbo].[CT_Hoadon] ([maHD], [soLuong], [maDV], [thanhTienDV]) VALUES (N'HD002', 8, N'DV2', 80000.0000)
INSERT [dbo].[CT_Hoadon] ([maHD], [soLuong], [maDV], [thanhTienDV]) VALUES (N'HD005', 1, N'DV1', 20000.0000)
INSERT [dbo].[CT_Hoadon] ([maHD], [soLuong], [maDV], [thanhTienDV]) VALUES (N'HD005', 1, N'DV1', 20000.0000)
INSERT [dbo].[CT_Hoadon] ([maHD], [soLuong], [maDV], [thanhTienDV]) VALUES (N'HD003', 4, N'DV4', 80000.0000)
INSERT [dbo].[CT_Hoadon] ([maHD], [soLuong], [maDV], [thanhTienDV]) VALUES (N'HD012', 10, N'DV2', 100000.0000)
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD001', 1, 100000.0000, N'P01')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD002', 2, 200000.0000, N'P02')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD003', 2, 200000.0000, N'P03')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD004', 1, 250000.0000, N'P04')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD005', 1, 100000.0000, N'P05')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD006', 1, 100000.0000, N'P01')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD007', 3, 300000.0000, N'P03')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD008', 4, 400000.0000, N'P02')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD009', 1, 250000.0000, N'P04')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD010', 1, 100000.0000, N'P02')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD011', 0, 96666.6641, N'P01')
INSERT [dbo].[CT_HoaDonPhong] ([maHD], [soGio], [thanhTienGio], [maPhong]) VALUES (N'HD012', 23, 2398333.2500, N'P01')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [thongtinDV], [giaDV], [donViTinh]) VALUES (N'DV1', N'CoCa CoLa', N'Ðồ uống', 20000, N'chai')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [thongtinDV], [giaDV], [donViTinh]) VALUES (N'DV2', N'Sprite', N'Đồ uống', 10000, N'chai')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [thongtinDV], [giaDV], [donViTinh]) VALUES (N'DV3', N'Sting', N'Đồ uống', 20000, N'chai')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [thongtinDV], [giaDV], [donViTinh]) VALUES (N'DV4', N'Snack', N'Đồ ăn', 20000, N'bịch')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [thongtinDV], [giaDV], [donViTinh]) VALUES (N'DV5', N'Bia 333', N'Đồ uống', 20000, N'chai')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A001', N'P01', N'K001', CAST(N'2021-12-15 15:00:00.000' AS DateTime), CAST(N'2021-12-15 00:00:00.000' AS DateTime), N'N001', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A002', N'P02', N'K001', CAST(N'2021-09-25 16:00:00.000' AS DateTime), CAST(N'2021-09-25 15:00:00.000' AS DateTime), N'N002', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A003', N'P03', N'K004', CAST(N'2021-08-02 08:00:00.000' AS DateTime), CAST(N'2021-08-02 07:00:00.000' AS DateTime), N'N003', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A004', N'P04', N'K005', CAST(N'2021-12-17 08:00:00.000' AS DateTime), CAST(N'2021-12-17 08:00:00.000' AS DateTime), N'N004', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A005', N'P05', N'K002', CAST(N'2021-12-15 10:00:00.000' AS DateTime), CAST(N'2021-12-15 09:00:00.000' AS DateTime), N'N001', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A006', N'P01', N'K001', CAST(N'2021-11-25 04:00:00.000' AS DateTime), CAST(N'2021-11-24 02:00:00.000' AS DateTime), N'N001', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A007', N'P03', N'K003', CAST(N'2021-10-02 09:00:00.000' AS DateTime), CAST(N'2021-10-02 05:00:00.000' AS DateTime), N'N001', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A008', N'P02', N'K003', CAST(N'2021-12-15 07:00:00.000' AS DateTime), CAST(N'2021-12-13 01:00:00.000' AS DateTime), N'N004', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A009', N'P04', N'K005', CAST(N'2021-12-01 16:00:00.000' AS DateTime), CAST(N'2021-12-01 15:00:00.000' AS DateTime), N'N003', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A010', N'P02', N'K001', CAST(N'2021-08-06 01:00:00.000' AS DateTime), CAST(N'2021-08-06 01:00:00.000' AS DateTime), N'N005', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A011', N'P01', N'K001', CAST(N'2021-12-22 09:00:00.000' AS DateTime), CAST(N'2021-12-22 09:56:05.993' AS DateTime), N'N008', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A012', N'P01', N'K001', CAST(N'2021-12-21 10:00:00.000' AS DateTime), CAST(N'2021-12-22 09:58:56.287' AS DateTime), N'N003', N'Đã thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A013', N'P01', N'K001', CAST(N'2021-12-22 03:00:00.000' AS DateTime), CAST(N'2021-12-22 10:15:04.860' AS DateTime), N'N003', N'Đang chờ thanh toán')
INSERT [dbo].[DonDatPhong] ([maDon], [maPhong], [maKH], [ngayThue], [ngayTaoDon], [maNV], [tinhTrangThanhToan]) VALUES (N'A014', N'P05', N'K003', CAST(N'2021-12-22 10:00:00.000' AS DateTime), CAST(N'2021-12-22 10:43:22.730' AS DateTime), N'N005', N'Đang chờ thanh toán')
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD001', N'A001', N'N001', N'K001', CAST(N'2021-12-15 16:00:00.000' AS DateTime), CAST(N'2021-12-15 16:00:00.000' AS DateTime), CAST(N'2021-12-15 15:00:00.000' AS DateTime), 340000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD002', N'A002', N'N002', N'K001', CAST(N'2021-09-25 18:00:00.000' AS DateTime), CAST(N'2021-09-25 18:00:00.000' AS DateTime), CAST(N'2021-09-25 16:00:00.000' AS DateTime), 280000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD003', N'A003', N'N003', N'K004', CAST(N'2021-08-02 10:00:00.000' AS DateTime), CAST(N'2021-08-02 10:00:00.000' AS DateTime), CAST(N'2021-08-02 08:00:00.000' AS DateTime), 280000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD004', N'A004', N'N004', N'K005', CAST(N'2021-12-17 09:00:00.000' AS DateTime), CAST(N'2021-12-17 09:00:00.000' AS DateTime), CAST(N'2021-12-17 08:00:00.000' AS DateTime), 250000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD005', N'A005', N'N001', N'K002', CAST(N'2021-12-15 11:00:00.000' AS DateTime), CAST(N'2021-12-15 11:00:00.000' AS DateTime), CAST(N'2021-12-15 10:00:00.000' AS DateTime), 140000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD006', N'A006', N'N001', N'K001', CAST(N'2021-11-25 05:00:00.000' AS DateTime), CAST(N'2021-11-25 05:00:00.000' AS DateTime), CAST(N'2021-11-25 04:00:00.000' AS DateTime), 100000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD007', N'A007', N'N001', N'K003', CAST(N'2021-10-02 12:00:00.000' AS DateTime), CAST(N'2021-10-02 12:00:00.000' AS DateTime), CAST(N'2021-10-02 09:00:00.000' AS DateTime), 300000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD008', N'A008', N'N004', N'K003', CAST(N'2021-12-15 11:00:00.000' AS DateTime), CAST(N'2021-12-15 11:00:00.000' AS DateTime), CAST(N'2021-12-15 07:00:00.000' AS DateTime), 400000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD009', N'A009', N'N003', N'K005', CAST(N'2021-12-01 17:00:00.000' AS DateTime), CAST(N'2021-12-01 17:00:00.000' AS DateTime), CAST(N'2021-12-01 16:00:00.000' AS DateTime), 250000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD010', N'A010', N'N005', N'K001', CAST(N'2021-08-06 02:00:00.000' AS DateTime), CAST(N'2021-08-06 02:00:00.000' AS DateTime), CAST(N'2021-08-06 01:00:00.000' AS DateTime), 100000.0000)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD011', N'A011', N'N008', N'K001', CAST(N'2021-12-22 09:58:19.707' AS DateTime), CAST(N'2021-12-22 09:58:19.707' AS DateTime), CAST(N'2021-12-22 09:00:00.000' AS DateTime), 96666.6641)
INSERT [dbo].[HoaDon] ([maHD], [maDon], [maNV], [maKH], [gioTra], [ngayLapDon], [ngayGioThue], [thanhTien]) VALUES (N'HD012', N'A012', N'N003', N'K001', CAST(N'2021-12-22 09:59:54.500' AS DateTime), CAST(N'2021-12-22 09:59:54.500' AS DateTime), CAST(N'2021-12-21 10:00:00.000' AS DateTime), 2498333.2500)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [gioiTinh], [cmnd], [email], [tuoi]) VALUES (N'K001', N'Hồ Khánh Linh', N'0976767567', 0, N'301801095', N'khanhlinh@gmail.com', N'21')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [gioiTinh], [cmnd], [email], [tuoi]) VALUES (N'K002', N'Nguyễn Phúc Lâm', N'0985731902', 1, N'196023565', N'phuclam@gmail.com', N'27')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [gioiTinh], [cmnd], [email], [tuoi]) VALUES (N'K003', N'Bùi Hạ Vy', N'0895367979', 1, N'195382578', N'haivy@gmail.com', N'25')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [gioiTinh], [cmnd], [email], [tuoi]) VALUES (N'K004', N'Lê Minh Hào', N'0983575434', 1, N'197403971', N'hai@gmail.com', N'28')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [gioiTinh], [cmnd], [email], [tuoi]) VALUES (N'K005', N'Nguyễn Linh Chi', N'0983234891', 0, N'197257582', N'linhchi@gmail.com', N'23')
INSERT [dbo].[LoaiNV] ([maLoai], [tenLoai]) VALUES (N'L001', N'Nhân viên kế toán')
INSERT [dbo].[LoaiNV] ([maLoai], [tenLoai]) VALUES (N'L002', N'Nhân viên lễ tân')
INSERT [dbo].[LoaiNV] ([maLoai], [tenLoai]) VALUES (N'L003', N'Nhân viên kĩ thuật')
INSERT [dbo].[LoaiNV] ([maLoai], [tenLoai]) VALUES (N'L004', N'Nhân viên quản lý')
INSERT [dbo].[LoaiNV] ([maLoai], [tenLoai]) VALUES (N'L005', N'Nhân viên bảo vệ')
INSERT [dbo].[LoaiNV] ([maLoai], [tenLoai]) VALUES (N'L006', N'Nhân viên phục vụ')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'L01', N'Vip')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'L02', N'Thường')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaysinh], [sdt], [gioiTinh], [email], [diaChi], [maLoai]) VALUES (N'N001', N'Trần Công Nguyên', CAST(N'2001-10-09' AS Date), N'0985711309', 1, N'tcongnguyen0210@gmail.com', N'20/4 Bình Chánh , Bình Chánh, TPHCM', N'L004')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaysinh], [sdt], [gioiTinh], [email], [diaChi], [maLoai]) VALUES (N'N002', N'Trương Thị Nhỏ Lệ', CAST(N'2000-11-13' AS Date), N'0378202336', 0, N'nholetruong@gmail.com', N'300 Phạm Ngu Lão, P3, Q.Gò Vấp', N'L001')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaysinh], [sdt], [gioiTinh], [email], [diaChi], [maLoai]) VALUES (N'N003', N'Bùi Xuân Nguyên', CAST(N'2001-08-25' AS Date), N'0876342235', 1, N'xuannguyen@gmail.com', N'19 Nguyễn Thị Minh Khai, Bến Nghé, Q1', N'L003')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaysinh], [sdt], [gioiTinh], [email], [diaChi], [maLoai]) VALUES (N'N004', N'Lê Minh Tâm', CAST(N'1976-04-20' AS Date), N'0973129272', 1, N'tamle@gmail.com', N'25 Ung Văn Khiêm, P25, Q.Bình Thạnh', N'L005')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaysinh], [sdt], [gioiTinh], [email], [diaChi], [maLoai]) VALUES (N'N005', N'Nguyễn Anh Thư', CAST(N'2000-10-20' AS Date), N'0971245764', 0, N'anhthu@gmail.com', N'7 Lê Lợi, P4, Q.Gò Vấp', N'L002')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaysinh], [sdt], [gioiTinh], [email], [diaChi], [maLoai]) VALUES (N'N006', N'Nguyễn Thị Tường Vi', CAST(N'1998-07-11' AS Date), N'0986575868', 0, N'tuongvi@gmail.com', N'123 Nguyễn Văn Bảo, P4, Q.Gò Vấp', N'L006')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaysinh], [sdt], [gioiTinh], [email], [diaChi], [maLoai]) VALUES (N'N007', N'Nguyễn Quốc Hoàng', CAST(N'2000-11-13' AS Date), N'0988881236', 1, N'quochoang@gmail.com', N'300 Phạm Ngũ Lão, P3, Q.Gò Vấp', N'L001')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaysinh], [sdt], [gioiTinh], [email], [diaChi], [maLoai]) VALUES (N'N008', N'Nguyễn Hoàng Duy', CAST(N'2001-08-25' AS Date), N'0876342235', 1, N'hoangduy@gmail.com', N'19 Nguyễn Thị Minh Khai, Bến Nghé, Q1', N'L003')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P01', N'1', N'L02', 100000, N'1 TV', N'Phòng đang sử dụng')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P02', N'2', N'L02', 100000, N'1 TV', N'Phòng trống')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P03', N'3', N'L02', 100000, N'1 TV', N'Phòng trống')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P04', N'4', N'L01', 250000, N'2 TV', N'Phòng trống')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P05', N'5', N'L02', 100000, N'1TV', N'Phòng đang sử dụng')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P06', N'6', N'L02', 100000, N'1TV', N'Phòng trống')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P07', N'7', N'L01', 250000, N'2 TV', N'Phòng trống')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P08', N'8', N'L01', 250000, N'2 TV', N'Phòng trống')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P09', N'9', N'L02', 100000, N'1 TV', N'Phòng trống')
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [maLoaiPhong], [giaPhong], [mieuTa], [tinhTrang]) VALUES (N'P10', N'10', N'L02', 100000, N'1 TV', N'Phòng trống')
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'baoan', N'anan17', N'N006', NULL)
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'congnguyen', N'nguyen12', N'N001', NULL)
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'haivy', N'vyvy20', NULL, N'K003')
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'linhchi', N'chichi22', NULL, N'K005')
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'minhhai', N'minhhai21', NULL, N'K004')
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'minhtam', N'tamtam15', N'N004', NULL)
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'nhole', N'nhole13', N'N002', NULL)
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'phuclam', N'lamlam19', NULL, N'K002')
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'vanan', N'vanan18', NULL, N'K001')
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'xuannguyen', N'xnguyen14', N'N003', NULL)
INSERT [dbo].[TaiKhoan] ([username], [password], [maNV], [maKH]) VALUES (N'yennhu', N'nhu16', N'N005', NULL)
ALTER TABLE [dbo].[CT_DonDat]  WITH CHECK ADD  CONSTRAINT [FK_CT_DonDat_DichVu] FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDV])
GO
ALTER TABLE [dbo].[CT_DonDat] CHECK CONSTRAINT [FK_CT_DonDat_DichVu]
GO
ALTER TABLE [dbo].[CT_DonDat]  WITH CHECK ADD  CONSTRAINT [FK_CT_DonDat_DonDatPhong] FOREIGN KEY([maDon])
REFERENCES [dbo].[DonDatPhong] ([maDon])
GO
ALTER TABLE [dbo].[CT_DonDat] CHECK CONSTRAINT [FK_CT_DonDat_DonDatPhong]
GO
ALTER TABLE [dbo].[CT_Hoadon]  WITH CHECK ADD  CONSTRAINT [FK_CT_Hoadon_DichVu] FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDV])
GO
ALTER TABLE [dbo].[CT_Hoadon] CHECK CONSTRAINT [FK_CT_Hoadon_DichVu]
GO
ALTER TABLE [dbo].[CT_Hoadon]  WITH CHECK ADD  CONSTRAINT [FK_CT_Hoadon_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[CT_Hoadon] CHECK CONSTRAINT [FK_CT_Hoadon_HoaDon]
GO
ALTER TABLE [dbo].[CT_HoaDonPhong]  WITH CHECK ADD  CONSTRAINT [FK_CT_HoaDonPhong_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[CT_HoaDonPhong] CHECK CONSTRAINT [FK_CT_HoaDonPhong_HoaDon]
GO
ALTER TABLE [dbo].[CT_HoaDonPhong]  WITH CHECK ADD  CONSTRAINT [FK_CT_HoaDonPhong_Phong1] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[CT_HoaDonPhong] CHECK CONSTRAINT [FK_CT_HoaDonPhong_Phong1]
GO
ALTER TABLE [dbo].[DonDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DonDatPhong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[DonDatPhong] CHECK CONSTRAINT [FK_DonDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[DonDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DonDatPhong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[DonDatPhong] CHECK CONSTRAINT [FK_DonDatPhong_Phong]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_DonDatPhong] FOREIGN KEY([maDon])
REFERENCES [dbo].[DonDatPhong] ([maDon])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_DonDatPhong]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_LoaiNV] FOREIGN KEY([maLoai])
REFERENCES [dbo].[LoaiNV] ([maLoai])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_LoaiNV]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([maLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([maLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_KhachHang]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [QLKaraoke] SET  READ_WRITE 
GO
