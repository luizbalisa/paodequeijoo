-- MySQL dump 10.13  Distrib 5.1.47, for Win32 (ia32)
--
-- Host: localhost    Database: paodequeijodb
-- ------------------------------------------------------
-- Server version	5.5.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `endereco` varchar(256) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `telefone1` varchar(45) DEFAULT NULL,
  `telefone2` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `local_trabalho` varchar(150) DEFAULT NULL,
  `telefone_comercial` varchar(45) DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pagamento`
--

DROP TABLE IF EXISTS `forma_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_pagamento` (
  `idforma_pagamento` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  `vista_prazo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idforma_pagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pagamento`
--

LOCK TABLES `forma_pagamento` WRITE;
/*!40000 ALTER TABLE `forma_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `forma_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_saida_produto`
--

DROP TABLE IF EXISTS `historico_saida_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_saida_produto` (
  `idhistorico_saida_produto` int(11) NOT NULL AUTO_INCREMENT,
  `idProduto` int(11) NOT NULL,
  `data` varchar(45) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`idhistorico_saida_produto`,`idProduto`,`data`),
  KEY `fk_saida_1` (`idProduto`),
  CONSTRAINT `fk_saida_1` FOREIGN KEY (`idProduto`) REFERENCES `produto_venda` (`codigo_produto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_saida_produto`
--

LOCK TABLES `historico_saida_produto` WRITE;
/*!40000 ALTER TABLE `historico_saida_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_saida_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_produto_venda`
--

DROP TABLE IF EXISTS `lista_produto_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_produto_venda` (
  `idlista_produto_venda` int(11) NOT NULL AUTO_INCREMENT,
  `idVenda` int(11) DEFAULT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idlista_produto_venda`),
  KEY `fk_produto_1` (`idVenda`),
  KEY `fk_produto_2` (`idProduto`),
  CONSTRAINT `fk_produto_1` FOREIGN KEY (`idVenda`) REFERENCES `venda_prazo` (`idvenda_prazo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_produto_2` FOREIGN KEY (`idProduto`) REFERENCES `produto_venda` (`codigo_produto`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_produto_venda`
--

LOCK TABLES `lista_produto_venda` WRITE;
/*!40000 ALTER TABLE `lista_produto_venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_produto_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimento_caixa`
--

DROP TABLE IF EXISTS `movimento_caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimento_caixa` (
  `idmovimento_caixa` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(45) NOT NULL,
  `forma_pagamento` int(11) NOT NULL,
  `valor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmovimento_caixa`,`data`,`forma_pagamento`),
  KEY `fk_movimento_1` (`forma_pagamento`),
  CONSTRAINT `fk_movimento_1` FOREIGN KEY (`forma_pagamento`) REFERENCES `forma_pagamento` (`idforma_pagamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimento_caixa`
--

LOCK TABLES `movimento_caixa` WRITE;
/*!40000 ALTER TABLE `movimento_caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimento_caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_venda`
--

DROP TABLE IF EXISTS `produto_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto_venda` (
  `codigo_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `preco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_venda`
--

LOCK TABLES `produto_venda` WRITE;
/*!40000 ALTER TABLE `produto_venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda_prazo`
--

DROP TABLE IF EXISTS `venda_prazo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda_prazo` (
  `idvenda_prazo` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  `forma_pagamento` int(11) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idvenda_prazo`),
  KEY `fk_venda_1` (`idCliente`),
  KEY `fk_venda_2` (`forma_pagamento`),
  CONSTRAINT `fk_venda_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_venda_2` FOREIGN KEY (`forma_pagamento`) REFERENCES `forma_pagamento` (`idforma_pagamento`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda_prazo`
--

LOCK TABLES `venda_prazo` WRITE;
/*!40000 ALTER TABLE `venda_prazo` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda_prazo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-08-02 15:47:36
