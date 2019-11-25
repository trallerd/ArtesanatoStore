
INSERT INTO `Categoria`(`nome`) VALUES ("Feltro");
INSERT INTO `Categoria`(`nome`) VALUES ("E.V.A");
INSERT INTO `Categoria`(`nome`) VALUES ("Bonecos");
INSERT INTO `Categoria`(`nome`) VALUES ("Abajur");
INSERT INTO `Categoria`(`nome`) VALUES ("Bolo Fake");
INSERT INTO `Categoria`(`nome`) VALUES ("Canetas");

INSERT INTO `Usuario`( `nome`, `email`, `senha`, `AdmStatus`) VALUES ("João","joao@gmail.com","3256",false);
INSERT INTO `Usuario`( `nome`, `email`, `senha`, `AdmStatus`) VALUES ("Maria","maria@gmail.com","0101",false);
INSERT INTO `Usuario`( `nome`, `email`, `senha`, `AdmStatus`) VALUES ("Laura","laura@gmail.com","1458",false);
INSERT INTO `Usuario`( `nome`, `email`, `senha`, `AdmStatus`) VALUES ("Leticia","leticia@gmail.com","7452",false);
INSERT INTO `Usuario`( `nome`, `email`, `senha`, `AdmStatus`) VALUES ("Mauricio","mauricio@gmail.com","85246",false);
INSERT INTO `Usuario`( `nome`, `email`, `senha`, `AdmStatus`) VALUES ("Joanina","joanina@gmail.com","2727",false);
INSERT INTO `Usuario`( `nome`, `email`, `senha`, `AdmStatus`) VALUES ("Jéssica","jessicacristec@gmail.com","232300",true);
INSERT INTO `Usuario`( `nome`, `email`, `senha`, `AdmStatus`) VALUES ("Adriana","adriana@gmail.com","010203",true);

INSERT INTO `Endereco`( `estado`, `cidade`, `bairro`, `rua`, `numero`, `usuario`) VALUES ("Paraná","Paranaguá","Palmital","Rua das Ortiqueiras",15,5);
INSERT INTO `Endereco`( `estado`, `cidade`, `bairro`, `rua`, `numero`, `usuario`) VALUES ("Paraná","Paranaguá","Palmital","Rua das Ortiqueiras",5478,2);
INSERT INTO `Endereco`( `estado`, `cidade`, `bairro`, `rua`, `numero`, `usuario`) VALUES ("Paraná","Maringá","Jardim Acema","Rua VII", 159,6);
INSERT INTO `Endereco`( `estado`, `cidade`, `bairro`, `rua`, `numero`, `usuario`) VALUES ("Paraná","Paranaguá","Raia","Rua Des. Lauro Lopes", 9652,1);
INSERT INTO `Endereco`( `estado`, `cidade`, `bairro`, `rua`, `numero`, `usuario`) VALUES ("Paraná","Cascavel","Marília","Rua das Arvores", 321,4);
INSERT INTO `Endereco`( `estado`, `cidade`, `bairro`, `rua`, `numero`, `usuario`) VALUES ("Paraná","Paranaguá","Porto Seguro","Av. Antonio Carlos Rodrigues", 185,3);

INSERT INTO `Produto`( `nome`, `valor`, `descricao`, `tamanho`, `categoria`) VALUES ("Boneco de Feltro",32.50,"Boneco em temas(pesonagens em geral), feitos em feltro","25cm",1);
INSERT INTO `Produto`( `nome`, `valor`, `descricao`, `tamanho`, `categoria`) VALUES ("Decoração em E.V.A",150.00,"Bonecos, enfeites, tudo para sua festa ficar ainda mais bonita","",2);
INSERT INTO `Produto`( `nome`, `valor`, `descricao`, `tamanho`, `categoria`) VALUES ("Bonco Personagens",50.00,"Bonecos dos seus Personagens Preferidos feitos em E.V.A ou Feltro ","30cm",3);
INSERT INTO `Produto`( `nome`, `valor`, `descricao`, `tamanho`, `categoria`) VALUES ("Abajur",80.00," Abajur decorado para o quarto do(a) seu(a) filho(a) ficar mais bonito","50cm",4);
INSERT INTO `Produto`( `nome`, `valor`, `descricao`, `tamanho`, `categoria`) VALUES ("Bolo Fake ",250.00," Para sua festa ficar ainda mais bonita, Locação de bolo Fake","70cm",5);
INSERT INTO `Produto`( `nome`, `valor`, `descricao`, `tamanho`, `categoria`) VALUES ("Canetas Decoradas ",3.50,"Para os seus estudos ficarem mais divertido, canetas nos mais diversos temas","11cm",6);

INSERT INTO `Venda`(`desconto`, `valorTotal`, `quantidade`, `data`, `usuario`) VALUES (0, 32.50, 1, '2019-10-21', 6);
INSERT INTO `Venda`(`desconto`, `valorTotal`, `quantidade`, `data`, `usuario`) VALUES (2.00, 63.00, 2, '2019-10-21', 4);
INSERT INTO `Venda`(`desconto`, `valorTotal`, `quantidade`, `data`, `usuario`) VALUES (0.00, 80.00, 1, '2019-10-15', 1);
INSERT INTO `Venda`(`desconto`, `valorTotal`, `quantidade`, `data`, `usuario`) VALUES (0.00, 52.50, 15, '2019-10-18', 3);
INSERT INTO `Venda`(`desconto`, `valorTotal`, `quantidade`, `data`, `usuario`) VALUES (0.00, 50.00, 1, '2019-11-08', 2);
INSERT INTO `Venda`(`desconto`, `valorTotal`, `quantidade`, `data`, `usuario`) VALUES (0.00, 50.00, 1, '2019-11-10', 5);

INSERT INTO `Locacao`(`dataLocacao`, `dateEntrega`, `valor`, `produto`, `usuario`) VALUES ('2019-10-08', '2019-10-09', 250.00, 5, 3);
INSERT INTO `Locacao`(`dataLocacao`, `dateEntrega`, `valor`, `produto`, `usuario`) VALUES ('2019-10-11', '2019-10-11', 250.00, 5, 1);
INSERT INTO `Locacao`(`dataLocacao`, `dateEntrega`, `valor`, `produto`, `usuario`) VALUES ('2019-11-16', '2019-11-17', 250.00, 5, 6);

INSERT INTO `Venda_has_Produto`(`venda`, `produto`, `categoria`) VALUES (1,1,1);
INSERT INTO `Venda_has_Produto`(`venda`, `produto`, `categoria`) VALUES (2,1,1);
INSERT INTO `Venda_has_Produto`(`venda`, `produto`, `categoria`) VALUES (3,4,4);
INSERT INTO `Venda_has_Produto`(`venda`, `produto`, `categoria`) VALUES (4,6,6);
INSERT INTO `Venda_has_Produto`(`venda`, `produto`, `categoria`) VALUES (5,3,3);
INSERT INTO `Venda_has_Produto`(`venda`, `produto`, `categoria`) VALUES (6,3,3);






