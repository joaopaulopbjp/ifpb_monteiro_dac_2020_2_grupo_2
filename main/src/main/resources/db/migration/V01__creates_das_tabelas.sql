-- Create table de BD Livraria

CREATE  TABLE  AUTOR(
	AUTORID SERIAL PRIMARY KEY,
	NOME 	VARCHAR(250)NOT NULL,
	SEXO	VARCHAR(2),
	NACIONALIDADE VARCHAR(30),
	DATANASCIMENTO DATE
);

CREATE  TABLE  CATEGORIA(
	CATEGORIAID SERIAL PRIMARY KEY,
	DESCRICAO 	VARCHAR(250)NOT NULL
);

CREATE  TABLE  USUARIO(
	USERID SERIAL PRIMARY KEY,
	NOME 	VARCHAR(250)NOT NULL,
	EMAIL	VARCHAR(250)NOT NULL,
	CELULAR VARCHAR(30),
	CPF VARCHAR(11)NOT NULL,
	SEXO VARCHAR(30)NOT NULL,
	SENHA VARCHAR(250)NOT NULL,
	USER_PAPEL VARCHAR(50)NOT NULL
);

CREATE  TABLE  ENDERECO(
	ENDID SERIAL PRIMARY KEY,
	CEP 	VARCHAR(30)NOT NULL,
	RUA	VARCHAR(250),
	NUMERO INTEGER,
	BAIRRO VARCHAR(250),
	CIDADE VARCHAR(250),
	UF	   VARCHAR(2),
	COMPLEMENTO VARCHAR(250),
	PONTOREFERENCIA VARCHAR(250),
	USERID BIGINT NOT NULL REFERENCES USUARIO(USERID)
);

CREATE  TABLE  EDITORA(
	EDITORAID SERIAL PRIMARY KEY,
	CNPJ 	VARCHAR(250)NOT NULL,
	NOME	VARCHAR(2),
	CEP 	VARCHAR(30)NOT NULL,
	RUA	VARCHAR(250),
	NUMERO INTEGER,
	BAIRRO VARCHAR(250),
	CIDADE VARCHAR(250),
	UF	   VARCHAR(2)
);




CREATE  TABLE  LIVRO(
	LIVROID SERIAL PRIMARY KEY,
	TITULO 	VARCHAR(250)NOT NULL,
	DESCRICAO	VARCHAR(250)NOT NULL,
	PRICE DECIMAL NOT NULL,
	ISBN VARCHAR(30) NOT NULL,
	CAPA VARCHAR(255) NOT NULL,
	EDICAO VARCHAR(250)NOT NULL,
	ANOPUBLICACAO VARCHAR(30)NOT NULL,
	CATEGORIA BIGINT NOT NULL REFERENCES CATEGORIA(CATEGORIAID),
	EDITORAID BIGINT NOT NULL REFERENCES EDITORA(EDITORAID)
);

CREATE  TABLE  ESTOQUE(
	ESTOQUEID SERIAL PRIMARY KEY,
	LIVROID BIGINT NOT NULL REFERENCES LIVRO(LIVROID),
	QUANTIDADE INT NOT NULL,
	PRATELEIRA VARCHAR(30)
);

CREATE  TABLE  PAGAMENTO(
	PAGAMENTOID SERIAL PRIMARY KEY,
	DESCRICAO 	VARCHAR(250)NOT NULL
);

CREATE  TABLE  PEDIDO(
	PEDIDOID SERIAL PRIMARY KEY,
	USERID  BIGINT  NOT NULL REFERENCES USUARIO(USERID),
	TOTAL	DECIMAL NOT NULL,
	DATACRIACAO DATE NOT NULL,
	STATUS VARCHAR(100) NOT NULL,
	PAGAMENTO BIGINT NOT NULL REFERENCES PAGAMENTO(PAGAMENTOID),
	DATAFECHAMENTO DATE
);

CREATE  TABLE  BOOKPEDIDO(
	BOOKPEDIDOID SERIAL PRIMARY KEY,
	DATAVENDA DATE NOT NULL,
	QUANTIDADE	INTEGER NOT NULL,
	LIVROID BIGINT NOT NULL REFERENCES LIVRO(LIVROID),
	PEDIDOID BIGINT NOT NULL REFERENCES PEDIDO(PEDIDOID)
);

CREATE  TABLE  LIVROAUTOR(
	AUTORID BIGINT NOT NULL,
	LIVROID BIGINT NOT NULL,
	
        FOREIGN KEY (AUTORID) REFERENCES AUTOR(AUTORID),
        FOREIGN KEY (LIVROID) REFERENCES LIVRO(LIVROID)
);


INSERT INTO USUARIO (NOME, EMAIL, CELULAR, CPF, SEXO, SENHA, USER_PAPEL) 
VALUES ('convidado', 'convidado@email.com','99999999999', '99999999999', 'I', 'senha', 'CLIENTE'); 



