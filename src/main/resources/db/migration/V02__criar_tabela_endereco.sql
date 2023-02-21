/**
 * Author:  Miguel Castro
 */

CREATE TABLE endereco (
    id BIGINT NOT NULL AUTO_INCREMENT, 
    bairro VARCHAR(255) NOT NULL, 
    cidade VARCHAR(255) NOT NULL, 
    complemento VARCHAR(255), 
    numero INTEGER NOT NULL, 
    rua VARCHAR(255) NOT NULL, 
    paciente_id BIGINT, 
    PRIMARY KEY (id)
);

