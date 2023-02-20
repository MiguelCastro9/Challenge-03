/**
 * Author:  Miguel Castro
 */

CREATE TABLE endereco (
    id bigint NOT NULL, 
    bairro VARCHAR(255) NOT NULL, 
    cidade VARCHAR(255) NOT NULL, 
    complemento VARCHAR(255), 
    numero INTEGER NOT NULL, 
    rua VARCHAR(255) NOT NULL, 
    paciente_id bigint, 
    PRIMARY KEY (id)
);

