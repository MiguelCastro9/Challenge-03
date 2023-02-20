/**
 * Author:  Miguel Castro
 */

CREATE TABLE paciente (
    id bigint NOT NULL, 
    cpf VARCHAR(255), 
    data_nascimento DATE, 
    nome VARCHAR(255), 
    fisico_id BIGINT, 
    PRIMARY KEY (id)
);

