-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 12 Tem 2022, 17:23:49
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `patika`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `patika_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `lang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `course`
--

INSERT INTO `course` (`id`, `user_id`, `patika_id`, `name`, `lang`) VALUES
(1, 2, 1, 'Java 102 Dersleri', 'Java Spring');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `enrolled_user`
--

CREATE TABLE `enrolled_user` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `patika_id` int(11) NOT NULL,
  `patika_name` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `patika`
--

CREATE TABLE `patika` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `patika`
--

INSERT INTO `patika` (`id`, `name`) VALUES
(1, 'Java Backend Patikasi'),
(2, 'Dev Operations'),
(3, 'Front-end');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `type` enum('operator','educator','student') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `name`, `uname`, `pass`, `type`) VALUES
(1, 'Emre Bağlayici', 'emrebaglayici', '123456', 'operator'),
(2, 'Elif Sayilı', 'elifsayili', '12345', 'educator'),
(7, 'Simay Çeliks', 'simaycelik', '123456', 'educator'),
(12, 'kamile', 'kamilee', '123', 'student'),
(13, 'Ahmet Tanrıkulu', 'tanrikulu', '123456', 'student'),
(14, 'Şenol', 'senolinn', '123', 'student'),
(15, 'Fatih Tamer', 'fati', '123', 'student'),
(16, 'Allah Verdi', 'allahverdi', '123', 'student');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `enrolled_user`
--
ALTER TABLE `enrolled_user`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `patika`
--
ALTER TABLE `patika`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `enrolled_user`
--
ALTER TABLE `enrolled_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `patika`
--
ALTER TABLE `patika`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
