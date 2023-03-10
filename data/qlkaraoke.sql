USE [master]
GO
/****** Object:  Database [QLKaraoke]    Script Date: 28/10/2021 5:28:56 CH ******/
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
/****** Object:  Table [dbo].[CaTruc]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CaTruc](
	[maCa] [varchar](50) NOT NULL,
	[gioBD] [time](7) NULL,
	[gioKT] [time](7) NULL,
	[mucLuong] [int] NULL,
 CONSTRAINT [PK_CaTruc] PRIMARY KEY CLUSTERED 
(
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CT_CaTruc]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CT_CaTruc](
	[maCa] [varchar](50) NULL,
	[soCa] [int] NULL,
	[maNV] [varchar](50) NULL,
	[maCT_CT] [varchar](50) NOT NULL,
	[Ngaytruc] [datetime] NULL,
	[Thanhtien] [int] NULL,
 CONSTRAINT [PK_CT_CaTruc] PRIMARY KEY CLUSTERED 
(
	[maCT_CT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CT_HoaDon]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CT_HoaDon](
	[maCT_HD] [varchar](50) NOT NULL,
	[maHD] [varchar](50) NULL,
	[soLuong] [int] NULL,
	[maPhong] [varchar](50) NULL,
	[gioThue] [datetime] NULL,
	[gioTra] [datetime] NULL,
	[giaPhong] [int] NULL,
	[maDV] [varchar](50) NULL,
	[giaDV] [int] NULL,
	[ngayThue] [datetime] NULL,
	[tongtien] [int] NULL,
 CONSTRAINT [PK_CT_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maCT_HD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDV] [varchar](50) NOT NULL,
	[tenDV] [varchar](50) NULL,
	[thongtinDV] [varchar](100) NULL,
	[giaDV] [int] NULL,
	[maNV] [varchar](50) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[maDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DonDatPhong]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DonDatPhong](
	[maDon] [varchar](50) NOT NULL,
	[tenDon] [varchar](50) NULL,
	[maPhong] [varchar](50) NULL,
	[maKH] [varchar](50) NULL,
	[maNV] [varchar](50) NULL,
	[gioThue] [datetime] NULL,
	[ngayThue] [datetime] NULL,
	[maDV] [varchar](50) NULL,
 CONSTRAINT [PK_DonDatPhong] PRIMARY KEY CLUSTERED 
(
	[maDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 28/10/2021 5:28:56 CH ******/
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
	[gioThue] [datetime] NULL,
	[gioTra] [datetime] NULL,
	[ngayThue] [datetime] NULL,
	[tongTien] [int] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [varchar](50) NOT NULL,
	[tenKH] [varchar](50) NULL,
	[sdt] [nvarchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[cmnd] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[tuoi] [int] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiNV]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiNV](
	[maLoai] [varchar](50) NOT NULL,
	[tenLoai] [varchar](50) NULL,
 CONSTRAINT [PK_LoaiNV] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLoaiPhong] [varchar](50) NOT NULL,
	[tenLoaiPhong] [varchar](50) NULL,
	[thongtinPhong] [varchar](100) NULL,
	[socho] [int] NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[maLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 28/10/2021 5:28:56 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](50) NOT NULL,
	[tenNV] [varchar](50) NULL,
	[ngaysinh] [date] NULL,
	[sdt] [varchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[email] [varchar](50) NULL,
	[diaChi] [varchar](50) NULL,
	[maLoai] [varchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 28/10/2021 5:28:56 CH ******/
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
	[tinhTrang] [varchar](50) NULL,
	[maNV] [varchar](50) NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 28/10/2021 5:28:56 CH ******/
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
ALTER TABLE [dbo].[CT_CaTruc]  WITH CHECK ADD  CONSTRAINT [FK_CT_CaTruc_CaTruc] FOREIGN KEY([maCa])
REFERENCES [dbo].[CaTruc] ([maCa])
GO
ALTER TABLE [dbo].[CT_CaTruc] CHECK CONSTRAINT [FK_CT_CaTruc_CaTruc]
GO
ALTER TABLE [dbo].[CT_CaTruc]  WITH CHECK ADD  CONSTRAINT [FK_CT_CaTruc_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[CT_CaTruc] CHECK CONSTRAINT [FK_CT_CaTruc_NhanVien]
GO
ALTER TABLE [dbo].[CT_HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CT_HoaDon_DichVu] FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDV])
GO
ALTER TABLE [dbo].[CT_HoaDon] CHECK CONSTRAINT [FK_CT_HoaDon_DichVu]
GO
ALTER TABLE [dbo].[CT_HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CT_HoaDon_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[CT_HoaDon] CHECK CONSTRAINT [FK_CT_HoaDon_HoaDon]
GO
ALTER TABLE [dbo].[CT_HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CT_HoaDon_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[CT_HoaDon] CHECK CONSTRAINT [FK_CT_HoaDon_Phong]
GO
ALTER TABLE [dbo].[DichVu]  WITH CHECK ADD  CONSTRAINT [FK_DichVu_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[DichVu] CHECK CONSTRAINT [FK_DichVu_NhanVien]
GO
ALTER TABLE [dbo].[DonDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DonDatPhong_DichVu] FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDV])
GO
ALTER TABLE [dbo].[DonDatPhong] CHECK CONSTRAINT [FK_DonDatPhong_DichVu]
GO
ALTER TABLE [dbo].[DonDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DonDatPhong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[DonDatPhong] CHECK CONSTRAINT [FK_DonDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[DonDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DonDatPhong_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[DonDatPhong] CHECK CONSTRAINT [FK_DonDatPhong_NhanVien]
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
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_NhanVien]
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
