# 4Task - Gerenciador de tarefas


## Códigos para criação do banco de dados

## Table usuarios
```sql
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(250) NOT NULL,
  `senhaUsuario` varchar(250) NOT NULL,
  `emailUsuario` varchar(250) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
```
## Tabela tarefas
```sql
CREATE TABLE `tarefas` (
  `idTarefa` int(11) NOT NULL AUTO_INCREMENT,
  `nomeTarefa` varchar(300) NOT NULL,
  `descTarefa` varchar(1000) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idTarefa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
```
