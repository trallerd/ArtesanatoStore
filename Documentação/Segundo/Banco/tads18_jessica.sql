-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 30-Nov-2019 às 10:54
-- Versão do servidor: 5.5.62-0+deb8u1
-- PHP Version: 5.6.40-0+deb8u7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tads18_jessica`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`tads18_jessica`@`%` PROCEDURE `CidadeFilter`(city varchar(45))
begin 
select * from Endereco where cidade = city; 
end$$

CREATE DEFINER=`tads18_jessica`@`%` PROCEDURE `dataLocacao`(dt int)
begin 
select * from Locacao where month(dataLocacao) = dt; 
end$$

CREATE DEFINER=`tads18_jessica`@`%` PROCEDURE `dataVenda`(IN `dt` INT)
begin 
select * from Venda where day(data) = dt; 
end$$

CREATE DEFINER=`tads18_jessica`@`%` PROCEDURE `estadoFilter`(stds varchar(45))
begin 
select * from Endereco where estado = stds; 
end$$

CREATE DEFINER=`tads18_jessica`@`%` PROCEDURE `NomeUser`(no VarChar(45))
begin 
select * from Usuario where nome like CONCAT("%",no,"%"); 
end$$

--
-- Functions
--
CREATE DEFINER=`tads18_jessica`@`%` FUNCTION `precoUni`(id int) RETURNS float
    DETERMINISTIC
BEGIN
DECLARE n1,n2 float;
DECLARE precoUni FLOAT;
SELECT quantidade,valorTotal INTO n1,n2 FROM Venda  WHERE idVenda = id;
SET precoUni = n2/n1;
RETURN precoUni;
END$$

CREATE DEFINER=`tads18_jessica`@`%` FUNCTION `VerPreco`(a INT) RETURNS varchar(60) CHARSET latin1
RETURN
(SELECT CONCAT('O preço do Produto ', nome, ' é ', valor)
FROM Produto
WHERE idProduto = a)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Categoria`
--

