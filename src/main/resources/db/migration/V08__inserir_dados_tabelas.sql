/**
 * Author:  Miguel Castro
 */

insert into fisico (id, altura, peso, tipo_sanguineo) values (1, 1.57, 70, 'A_POSITIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (2, 1.65, 90.5, 'B_POSITIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (3, 1.70, 85.5, 'A_NEGATIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (4, 1.70, 60, 'B_NEGATIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (5, 1.76, 78.8, 'A_B_POSITIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (6, 1.59, 65, 'A_B_NEGATIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (7, 1.69, 69, 'O_POSITIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (8, 1.78, 75, 'O_NEGATIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (9, 1.73, 87, 'A_POSITIVO');
insert into fisico (id, altura, peso, tipo_sanguineo) values (10, 1.80, 130, 'A_POSITIVO');

insert into contato (id, email, numero, tipo_contato) values (1, 'zkilius0@printfriendly.com', '(137) 1316444', 'Celular');
insert into contato (id, email, numero, tipo_contato) values (2, 'dsavaage1@desdev.cn', '(324) 2826938', 'Telefone fixo');
insert into contato (id, email, numero, tipo_contato) values (3, 'ctimmons2@issuu.com', '(823) 8008533', 'Celular');
insert into contato (id, email, numero, tipo_contato) values (4, 'dbullant3@ow.ly', '(668) 8008754', 'Telefone fixo');
insert into contato (id, email, numero, tipo_contato) values (5, 'rciric4@newsvine.com', '(419) 4995933', 'Celular');
insert into contato (id, email, numero, tipo_contato) values (6, 'tiliff5@ameblo.jp', '(654) 5377937', 'Telefone fixo');
insert into contato (id, email, numero, tipo_contato) values (7, 'ctwigger6@over-blog.com', '(572) 7019352', 'Telefone fixo');
insert into contato (id, email, numero, tipo_contato) values (8, 'fknoton7@multiply.com', '(607) 9111314', 'Celular');
insert into contato (id, email, numero, tipo_contato) values (9, 'xdonati8@geocities.com', '(199) 9908338', 'Telefone fixo');
insert into contato (id, email, numero, tipo_contato) values (10, 'hcampe9@hc360.com', '(542) 6520986', 'Celular');

insert into endereco (id, bairro, cidade, complemento, numero, rua) values (1, '53 Shopko Way', 'Camp Diable', 'Room 483', 104, '5176 Continental Road');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (2, '0913 Stephen Circle', 'Tangjian', 'Suite 21', 143, '0 Mosinee Pass');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (3, '285 Pine View Terrace', 'Midrand', '9th Floor', 181, '10 Barby Junction');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (4, '8 Bartelt Court', 'Camajuaní', '20th Floor', 143, '1999 Cambridge Crossing');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (5, '2940 Westport Alley', 'Lianghekou', 'Room 1340', 169, '7012 Onsgard Trail');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (6, '342 Mendota Circle', 'Österbybruk', 'Room 1795', 185, '85 1st Parkway');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (7, '505 Schurz Park', 'Ibarra', 'Apt 1675', 165, '26714 Vernon Street');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (8, '60477 Ridge Oak Alley', 'Klemunan', 'Apt 1798', 123, '91668 School Trail');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (9, '833 Sunfield Alley', 'Yangong', 'Suite 86', 124, '2 Esker Trail');
insert into endereco (id, bairro, cidade, complemento, numero, rua) values (10, '23360 Hayes Parkway', 'Aqtoghay', 'Apt 740', 135, '4 Atwood Point');

insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (1, '595.930.300-00', '1983-07-05', 1, 'Rosalinda Warder');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (2, '059.496.230-70', '1991-06-28', 2, 'Rhodia Jacobsson');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (3, '158.168.250-62', '1996-09-29', 3, 'Riccardo Gecke');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (4, '410.469.720-65', '1995-04-26', 4, 'Karly Hoy');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (5, '440.385.710-84', '1980-09-13', 5, 'Stefan Crimmins');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (6, '507.795.030-07', '1988-02-20', 6, 'Hilton Bricket');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (7, '347.359.870-45', '1992-03-13', 7, 'Janot Beisley');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (8, '590.376.420-71', '1997-02-24', 8, 'Crosby Buesden');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (9, '081.435.820-94', '1992-01-09', 9, 'Lenee Orbell');
insert into paciente (id, cpf, data_nascimento, fisico_id, nome) values (10, '253.059.630-10', '1987-02-01', 10, 'Buddy Cartmail');