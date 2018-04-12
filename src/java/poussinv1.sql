-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 12 Avril 2018 à 13:52
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `poussinv1`
--

-- --------------------------------------------------------

--
-- Structure de la table `backup`
--

CREATE TABLE IF NOT EXISTS `backup` (
  `ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categorieoeuf`
--

CREATE TABLE IF NOT EXISTS `categorieoeuf` (
  `ID` bigint(20) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `couvoir`
--

CREATE TABLE IF NOT EXISTS `couvoir` (
  `ID` bigint(20) NOT NULL,
  `CAPACITEMAX` decimal(38,0) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `device`
--

CREATE TABLE IF NOT EXISTS `device` (
  `ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `eclosion`
--

CREATE TABLE IF NOT EXISTS `eclosion` (
  `ID` bigint(20) NOT NULL,
  `ANNEE` int(11) DEFAULT NULL,
  `COMMERCIALISE` decimal(38,0) DEFAULT NULL,
  `DATEECLOSION` datetime DEFAULT NULL,
  `ECARTECLOSION` decimal(38,0) DEFAULT NULL,
  `ECARTTRIE` decimal(38,0) DEFAULT NULL,
  `NUMEROSEMAINE` int(11) DEFAULT NULL,
  `SEMAINE` int(11) DEFAULT NULL,
  `TRIEOEUFPARCATEGORIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ECLOSION_TRIEOEUFPARCATEGORIE_ID` (`TRIEOEUFPARCATEGORIE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `entreepoussin`
--

CREATE TABLE IF NOT EXISTS `entreepoussin` (
  `ID` bigint(20) NOT NULL,
  `ANNEE` int(11) DEFAULT NULL,
  `DATEENTREE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `MORTALITE` decimal(38,0) DEFAULT NULL,
  `NUMEROSEMAINE` int(11) DEFAULT NULL,
  `POIDS` decimal(38,0) DEFAULT NULL,
  `PRODUCTION` decimal(38,0) DEFAULT NULL,
  `RELIQUAT` decimal(38,0) DEFAULT NULL,
  `SEMAINE` int(11) DEFAULT NULL,
  `TOTALFEMALE` decimal(38,0) DEFAULT NULL,
  `TOTALMALE` decimal(38,0) DEFAULT NULL,
  `TOTALE` decimal(38,0) DEFAULT NULL,
  `TRANSFERT` decimal(38,0) DEFAULT NULL,
  `VENTE` decimal(38,0) DEFAULT NULL,
  `PRODUCTIONOEUFFOURNISSEUR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ENTREEPOUSSIN_PRODUCTIONOEUFFOURNISSEUR_ID` (`PRODUCTIONOEUFFOURNISSEUR_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `firme`
--

CREATE TABLE IF NOT EXISTS `firme` (
  `ID` bigint(20) NOT NULL,
  `CAPACITEMAX` decimal(38,0) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE IF NOT EXISTS `fournisseur` (
  `ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `historiqueconnexionuser`
--

CREATE TABLE IF NOT EXISTS `historiqueconnexionuser` (
  `ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `productionfirme`
--

CREATE TABLE IF NOT EXISTS `productionfirme` (
  `ID` bigint(20) NOT NULL,
  `ADTEPRODUCTIONFIRME` datetime DEFAULT NULL,
  `AGE` decimal(38,0) DEFAULT NULL,
  `ANNEE` int(11) DEFAULT NULL,
  `MORTALITE` decimal(38,0) DEFAULT NULL,
  `NUMEROSEMAINE` int(11) DEFAULT NULL,
  `POIDS` decimal(38,0) DEFAULT NULL,
  `PRODUCTION` decimal(38,0) DEFAULT NULL,
  `RELIQUAT` decimal(38,0) DEFAULT NULL,
  `SEMAINE` int(11) DEFAULT NULL,
  `TRANSFERT` decimal(38,0) DEFAULT NULL,
  `VENTE` decimal(38,0) DEFAULT NULL,
  `ENTREEPOUSSIN_ID` bigint(20) DEFAULT NULL,
  `FIRME_ID` bigint(20) DEFAULT NULL,
  `PRODUCTIONOEUFALIMENTFEMALE_ID` bigint(20) DEFAULT NULL,
  `PRODUCTIONOEUFALIMENTMALE_ID` bigint(20) DEFAULT NULL,
  `PRODUCTIONOEUFFEMALE_ID` bigint(20) DEFAULT NULL,
  `PRODUCTIONOEUFMALE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUCTIONFIRME_FIRME_ID` (`FIRME_ID`),
  KEY `FK_PRODUCTIONFIRME_PRODUCTIONOEUFFEMALE_ID` (`PRODUCTIONOEUFFEMALE_ID`),
  KEY `FK_PRODUCTIONFIRME_PRODUCTIONOEUFALIMENTFEMALE_ID` (`PRODUCTIONOEUFALIMENTFEMALE_ID`),
  KEY `FK_PRODUCTIONFIRME_ENTREEPOUSSIN_ID` (`ENTREEPOUSSIN_ID`),
  KEY `FK_PRODUCTIONFIRME_PRODUCTIONOEUFALIMENTMALE_ID` (`PRODUCTIONOEUFALIMENTMALE_ID`),
  KEY `FK_PRODUCTIONFIRME_PRODUCTIONOEUFMALE_ID` (`PRODUCTIONOEUFMALE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `productionfirmealiment`
--

CREATE TABLE IF NOT EXISTS `productionfirmealiment` (
  `ID` bigint(20) NOT NULL,
  `CONSOMMATION` decimal(38,0) DEFAULT NULL,
  `ENTREE` decimal(38,0) DEFAULT NULL,
  `SITUATIONFINALE` decimal(38,0) DEFAULT NULL,
  `SITUATIONINITIALE` decimal(38,0) DEFAULT NULL,
  `TRANSFERT` decimal(38,0) DEFAULT NULL,
  `VENTE` decimal(38,0) DEFAULT NULL,
  `TYPEALIMENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUCTIONFIRMEALIMENT_TYPEALIMENT_ID` (`TYPEALIMENT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `productionfirmepargender`
--

CREATE TABLE IF NOT EXISTS `productionfirmepargender` (
  `ID` bigint(20) NOT NULL,
  `EFFECTIFDEBUTJOUR` decimal(38,0) DEFAULT NULL,
  `EFFECTIFFINJOUR` decimal(38,0) DEFAULT NULL,
  `ENTREE` decimal(38,0) DEFAULT NULL,
  `MORTALITE` decimal(38,0) DEFAULT NULL,
  `TRANSFERT` decimal(38,0) DEFAULT NULL,
  `VENTE` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `productionfournisseur`
--

CREATE TABLE IF NOT EXISTS `productionfournisseur` (
  `ID` bigint(20) NOT NULL,
  `NBROEUF` decimal(38,0) DEFAULT NULL,
  `NUMEROSEMAINE` decimal(38,0) DEFAULT NULL,
  `POIDS` decimal(38,0) DEFAULT NULL,
  `FOURNISSEUR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUCTIONFOURNISSEUR_FOURNISSEUR_ID` (`FOURNISSEUR_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '0');

-- --------------------------------------------------------

--
-- Structure de la table `transfertcouvoir`
--

CREATE TABLE IF NOT EXISTS `transfertcouvoir` (
  `ID` bigint(20) NOT NULL,
  `DATETRANSFERT` datetime DEFAULT NULL,
  `QTE` decimal(38,0) DEFAULT NULL,
  `COUVOIR_ID` bigint(20) DEFAULT NULL,
  `FIRME_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TRANSFERTCOUVOIR_COUVOIR_ID` (`COUVOIR_ID`),
  KEY `FK_TRANSFERTCOUVOIR_FIRME_ID` (`FIRME_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `transfertfirme`
--

CREATE TABLE IF NOT EXISTS `transfertfirme` (
  `ID` bigint(20) NOT NULL,
  `DATETRANSFERT` datetime DEFAULT NULL,
  `QTE` decimal(38,0) DEFAULT NULL,
  `FIRMEDESTINATION_ID` bigint(20) DEFAULT NULL,
  `FIRMESOURCE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TRANSFERTFIRME_FIRMESOURCE_ID` (`FIRMESOURCE_ID`),
  KEY `FK_TRANSFERTFIRME_FIRMEDESTINATION_ID` (`FIRMEDESTINATION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `trieoeuf`
--

CREATE TABLE IF NOT EXISTS `trieoeuf` (
  `ID` bigint(20) NOT NULL,
  `ANNEE` int(11) DEFAULT NULL,
  `DATETRIE` datetime DEFAULT NULL,
  `DON` decimal(38,0) DEFAULT NULL,
  `ENTREE` decimal(38,0) DEFAULT NULL,
  `PERTE` decimal(38,0) DEFAULT NULL,
  `RECEPTION` decimal(38,0) DEFAULT NULL,
  `RELIQUAT` decimal(38,0) DEFAULT NULL,
  `SEMAINE` int(11) DEFAULT NULL,
  `VENTE` decimal(38,0) DEFAULT NULL,
  `COUVOIR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TRIEOEUF_COUVOIR_ID` (`COUVOIR_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `trieoeufparcategorie`
--

CREATE TABLE IF NOT EXISTS `trieoeufparcategorie` (
  `ID` bigint(20) NOT NULL,
  `DON` decimal(38,0) DEFAULT NULL,
  `ENTREE` decimal(38,0) DEFAULT NULL,
  `MISEENINCUBATION` decimal(38,0) DEFAULT NULL,
  `PERTE` decimal(38,0) DEFAULT NULL,
  `POURCENTAGE` decimal(38,0) DEFAULT NULL,
  `SITUATIONFINALE` decimal(38,0) DEFAULT NULL,
  `SITUATIONINITIALE` decimal(38,0) DEFAULT NULL,
  `TOTALECLOSION` decimal(38,0) DEFAULT NULL,
  `VENTE` decimal(38,0) DEFAULT NULL,
  `CATEGORIEOEUF_ID` bigint(20) DEFAULT NULL,
  `TRIEOEUF_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TRIEOEUFPARCATEGORIE_TRIEOEUF_ID` (`TRIEOEUF_ID`),
  KEY `FK_TRIEOEUFPARCATEGORIE_CATEGORIEOEUF_ID` (`CATEGORIEOEUF_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typealiment`
--

CREATE TABLE IF NOT EXISTS `typealiment` (
  `ID` bigint(20) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `LOGIN` varchar(255) NOT NULL,
  `BLOCKED` int(11) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `TEL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LOGIN`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
