CREATE TABLE IF NOT EXISTS `Categoria` (
`idCategoria` int(11) NOT NULL COMMENT '	',
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE `Usuario` (
  `idUsuario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `AdmStatus` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idUsuario`))


CREATE TABLE IF NOT EXISTS `Endereco` (
`idEndereco` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(200) NOT NULL,
  `numero` int(11) NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `imagens` (
`id` int(11) NOT NULL,
  `nomeArquivo` char(255) NOT NULL,
  `imagem` blob NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Locacao` (
`idLocacao` int(11) NOT NULL,
  `dataLocacao` varchar(45) NOT NULL,
  `dateEntrega` varchar(45) NOT NULL,
  `produto` int(11) NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Usuario` (
`idUsuario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `AdmStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Venda` (
`idVenda` int(11) NOT NULL,
  `desconto` double NOT NULL,
  `valorTotal` double NOT NULL,
  `quantidade` int(11) NOT NULL,
  `data` date NOT NULL,
  `usuario` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Venda_has_Produto` (
  `venda` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;