-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 06 Mars 2015 à 14:56
-- Version du serveur: 5.5.41-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `alpa_no`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `administrator`
--

INSERT INTO `administrator` (`id`, `name`, `password`) VALUES
(1, 'admin', 'password');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `flight`
--

INSERT INTO `flight` (`id`, `id_plane`, `description`) VALUES
(1, 1, 'Cet avion sait voler.'),
(2, 2, 'Cet avion ne vole pas tr?s tr?s bien.');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `hotel`
--

INSERT INTO `hotel` (`id`, `name`) VALUES
(1, 'Hotel Carlton'),
(2, 'Hotel California'),
(3, 'Hotel Wonderland');

-- --------------------------------------------------------

--
-- Structure de la table `link_panel_hotel`
--

CREATE TABLE IF NOT EXISTS `link_panel_hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` int(11) NOT NULL,
  `id_panel` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `link_panel_hotel`
--

INSERT INTO `link_panel_hotel` (`id`, `id_hotel`, `id_panel`) VALUES
(1, 1, 3),
(2, 2, 3),
(3, 3, 4),
(4, 1, 4);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `panel`
--

INSERT INTO `panel` (`id`, `id_flight`, `date_begin`, `date_end`) VALUES
(3, 1, '2015-02-06 14:00:00', '2015-02-06 15:00:00'),
(4, 2, '2015-02-06 14:00:00', '2015-02-06 16:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `plane`
--

CREATE TABLE IF NOT EXISTS `plane` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `plane`
--

INSERT INTO `plane` (`id`, `name`) VALUES
(1, 'TransAsia Airways ATR 72-600'),
(2, 'AirAsia Indonesia Airbus A320-216 '),
(3, 'Unijet Dassault Falcon 50EX '),
(4, 'Sepahan Airlines HESA IrAn-140-100 ');

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