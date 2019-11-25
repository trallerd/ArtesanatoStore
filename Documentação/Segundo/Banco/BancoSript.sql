
CREATE TABLE `Categoria` (
  `idCategoria` INT NOT NULL COMMENT '	',
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))

CREATE TABLE `Usuario` (
  `idUsuario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `AdmStatus` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idUsuario`))

CREATE TABLE `Endereco` (
  `idEndereco` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(200) NOT NULL,
  `numero` INT(11) NOT NULL,
  `usuario` INT NOT NULL,
  PRIMARY KEY (`idEndereco`, `usuario`),
  INDEX `fk_Endereco_Usuario1_idx` (`usuario` ASC),
  CONSTRAINT `fk_Endereco_Usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

CREATE TABLE `Produto` (
  `idProduto` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `tamanho` VARCHAR(45) NOT NULL,
  `categoria` INT NOT NULL,
  PRIMARY KEY (`idProduto`, `categoria`),
  INDEX `fk_Produto_Categoria1_idx` (`categoria` ASC),
  CONSTRAINT `fk_Produto_Categoria1`
    FOREIGN KEY (`categoria`)
    REFERENCES `Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

CREATE TABLE `Venda` (
  `idVenda` INT NOT NULL,
  `desconto` DOUBLE NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  `quantidade` INT(11) NOT NULL,
  `data` DATE NOT NULL,
  `usuario` INT NOT NULL,
  PRIMARY KEY (`idVenda`),
  INDEX `fk_Venda_Usuario1_idx` (`usuario` ASC),
  CONSTRAINT `fk_Venda_Usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

CREATE TABLE `Locacao` (
  `idLocacao` INT NOT NULL,
  `dataLocacao` DATE NOT NULL,
  `dateEntrega` DATE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `produto` INT NOT NULL,
  `usuario` INT NOT NULL,
  PRIMARY KEY (`idLocacao`, `produto`, `usuario`),
  INDEX `fk_Locacao_Produto1_idx` (`produto` ASC),
  INDEX `fk_Locacao_Usuario1_idx` (`usuario` ASC),
  CONSTRAINT `fk_Locacao_Produto1`
    FOREIGN KEY (`produto`)
    REFERENCES `Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

CREATE TABLE `Venda_has_Produto` (
  `venda` INT NOT NULL,
  `produto` INT NOT NULL,
  `categoria` INT NOT NULL,
  PRIMARY KEY (`venda`, `produto`, `categoria`),
  INDEX `fk_Venda_has_Produto_Produto1_idx` (`produto` ASC, `categoria` ASC),
  INDEX `fk_Venda_has_Produto_Venda1_idx` (`venda` ASC),
  CONSTRAINT `fk_Venda_has_Produto_Venda1`
    FOREIGN KEY (`venda`)
    REFERENCES `Venda` (`idVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_has_Produto_Produto1`
    FOREIGN KEY (`produto` , `categoria`)
    REFERENCES `Produto` (`idProduto` , `categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