CREATE TABLE IF NOT EXISTS `Categoria` (
`idCategoria` int(11) NOT NULL COMMENT '	',
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Categoria`
--

INSERT INTO `Categoria` (`idCategoria`, `nome`) VALUES
(1, 'Feltro'),
(2, 'E.V.A'),
(3, 'Bonecos'),
(4, 'Abajur'),
(5, 'Bolo Fake'),
(6, 'Canetas'),
(7, 'teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `Endereco`
--

CREATE TABLE IF NOT EXISTS `Endereco` (
`idEndereco` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(200) NOT NULL,
  `numero` int(11) NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Endereco`
--

INSERT INTO `Endereco` (`idEndereco`, `estado`, `cidade`, `bairro`, `rua`, `numero`, `usuario`) VALUES
(1, 'Paraná', 'Paranaguá', 'Palmital', 'Rua das Ortiqueiras', 15, 5),
(2, 'Paraná', 'Paranaguá', 'Palmital', 'Rua das Ortiqueiras', 5478, 2),
(3, 'Paraná', 'Maringá', 'Jardim Acema', 'Rua VII', 159, 6),
(4, 'Paraná', 'Paranaguá', 'Raia', 'Rua Des. Lauro Lopes', 9652, 1),
(5, 'Paraná', 'Cascavel', 'Marília', 'Rua das Arvores', 321, 4),
(6, 'Paraná', 'Paranaguá', 'Porto Seguro', 'Av. Antonio Carlos Rodrigues', 185, 3);

--
-- Acionadores `Endereco`
--
DELIMITER //
CREATE TRIGGER `controleUser` BEFORE INSERT ON `Endereco`
 FOR EACH ROW begin
if  (new.bairro=''|| new.cidade=''||new.estado=''||new.rua='') then
SELECT 0 FROM `FAVOR PREENCHER TODOS OS CAMPOS` INTO@error;
end if;
end
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `imagens`
--

CREATE TABLE IF NOT EXISTS `imagens` (
`id` int(11) NOT NULL,
  `nomeArquivo` char(255) NOT NULL,
  `imagem` blob NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `imagens`
--

INSERT INTO `imagens` (`id`, `nomeArquivo`, `imagem`) VALUES
(1, 'imgs/abajur.jpg.jpg', 0xffd8ffe000104a46494600010200000100010000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc0001108004b006403012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00e85752b08d59e2963909ff009e67713edc533cebabd037130c67f857a9fc698914498223507d801565700e7038f714210f8208a1185500e3ae39ae0bc5bf11750d0b5e9f4db2b1b69042141926cb64950dd88c75c7e15dc5fdf45a769b717b37fab8232e467ae07007d7a57ceb7d7b25f6a135d4ec5a4918b331ee4d326fad8ed17e2af889db3f64d3947a08dbff008aff0039a997e2a7884726cf4f39edb1f8ff00c7eb83898e315697046290cfa1b42d4bfb6346b7bc28ab2489f3a83900f7c7b55f2a0024023f0af39f859ac86fb56932b1cffad8b9f4e08fe46bd273f5cfb1cd099316dad772bc801ec3155241c1e94cbbd5ad209a5898c924918e56385d88f6c818cfe3552c356b5d5a291adb702870cac3046738fe4695d365d9ad491f8edcd5590e3ae055b71c738aa920e693408acc464f19fa514921f9ba668a9b1573551b81e86a753e87f4aa70b640f5fa55a5e707a56c91071bf1375516da0a58a4989ae5c1641fdc1cff00e858fcabc787deaea7c7baca6a7e269d515916d49b61b8724ab1c9fcc9fc315cba9503a8cd212268fad5a4aab1b203f7854eb3463f881cfa5228d6d17529748d5a0bd85ca143c91e95ecfaceb91db6829796e4e6e4aac78c6e048271d7ae011f5af0659778daa8e4f5e0575f6f79ae5ce810e9b71a55ca5b452ab5b49e4b0fde648dbd39ce5bdf3513ba4ec2847f797ee76da5df23b00edf31ac8b7924d1fc5d24119c452cbb4a0e855b95fcb22a8e8f7ec672ac30570083d41ef5b7342baaf882d268d1c0b550d34b8e09072aa0fa83c9f6ae5a57523beaf2b81d048dd6aa4871c54ee79aab21f5aebb9c36216393452123345219a16c194023a0f4abcb82a38fa71546195001cd5b8645719c63a6726b7488b905d68da6dfc9beeac2d6672b8dd2c2ac71cf723dcd43ff00087f879810746b3e7a911007ae7b56979b186f99c03f5a8e6d634db6044d7b6ea476690668680c1d53c23a04d6ec174ab68bcbcb6634d8719c9ce3af7c7a76abb65e1cd0ec99162d2ad30bb70cd1063c74393dfdeaa5df89f487865812ec3bc8a514aab1e48f5c53756f155be977bf6316f24d3048c9c1c64b283fd6a195d4ec628e38902471a2a28000518000ed8acdf10e9c353d226b733883037799b37ed03af19f4cd734fe3cb8b5711cfa4b44eb8cac921071f8afa53fc41e31b66f0cc93d94c9e7ca56358d8fcca4f2723ae3008cf4a960df2abb307c111e98619357d56d5ae0b5eac41991a52b1e318da339c71db3c577a121f293ecca442061018ca71dbe52011f422bcc7c31aefd9ada0d1520c34f308c5c039daccd80db71ce323bf6af5411b45022b4ad31031e638196f7380054b92e6b041a9479a25395481d6a84a6afce7a8359933734d8c631e68a858e4f345203897f176a72ae14c718ff00654ff5355bfb7351624b5f4e3fdd908fe55881e9e1eb4e61591a12de4933169647727bb31269867f7aa45fde8f333de95c65db7743751096431c45c6f70325467938ef5dd6a3e228742d66cee9b4cb7ba335a47224b9c3b0da1410707046d3f81ae01216c65c11ec2ba0d4f5a26db498a364916dad5410ca1b6b648239e9c05a955628e795787722d73583af6a8d7705a491e2301973b88c13cf158175293c6735dbf837c49a45c432c37d35b59cdbd891c46a7d0fa7f5e2b1f45d0f43d434ebcbbbfd6a0b478773c7099554b6115ba1e4f248fc2a9eba8eaa728d918ba548d15da3862b246c19581e841eb5eb115f6a163a769f717302cd613b456fe72b9df131180581e082475c8ebdebc8ed668d262ce09c8c00013cfe15dd5a5cf89f58f0c9d2a23ba3655648ed6c26cb9460ca19e40aa002a0e47a77a4a376674a3284e5d8ec663f7b3f8565cc403c5374ed59354d2a1b90cbe61502551fc2fdc63b73d33db1514cf499d488d9ceee00a2a06939a290cf2a56a7efa801e94e1d6a809b7f34864d8371edcd459a1f9520f4c50f5426aeac695bde79a029233eb57634f331cf1ed5c724f2c2ff00bb7231dbad4ed7f76c306e2403d14e3f9573ba2fb9e7d4c24afeeb3a0bfb5b65648e38d0ddbf20e48da073ce3d7a0fad63a8ba21e56b70aa87956c8270327f2c7ea2b38cb24720647652086041c608ef4b1c92313ba4739eb963cd74414631b3dceea14e34e9a8bbb66e47bc9565201c17e78db8cf5fcaba7d3be226a9a669122c1046646252194364237009db8e4e390338e33ec78d92593c83fbc6e460f3d475a8edd99e3756662304e09f51cff21f9534e26dee58d9d3af2eec6e84d05c2a49b954ef6e1f3ebea3debaab4f13a5ddbbbc91797322e76e721be9fa9c761eb5e7e92c9e52fcedd3b9f4ff00f50a7876e06e3dff005eb45e3d83ddd343d1ac7548b5180cd0eec06dac186083d71fa8a2b17c3b23c9a7397393e6b73dcf00f27bf5a2a5dae43b5f447fffd9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Locacao`
--

CREATE TABLE IF NOT EXISTS `Locacao` (
`idLocacao` int(11) NOT NULL,
  `dataLocacao` varchar(45) NOT NULL,
  `dateEntrega` varchar(45) NOT NULL,
  `produto` int(11) NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Locacao`
--

INSERT INTO `Locacao` (`idLocacao`, `dataLocacao`, `dateEntrega`, `produto`, `usuario`) VALUES
(1, '2019-10-08', '2019-10-09', 5, 3),
(2, '2019-10-11', '2019-10-11', 5, 1),
(3, '2019-11-16', '2019-11-17', 5, 6),
(4, '30/11/2019', '30/11/2019', 5, 10),
(5, '01/12/2019', '02/12/2019', 5, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Produto`
--

CREATE TABLE IF NOT EXISTS `Produto` (
`idProduto` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `tamanho` varchar(45) NOT NULL,
  `categoria` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Produto`
--

INSERT INTO `Produto` (`idProduto`, `nome`, `valor`, `descricao`, `tamanho`, `categoria`) VALUES
(1, 'Boneco de Feltro', 33.15, 'Boneco em temas(pesonagens em geral), feitos em feltro', '25cm', 1),
(2, 'Decoração em E.V.A', 153, 'Bonecos, enfeites, tudo para sua festa ficar ainda mais bonita', '', 2),
(3, 'Bonco Personagens', 51, 'Bonecos dos seus Personagens Preferidos feitos em E.V.A ou Feltro ', '30cm', 3),
(4, 'Abajur', 81.6, ' Abajur decorado para o quarto do(a) seu(a) filho(a) ficar mais bonito', '50cm', 4),
(5, 'Bolo Fake ', 255, ' Para sua festa ficar ainda mais bonita, Locação de bolo Fake', '70cm', 5),
(6, 'Canetas Decoradas ', 3.57, 'Para os seus estudos ficarem mais divertido, canetas nos mais diversos temas', '11cm', 6);

-- --------------------------------------------------------

--
-- Stand-in structure for view `tabelaProdutos`
--
CREATE TABLE IF NOT EXISTS `tabelaProdutos` (
`Código` int(11)
,`Produto` varchar(45)
,`Valor` double
,`Tamanho` varchar(45)
,`Descrição` varchar(200)
,`Categoria` int(11)
);
-- --------------------------------------------------------

--
-- Estrutura da tabela `Usuario`
--

CREATE TABLE IF NOT EXISTS `Usuario` (
`idUsuario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `AdmStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Usuario`
--

INSERT INTO `Usuario` (`idUsuario`, `nome`, `email`, `senha`, `AdmStatus`) VALUES
(1, 'João', 'joao@gmail.com', '3256', 0),
(2, 'Maria', 'maria@gmail.com', '0101', 0),
(3, 'Laura', 'laura@gmail.com', '1458', 0),
(4, 'Leticia', 'leticia@gmail.com', '7452', 0),
(5, 'Mauricio', 'mauricio@gmail.com', '85246', 0),
(6, 'Joanina', 'joanina@gmail.com', '2727', 0),
(7, 'Jéssica', 'jessicacristec@gmail.com', '232300', 1),
(8, 'Adriana', 'adriana@gmail.com', '010203', 1),
(9, 'Julia', 'julia@gmail.com', '2020', 0),
(10, 'Felipe', 'felipe@gmail.com', '1014', 0),
(11, 'Patricia', 'paty@gmail.com', '2103', 0);

--
-- Acionadores `Usuario`
--
DELIMITER //
CREATE TRIGGER `emailsArroba` BEFORE INSERT ON `Usuario`
 FOR EACH ROW begin
declare ret int;
SELECT INSTR(new.email,'@') into ret;
if (ret = 0) then
SELECT 0 FROM `EMAIL NAO POSSUI ARROBA` INTO @error;
end if;
end
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Venda`
--

CREATE TABLE IF NOT EXISTS `Venda` (
`idVenda` int(11) NOT NULL,
  `desconto` double NOT NULL,
  `valorTotal` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  `data` date NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Venda`
--

INSERT INTO `Venda` (`idVenda`, `desconto`, `valorTotal`, `quantidade`, `data`, `usuario`) VALUES
(1, 0, 32.5, 1, '2019-10-21', 6),
(2, 2, 63, 2, '2019-10-21', 4),
(3, 0, 80, 1, '2019-10-15', 1),
(4, 0, 52.5, 15, '2019-10-18', 3),
(5, 0, 50, 1, '2019-11-08', 2),
(6, 0, 50, 1, '2019-11-10', 5),
(7, 0, 33.15, 1, '2019-11-28', 1),
(8, 0, 51, 1, '2019-11-28', 1),
(9, 0, 3.57, 1, '2019-11-28', 1),
(10, 0, 33.15, 1, '2019-11-28', 2),
(11, 0, 33.15, 1, '2019-11-28', 1),
(12, 0, 153, 1, '2019-11-29', 1),
(13, 0, 3.57, 1, '2019-11-30', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Venda_has_Produto`
--

CREATE TABLE IF NOT EXISTS `Venda_has_Produto` (
  `venda` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Venda_has_Produto`
--

INSERT INTO `Venda_has_Produto` (`venda`, `produto`, `categoria`) VALUES
(1, 1, 1),
(2, 1, 1),
(3, 4, 4),
(4, 6, 6),
(5, 3, 3),
(6, 3, 3);

-- --------------------------------------------------------

--
-- Structure for view `tabelaProdutos`
--
DROP TABLE IF EXISTS `tabelaProdutos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`tads18_jessica`@`%` SQL SECURITY DEFINER VIEW `tabelaProdutos` AS select `Produto`.`idProduto` AS `Código`,`Produto`.`nome` AS `Produto`,`Produto`.`valor` AS `Valor`,`Produto`.`tamanho` AS `Tamanho`,`Produto`.`descricao` AS `Descrição`,`Produto`.`categoria` AS `Categoria` from `Produto`;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Categoria`
--
ALTER TABLE `Categoria`
 ADD PRIMARY KEY (`idCategoria`);

--
-- Indexes for table `Endereco`
--
ALTER TABLE `Endereco`
 ADD PRIMARY KEY (`idEndereco`,`usuario`), ADD KEY `fk_Endereco_Usuario1_idx` (`usuario`);

--
-- Indexes for table `imagens`
--
ALTER TABLE `imagens`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Locacao`
--
ALTER TABLE `Locacao`
 ADD PRIMARY KEY (`idLocacao`,`produto`,`usuario`), ADD KEY `fk_Locacao_Produto1_idx` (`produto`), ADD KEY `fk_Locacao_Usuario1_idx` (`usuario`);

--
-- Indexes for table `Produto`
--
ALTER TABLE `Produto`
 ADD PRIMARY KEY (`idProduto`,`categoria`), ADD KEY `fk_Produto_Categoria1_idx` (`categoria`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
 ADD PRIMARY KEY (`idUsuario`);

--
-- Indexes for table `Venda`
--
ALTER TABLE `Venda`
 ADD PRIMARY KEY (`idVenda`), ADD KEY `fk_Venda_Usuario1_idx` (`usuario`);

--
-- Indexes for table `Venda_has_Produto`
--
ALTER TABLE `Venda_has_Produto`
 ADD PRIMARY KEY (`venda`,`produto`,`categoria`), ADD KEY `fk_Venda_has_Produto_Produto1_idx` (`produto`,`categoria`), ADD KEY `fk_Venda_has_Produto_Venda1_idx` (`venda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Categoria`
--
ALTER TABLE `Categoria`
MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `Endereco`
--
ALTER TABLE `Endereco`
MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `imagens`
--
ALTER TABLE `imagens`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Locacao`
--
ALTER TABLE `Locacao`
MODIFY `idLocacao` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `Produto`
--
ALTER TABLE `Produto`
MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `Usuario`
--
ALTER TABLE `Usuario`
MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `Venda`
--
ALTER TABLE `Venda`
MODIFY `idVenda` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `Endereco`
--
ALTER TABLE `Endereco`
ADD CONSTRAINT `fk_Endereco_Usuario1` FOREIGN KEY (`usuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `Locacao`
--
ALTER TABLE `Locacao`
ADD CONSTRAINT `fk_Locacao_Produto1` FOREIGN KEY (`produto`) REFERENCES `Produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Locacao_Usuario1` FOREIGN KEY (`usuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `Produto`
--
ALTER TABLE `Produto`
ADD CONSTRAINT `fk_Produto_Categoria1` FOREIGN KEY (`categoria`) REFERENCES `Categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `Venda`
--
ALTER TABLE `Venda`
ADD CONSTRAINT `fk_Venda_Usuario1` FOREIGN KEY (`usuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `Venda_has_Produto`
--
ALTER TABLE `Venda_has_Produto`
ADD CONSTRAINT `fk_Venda_has_Produto_Produto1` FOREIGN KEY (`produto`, `categoria`) REFERENCES `Produto` (`idProduto`, `categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Venda_has_Produto_Venda1` FOREIGN KEY (`venda`) REFERENCES `Venda` (`idVenda`) ON DELETE NO ACTION ON UPDATE NO ACTION;

DELIMITER $$
--
-- Eventos
--
CREATE DEFINER=`tads18_jessica`@`%` EVENT `aumentaPreco` ON SCHEDULE EVERY 1 YEAR STARTS '2005-01-20 04:46:29' ON COMPLETION PRESERVE ENABLE DO begin
UPDATE Produto set valor = ((valor*2/100)+valor);
end$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
