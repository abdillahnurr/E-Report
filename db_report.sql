-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Des 2021 pada 13.06
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_report`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE `akun` (
  `nama` varchar(40) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`nama`, `username`, `password`, `role`) VALUES
('Abdillah Nur Ridho', 'abdillahnurr', '7777', 'Siswa'),
('admin', 'admin', 'admin', 'admin'),
('Ibnu Alfarezi', 'alfarezi', '1111', 'Siswa'),
('Ananda Putra', 'anaput', '5555', 'Siswa'),
('Ari Satria', 'arisadar', '3333', 'Siswa'),
('Bhanu Pangestu', 'bhapang', '2222', 'Siswa'),
('Mariani', 'marmar', '1111', 'Guru'),
('Mulyadi', 'mul12', '1212', 'Guru'),
('Rezieq Fadhilah', 'refa22', '2222', 'Siswa'),
('Rifki Pratama', 'rifma', 'qwerty', 'Siswa');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilai`
--

CREATE TABLE `nilai` (
  `id_siswa` int(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `kelas` varchar(3) NOT NULL,
  `mtk` int(11) DEFAULT NULL,
  `bindo` int(11) DEFAULT NULL,
  `basing` int(11) DEFAULT NULL,
  `rerata` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `nilai`
--

INSERT INTO `nilai` (`id_siswa`, `nama`, `kelas`, `mtk`, `bindo`, `basing`, `rerata`) VALUES
(1, 'Abdillah Nur Ridho', '9A', 99, 96, 97, 97),
(4, 'Ari Satria', '9B', 96, 85, 88, 90),
(6, 'Bhanu Pangestu', '9A', 90, 80, 98, 89);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`id_siswa`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `nilai`
--
ALTER TABLE `nilai`
  MODIFY `id_siswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
