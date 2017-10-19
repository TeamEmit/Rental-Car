-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ott 19, 2017 alle 16:37
-- Versione del server: 10.1.21-MariaDB
-- Versione PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rent`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `Email` varchar(70) NOT NULL,
  `Nome` varchar(70) NOT NULL,
  `Cognome` varchar(70) NOT NULL,
  `Password` varchar(70) NOT NULL,
  `Carta_di_Credito` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`Email`, `Nome`, `Cognome`, `Password`, `Carta_di_Credito`) VALUES
('carmen.totino@ied.it', 'Carmen', 'Totino', 'Carat90GG', '1200075342139777'),
('cicciopasticcio@libero.it', 'Francesco', 'Pasticcini', '23537fk', '1300800504391276'),
('giannitornio45@tiscali.it', 'Giovanni', 'Tornio', '236yt', '1200800504391280'),
('ilbellubaldo@polimi.it', 'Ubaldo', 'Valentino', 'ymca75', '9238500200139485'),
('ilmagnifico@hotmail.it', 'Lorenzo', 'De Medici', 'lore123MD', '7659124254339733'),
('jackcash@betfair.com', 'Giancluca', 'Cascione', 'dollar13', '0023002008997772'),
('marco_voci_457@hotmail.it', 'Marco', 'Voci', 'gw356fg', '1300560504391265'),
('monicamonica23@aruba.it', 'Monica', 'Monicelli', 'momo65', '0980800504561276');

-- --------------------------------------------------------

--
-- Struttura della tabella `utente_veicolo`
--

CREATE TABLE `utente_veicolo` (
  `ID_Rent` int(30) NOT NULL,
  `Email` varchar(70) NOT NULL,
  `Targa` varchar(70) NOT NULL,
  `Periodo_di_Inizio` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `utente_veicolo`
--

INSERT INTO `utente_veicolo` (`ID_Rent`, `Email`, `Targa`, `Periodo_di_Inizio`) VALUES
(2, 'cicciopasticcio@libero.it', 'YH723BC', '2017-10-19 16:16:04');

-- --------------------------------------------------------

--
-- Struttura della tabella `veicolo`
--

CREATE TABLE `veicolo` (
  `Targa` varchar(7) NOT NULL,
  `Marca` varchar(35) NOT NULL,
  `Modello` varchar(30) NOT NULL,
  `Tipologia` enum('Berlina','Cabrio','Fuoristrada','Furgone','Monovolume','Station Wagon','SUV','Utilitaria') NOT NULL,
  `Colore` enum('Bianco','Nero','Grigio','Rosso','Blu','Verde','Giallo','Marrone') NOT NULL,
  `Costo_Giornaliero` int(30) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `veicolo`
--

INSERT INTO `veicolo` (`Targa`, `Marca`, `Modello`, `Tipologia`, `Colore`, `Costo_Giornaliero`) VALUES
('AB345TS', 'Volvo', 'V40', 'Berlina', 'Blu', 40),
('CD634SA', 'Citroen', 'C1', 'Utilitaria', 'Verde', 18),
('DF313PG', 'Ford', 'Focus', 'Station Wagon', 'Blu', 30),
('DS418CX', 'KIA', 'Picanto', 'Station Wagon', 'Rosso', 28),
('EF757RE', 'Fiat', 'Panda', 'Utilitaria', 'Verde', 18),
('ER497PO', 'Citroen', 'Berlingo', 'Monovolume', 'Rosso', 30),
('FC790OB', 'Alfa Romeo', 'Giulietta', 'Berlina', 'Rosso', 20),
('FD392WS', 'Ford', 'Mondeo', 'Station Wagon', 'Bianco', 30),
('FF675ZZ', 'Volvo', 'S90', 'Berlina', 'Grigio', 40),
('FG673NG', 'Nissan', 'Juke', 'SUV', 'Bianco', 70),
('GN987DG', 'Porsche', '911', 'Cabrio', 'Giallo', 250),
('GR442LL', 'Volkswagen', 'Transporter', 'Furgone', 'Giallo', 55),
('HG345IP', 'Iveco', 'Daily', 'Furgone', 'Bianco', 45),
('IP875BF', 'Nissan', 'Juke', 'SUV', 'Bianco', 70),
('RD925HJ', 'BMW', 'X3', 'Fuoristrada', 'Blu', 60),
('RF478KJ', 'Porsche', 'Cayenne', 'SUV', 'Nero', 100),
('RF567TR', 'Fiat', 'Panda', 'Utilitaria', 'Bianco', 18),
('SA676LA', 'Fiat', 'Ducato', 'Furgone', 'Bianco', 40),
('SW232GF', 'Citroen', 'C1', 'Utilitaria', 'Bianco', 18),
('TF834IK', 'Citroen', 'Berlingo', 'Monovolume', 'Bianco', 30),
('TR218KJ', 'Fiat', 'Ducato', 'Furgone', 'Bianco', 40),
('TR345OP', 'Toyota', 'Auris', 'Berlina', 'Bianco', 36),
('TR672NG', 'Toyota', 'Aygo', 'Utilitaria', 'Grigio', 25),
('TR812OP', 'Opel', 'Astra', 'Berlina', 'Bianco', 20),
('TT997FK', 'Abarth', '124 Spider', 'Cabrio', 'Grigio', 80),
('WS125NJ', 'Toyota', 'Land Cruiser', 'Fuoristrada', 'Grigio', 70),
('YF231IJ', 'BMW', 'X3', 'Fuoristrada', 'Grigio', 60),
('YH723BC', 'Nissan', 'Micra', 'Utilitaria', 'Verde', 20),
('YR543IO', 'Fiat', 'Multipla', 'Monovolume', 'Marrone', 25),
('YT345OP', 'Fiat', 'Punto', 'Utilitaria', 'Blu', 25);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`Email`);

--
-- Indici per le tabelle `utente_veicolo`
--
ALTER TABLE `utente_veicolo`
  ADD PRIMARY KEY (`ID_Rent`),
  ADD KEY `Fk_Utente_Veicolo_Utente` (`Email`),
  ADD KEY `Fk_Utente_Veicolo_Veicolo` (`Targa`);

--
-- Indici per le tabelle `veicolo`
--
ALTER TABLE `veicolo`
  ADD PRIMARY KEY (`Targa`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `utente_veicolo`
--
ALTER TABLE `utente_veicolo`
  MODIFY `ID_Rent` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `utente_veicolo`
--
ALTER TABLE `utente_veicolo`
  ADD CONSTRAINT `Fk_Utente_Veicolo_Utente` FOREIGN KEY (`Email`) REFERENCES `utente` (`Email`),
  ADD CONSTRAINT `Fk_Utente_Veicolo_Veicolo` FOREIGN KEY (`Targa`) REFERENCES `veicolo` (`Targa`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
