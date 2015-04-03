-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 03 Avril 2015 à 10:53
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `alpa_no`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `administrator`
--

INSERT INTO `administrator` (`id`, `name`, `password`) VALUES
(1, 'admin', 'password'),
(2, 'ballanb', 'admin'),
(3, 'camenenj', 'admin'),
(4, 'giboireg', 'admin'),
(5, 'kerarvranl', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `flight`
--

CREATE TABLE IF NOT EXISTS `flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_plane` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_plane` (`id_plane`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `flight`
--

INSERT INTO `flight` (`id`, `id_plane`, `description`) VALUES
(1, 1, 'Cet avion sait voler.'),
(2, 2, 'Cet avion ne vole pas tr?s tr?s bien.'),
(3, 5, 'Paris-France -> Phoenix-États Unis (Air France)'),
(4, 2, 'Nantes-France -> Londre-Royaume Uni (Corsaire)'),
(5, 2, 'Londre-Royaume Uni -> Dubai-Émirats Arabes Unis (Corsaire)'),
(6, 6, 'Ankara-Turquie -> Rome-Italie (Ryanair)'),
(7, 7, 'Munich-Allemagne -> New York-États Unis (Lufthansa)'),
(8, 1, 'Los Angeles-États Unis -> Cancun-Mexique (American Arilines)'),
(9, 3, 'Londre-Royaume Uni -> Paris-France (British Airways)'),
(10, 8, 'Marseille-France -> Paradise Island-Bahamas (KLM)'),
(11, 4, 'Phoenix-États Unis -> New York-États Unis Unis (Sky Arilines)'),
(12, 9, 'Madrid-Espagne -> Rome-Italie (Easyjet)');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `hotel`
--

INSERT INTO `hotel` (`id`, `name`) VALUES
(1, 'Hotel Carlton'),
(2, 'Hotel California'),
(3, 'Hotel Wonderland'),
(4, 'Le Palais des Émirats - Abu Dhabi - Émirats Arabes Unis'),
(5, 'Hôtel Mardan Palace - Antalya - Turquie'),
(6, 'Hôtel Westin Excelsior - Rome - Italie'),
(7, 'Hôtel Burj Al Arab - Dubai - Émirats Arabes Unis'),
(8, 'Hôtel Plaza - New York - États Unis'),
(9, 'Atlantis Paradise Island - Paradise Island - Bahamas'),
(10, 'Hôtel Palms - Las Vegas - États Unis'),
(11, 'Hôtel The Boulders - Arizona - États Unis'),
(12, 'Hôtel CuisinArt Golf Resort & Spa - Anguilla - Royaume Uni'),
(13, 'Hôtel Secrets Marquis - Los Cabos - Mexique');

-- --------------------------------------------------------

--
-- Structure de la table `link_panel_hotel`
--

CREATE TABLE IF NOT EXISTS `link_panel_hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` int(11) NOT NULL,
  `id_panel` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `link_panel_hotel`
--

INSERT INTO `link_panel_hotel` (`id`, `id_hotel`, `id_panel`) VALUES
(1, 1, 3),
(2, 2, 3),
(3, 3, 4),
(4, 1, 4),
(5, 8, 1),
(6, 9, 2),
(7, 4, 3),
(8, 3, 4),
(9, 5, 5),
(10, 10, 6),
(11, 3, 7),
(12, 6, 8),
(13, 5, 9);

-- --------------------------------------------------------

--
-- Structure de la table `panel`
--

CREATE TABLE IF NOT EXISTS `panel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_flight` int(11) NOT NULL,
  `date_begin` datetime NOT NULL,
  `date_end` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_flight` (`id_flight`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `panel`
--

INSERT INTO `panel` (`id`, `id_flight`, `date_begin`, `date_end`) VALUES
(3, 1, '2015-02-06 14:00:00', '2015-02-06 15:00:00'),
(4, 2, '2015-02-06 14:00:00', '2015-02-06 16:00:00'),
(5, 1, '2015-04-03 10:00:00', '2015-04-04 15:00:00'),
(6, 2, '2015-04-03 06:00:00', '2015-04-03 12:00:00'),
(7, 3, '2015-04-03 13:00:00', '2015-04-03 14:00:00'),
(8, 4, '2015-04-03 07:00:00', '2015-04-03 13:00:00'),
(9, 5, '2015-04-03 06:00:00', '2015-04-03 17:00:00'),
(10, 6, '2015-04-03 15:30:00', '2015-04-03 17:00:00'),
(11, 7, '2015-04-03 20:05:00', '2015-04-03 23:35:00'),
(12, 8, '2015-04-03 10:30:00', '2015-04-03 12:30:00'),
(13, 9, '2015-04-03 08:15:00', '2015-04-03 12:15:00');

-- --------------------------------------------------------

--
-- Structure de la table `plane`
--

CREATE TABLE IF NOT EXISTS `plane` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `plane`
--

INSERT INTO `plane` (`id`, `name`) VALUES
(1, 'TransAsia Airways ATR 72-600'),
(2, 'AirAsia Indonesia Airbus A320-216 '),
(3, 'Unijet Dassault Falcon 50EX '),
(4, 'Sepahan Airlines HESA IrAn-140-100 '),
(5, 'Airbus A318-111-F-GUGA '),
(6, 'Airbus A330-203-F-GZCB '),
(7, 'Airbus A340-311-F-GLZC '),
(8, 'Airbus A340-313-F-GLZM '),
(9, 'Airbus A320-211-F-GHQM '),
(10, 'Airbus A380-861-MSN049 '),
(11, 'Boeing 777-228/ER-F-GSPG '),
(12, 'Boeing B747-428-F-GITF '),
(13, 'Boeing B747-428ERF-F-GIUA ');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `FK_plane` FOREIGN KEY (`id_plane`) REFERENCES `plane` (`id`);

--
-- Contraintes pour la table `panel`
--
ALTER TABLE `panel`
  ADD CONSTRAINT `FK_flight` FOREIGN KEY (`id_flight`) REFERENCES `flight` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
