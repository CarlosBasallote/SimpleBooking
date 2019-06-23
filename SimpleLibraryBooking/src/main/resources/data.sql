INSERT INTO USUARIO (IDUSUARIO, EMAIL, CONTRASENIA, ENABLED)
 VALUES 
	(9000, 'admin',
	 '$2a$04$Z6/jSCrlZLUKsYLcg4Ff3OhPloKw9CmLrpWeN6k.BUzD.9rD.WsY2',
	 TRUE);

INSERT INTO USUARIO (IDUSUARIO, EMAIL, CONTRASENIA, ENABLED)
 VALUES 
	(9001, 'usuario',
	 '$2a$10$vGnjYpQcKjkt3KTbgRsCiuWtviTmD6F3idHkrbdv/sALbWY4VMQoK',
	 TRUE);

INSERT INTO USUARIO (IDUSUARIO, EMAIL, CONTRASENIA, ENABLED)
 VALUES 
	(1, 'jose',
	 '$2a$04$sKPiNr8gpXFXgWONP1tZpOR3QLtlTUSjmr0EqBtyGZpn.KHkqp0rK',
	 FALSE);

INSERT INTO USUARIO (IDUSUARIO, EMAIL, CONTRASENIA, ENABLED)
 VALUES 
	(2, 'carlos',
	 '$2a$04$sKPiNr8gpXFXgWONP1tZpOR3QLtlTUSjmr0EqBtyGZpn.KHkqp0rK',
	 FALSE);

INSERT INTO USUARIO (IDUSUARIO, EMAIL, CONTRASENIA, ENABLED)
 VALUES 
	(3, 'juan',
	 '$2a$04$sKPiNr8gpXFXgWONP1tZpOR3QLtlTUSjmr0EqBtyGZpn.KHkqp0rK',
	 FALSE);

INSERT INTO USUARIO (IDUSUARIO, EMAIL, CONTRASENIA, ENABLED)
 VALUES 
	(4, 'luismi',
	 '$2a$04$sKPiNr8gpXFXgWONP1tZpOR3QLtlTUSjmr0EqBtyGZpn.KHkqp0rK',
	 FALSE);

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
VALUES
	(9000, 'ROLE_ADMIN');

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
VALUES
	(9001, 'ROLE_USER');

INSERT INTO SALA 
VALUES 
	(1, 20, 'Aula 07');

INSERT INTO SALA 
VALUES 
	(2, 20, 'Aula 08');

INSERT INTO SALA 
VALUES 
	(3, 20, 'Aula 09');

INSERT INTO SALA 
VALUES 
	(4, 20, 'Aula 10');