-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 03 Avril 2015 à 11:13
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `administrator`
--

INSERT INTO `administrator` (`id`, `name`, `password`) VALUES
(1, 'ballanb', 'admin'),
(2, 'camenenj', 'admin'),
(3, 'giboireg', 'admin'),
(4, 'kerarvranl', 'admin');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `flight`
--

INSERT INTO `flight` (`id`, `id_plane`, `description`) VALUES
(1, 5, 'Paris-France -> Phoenix-États Unis (Air France)'),
(2, 2, 'Nantes-France -> Londre-Royaume Uni (Corsaire)'),
(3, 2, 'Londre-Royaume Uni -> Dubai-Émirats Arabes Unis (Corsaire)'),
(4, 6, 'Ankara-Turquie -> Rome-Italie (Ryanair)'),
(5, 7, 'Munich-Allemagne -> New York-États Unis (Lufthansa)'),
(6, 1, 'Los Angeles-États Unis -> Cancun-Mexique (American Arilines)'),
(7, 3, 'Londre-Royaume Uni -> Paris-France (British Airways)'),
(8, 8, 'Marseille-France -> Paradise Island-Bahamas (KLM)'),
(9, 4, 'Phoenix-États Unis -> New York-États Unis Unis (Sky Arilines)'),
(10, 9, 'Madrid-Espagne -> Rome-Italie (Easyjet)');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `hotel`
--

INSERT INTO `hotel` (`id`, `name`) VALUES
(1, 'Le Palais des Émirats - Abu Dhabi - Émirats Arabes Unis'),
(2, 'Hôtel Mardan Palace - Antalya - Turquie'),
(3, 'Hôtel Westin Excelsior - Rome - Italie'),
(4, 'Hôtel Burj Al Arab - Dubai - Émirats Arabes Unis'),
(5, 'Hôtel Plaza - New York - États Unis'),
(6, 'Atlantis Paradise Island - Paradise Island - Bahamas'),
(7, 'Hôtel Palms - Las Vegas - États Unis'),
(8, 'Hôtel The Boulders - Arizona - États Unis'),
(9, 'Hôtel CuisinArt Golf Resort & Spa - Anguilla - Royaume Uni'),
(10, 'Hôtel Secrets Marquis - Los Cabos - Mexique');

-- --------------------------------------------------------

--
-- Structure de la table `link_panel_hotel`
--

CREATE TABLE IF NOT EXISTS `link_panel_hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` int(11) NOT NULL,
  `id_panel` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `link_panel_hotel`
--

INSERT INTO `link_panel_hotel` (`id`, `id_hotel`, `id_panel`) VALUES
(1, 8, 1),
(2, 9, 2),
(3, 4, 3),
(4, 3, 4),
(5, 5, 5),
(6, 10, 6),
(7, 3, 7),
(8, 6, 8),
(9, 5, 9);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `panel`
--

INSERT INTO `panel` (`id`, `id_flight`, `date_begin`, `date_end`) VALUES
(1, 1, '2015-04-03 10:00:00', '2015-04-04 15:00:00'),
(2, 2, '2015-04-03 06:00:00', '2015-04-03 12:00:00'),
(3, 3, '2015-04-03 13:00:00', '2015-04-03 14:00:00'),
(4, 4, '2015-04-03 07:00:00', '2015-04-03 13:00:00'),
(5, 5, '2015-04-03 06:00:00', '2015-04-03 17:00:00'),
(6, 6, '2015-04-03 15:30:00', '2015-04-03 17:00:00'),
(7, 7, '2015-04-03 20:05:00', '2015-04-03 23:35:00'),
(8, 8, '2015-04-03 10:30:00', '2015-04-03 12:30:00'),
(9, 9, '2015-04-03 08:15:00', '2015-04-03 12:15:00');

-- --------------------------------------------------------

--
-- Structure de la table `plane`
--

CREATE TABLE IF NOT EXISTS `plane` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `plane`
--

INSERT INTO `plane` (`id`, `name`) VALUES
(1, 'Airbus A318-111-F-GUGA '),
(2, 'Airbus A330-203-F-GZCB '),
(3, 'Airbus A340-311-F-GLZC '),
(4, 'Airbus A340-313-F-GLZM '),
(5, 'Airbus A320-211-F-GHQM '),
(6, 'Airbus A380-861-MSN049 '),
(7, 'Boeing 777-228/ER-F-GSPG '),
(8, 'Boeing B747-428-F-GITF '),
(9, 'Boeing B747-428ERF-F-GIUA ');

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
