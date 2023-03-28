/**
 * Author:  Miguel Castro
 */

CREATE TABLE paciente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255), 
    cpf VARCHAR(255), 
    data_nascimento DATE, 
    genero VARCHAR(255),
    fisico_id BIGINT, 
    PRIMARY KEY (id)
);

